package com.example.apps4kids.printlikeaproapp;

/**
 * Created by Boya on 2015-06-13.
 */
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.Button;

import java.util.ArrayList;

/*double caching*/
public class DrawView extends View {
    int showPoints=0;
    int animationIndex = 0;
    int interpolateIndex = 1;
    float preX;
    float preY;
    private Path pathUser;
    private Path pathAnimation;
    private Paint paintNumber=null;
    private Paint paintUser =null;
    private Paint paintAnimation = null;
    boolean inAnimation = false;
    int strokeCount =1;
    String pointString ="";
    public static String newline = System.getProperty("line.separator");
    //    int VIEW_WIDTH;
//    int VIEW_HEIGHT;
    final int VIEW_WIDTH = 960;
    final int VIEW_HEIGHT = 1440;
    int indexStroke = 0;
    int numStroke = 0;
    int countPoint = 0;
    Bitmap solidLineBitmap;
    Bitmap dotLineBitmap;
    Rect uprect;
    Rect bottomrect;
    Rect middlerect;
    ArrayList<Boolean> strokePointMatch = new ArrayList<Boolean>();
    ArrayList<Point> strokePoints = new ArrayList<>();
    ArrayList<StrokePath> strokes = new ArrayList<>();
    boolean moveResult = true;
    ArrayList<Point> detectPoints = new ArrayList<>();
    Bitmap cacheBitmap = null;	 //Define a bitmap as a cache
    Canvas cacheCanvas = null;	 //Define a canvas
    Context context;
    String mCharacter = "";
    GameMode gameMode = GameMode.ALLPOINTS;
    Animation jiggle;
    PrintCharacterActivity activity;

    public static StrokeDirection strokeDirection;

    SoundManager soundManager;

    /*----------------------Constructor---------------------------*/
    public DrawView(Context context, AttributeSet set)
    {
        super(context, set);
        this.context = context;
        this.activity = (PrintCharacterActivity) context;
        this.mCharacter = activity.mChracter;
        this.gameMode = activity.gameMode;
        this.soundManager = new SoundManager(this.context);
        init();

    }
    /*---------------------Touch Event Listener----------------------------*/
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                pathUser.moveTo(x, y);
                preX = x;
                preY = y;
//                pointString ="";
//                pointString+=newline;
//                pointString+="{"+String.format("%.0f", x-ConstantCharacter.POINT_OFFSET_X) + ", " + String.format("%.0f", y-ConstantCharacter.POINT_OFFSET_Y) + "},";
                moveResult = true;
                break;
            case MotionEvent.ACTION_MOVE:
                pathUser.quadTo(preX, preY, x, y);
                preX = x;
                preY = y;
//                pointString+=newline;
//                if(countPoint==12) {
//                    countPoint = 0;
//                    pointString+="{"+String.format("%.0f", x-ConstantCharacter.POINT_OFFSET_X) + ", " + String.format("%.0f", y-ConstantCharacter.POINT_OFFSET_Y) + "},";
//                }
//                else{
//                    countPoint++;
//                }
                moveResult = checkMove((int) x, (int) y);
                if(!moveResult){
                    pathUser.reset();
                }
                break;
            case MotionEvent.ACTION_UP:
//                pointString+=newline;
//                pointString+="{"+String.format("%.0f", x-ConstantCharacter.POINT_OFFSET_X) + ", " + String.format("%.0f", y-ConstantCharacter.POINT_OFFSET_Y) + "}";
//                Log.i("pointString", pointString);
                boolean strokeResult = checkStroke();
                if(!strokeResult){
                    pathUser.reset();
                }
                else{
                    cacheCanvas.drawPath(pathUser, paintUser);
                }
                pathUser.reset();
                break;
        }
        invalidate();
        return true;	//The event has been dealt
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint bmpPaint = new Paint();
        //a.draw cacheBitmap to Canvas
        //      canvas.drawBitmap(solidLineBitmap, null, uprect, bmpPaint);
        //      canvas.drawBitmap(solidLineBitmap, null, bottomrect, bmpPaint);
        //      canvas.drawBitmap(dotLineBitmap, null, middlerect, bmpPaint);

        canvas.drawBitmap(cacheBitmap, 0, 0, bmpPaint);
        //b.Draw along the pathUser
        canvas.drawPath(pathUser, paintUser);
        if(inAnimation) {
            if(animationIndex<strokePoints.size()-1) {
                Point fromPoint = strokePoints.get(animationIndex);
                Point toPoint = strokePoints.get(animationIndex + 1);
                Point subPoint = new Point((int)((1-interpolateIndex/5.0)*fromPoint.x+(interpolateIndex/5.0)*toPoint.x), (int)((1-interpolateIndex/5.0)*fromPoint.y+(interpolateIndex/5.0)*toPoint.y));
                pathAnimation.quadTo(fromPoint.x, fromPoint.y, subPoint.x, subPoint.y);
                canvas.drawPath(pathAnimation, paintAnimation);
                interpolateIndex++;
                if(interpolateIndex>5){
                    interpolateIndex = 0;
                    animationIndex++;
                }
                postInvalidateDelayed(20);
            }
            else{
                inAnimation = false;
                postInvalidateDelayed(500);

            }


        }
    }

    boolean checkMove(int x, int y){
        if(!this.moveResult){
            return false;
        }
        Point point = new Point(x, y);
//        Log.i("x: " + x, "y: " + y);
        boolean tmp = false;
        int i =0;
        for(Point dp: strokePoints){
            if(distanceBetweenPoints(point, dp) < ConstantCharacter.THRESHOLD){
                tmp = true;
                strokePointMatch.set(i, true);
            }
            i++;
        }
        if(!tmp){
  //          failStroke();
        }
        return tmp;
    }

    double distanceBetweenPoints(Point p1, Point p2){
        double result = Math.pow(p1.x-p2.x, 2)+Math.pow(p1.y-p2.y, 2);
        return result;
    }

    boolean checkStroke(){
        if(moveResult){
            int count = 0;
            for(Boolean bo: strokePointMatch){
                if(!bo){
                    count++;
                }
            }
            double percentage = ((double) (count))/((double) (strokePointMatch.size()));
            if(percentage < ConstantCharacter.STROKE_POINT_THRESHOLD){
                indexStroke++;
                if(indexStroke < numStroke) {
                    initCharacterStroke();

                }
                else{
                    PrintCharacterActivity.state=State.success;
                    characterSucess();
                }
                return true;
            }
        }
        failStroke();
        return false;
    }

    public void initCharacterStroke(){
        strokePoints.removeAll(strokePoints);
        strokePointMatch.removeAll(strokePointMatch);
        if(indexStroke<strokes.size()) {
            for (Point point : strokes.get(indexStroke).points) {
                Point sPoint = new Point((int) (point.x + ConstantCharacter.POINT_OFFSET_X), (int) (point.y + ConstantCharacter.POINT_OFFSET_Y));
                strokePoints.add(sPoint);
                strokePointMatch.add(false);
            }
            Point point = strokePoints.get(0);
            int x = (int) (point.x);
            int y = (int) (point.y);
            this.strokeDirection = strokes.get(indexStroke).direction;
            switch (strokes.get(indexStroke).direction) {
                case LEFT:
                    cacheCanvas.drawText(Integer.toString(indexStroke+1),x+40,y-10,paintNumber);
                    new Arrow(cacheCanvas).drawAL(x + 30, y - 10, x - 50, y - 10);
                    break;
                case DOWN:
                    cacheCanvas.drawText(Integer.toString(indexStroke+1),x+40,y,paintNumber);
                    new Arrow(cacheCanvas).drawAL(x + 30, y - 10, x + 30, y + 70);
                    break;
                case RIGHT:
                    new Arrow(cacheCanvas).drawAL(x + 30, y + 10, x + 110, y + 10);
                    cacheCanvas.drawText(Integer.toString(indexStroke+1), x + 20, y - 10, paintNumber);
                    break;
                case SLIDE_BACK:
                    cacheCanvas.drawText(Integer.toString(indexStroke+1),x+30,y-10,paintNumber);
                    new Arrow(cacheCanvas).drawAL(x + 30, y - 10, x - 30, y + 50);
                    break;
                case SLIDE_FORWARD:
                    cacheCanvas.drawText(Integer.toString(indexStroke+1),x+40,y-10,paintNumber);
                    new Arrow(cacheCanvas).drawAL(x + 30, y - 10, x + 90, y + 50);
                    break;
                case SLIDE_UP:
                    cacheCanvas.drawText(Integer.toString(indexStroke+1),x+30,y-10,paintNumber);
                    new Arrow(cacheCanvas).drawAL(x + 30, y - 10, x + 90, y - 70);
                    break;
                case CURVE_BACK:
                    cacheCanvas.drawText(Integer.toString(indexStroke+1),x-40,y-100,paintNumber);
                    new Arrow(cacheCanvas).drawArcAL(x - 120, y-110, 270 , 90, x-120+50, y-110, -1,0);
                    break;
                case CURVE_FORWARD:
                    cacheCanvas.drawText(Integer.toString(indexStroke+1),x+15,y-100,paintNumber);
                    new Arrow(cacheCanvas).drawArcAL(x + 20, y - 110, 180, 90, x+20+50,y-110,1,0);
                    break;
                default:
                    break;
            }
            Log.i("indexStroke", "" + indexStroke);
        }
        if(PrintCharacterActivity.stage==Stage.BUBBLE)
        animateStroke();
    }

    public void characterSucess() {

        Log.i("characterSucess", "Sucessfully draw a character");
        soundManager.annouceResult(true);
        activity.showWooHoo();
    //        ImageView imageView = (ImageView) findViewById(R.id.goodjob_iv);

//        imageView.clearAnimation();
//
//        Animation appear = AnimationUtils.loadAnimation(
//                this, R.anim.abc_slide_in_bottom);
//
//        jiggle = AnimationUtils.loadAnimation(this, R.anim.jiggle);
//
//        AnimationSet animationSet = new AnimationSet(true);
//        animationSet.addAnimation(appear);
//        animationSet.addAnimation(jiggle);
//        animationSet.setDuration(3000);
//
//        imageView.sitartAnimation(animationSet);
    }

    public void failStroke(){
        Log.i("doing wrong", "");
        soundManager.annouceResult(false);
    }


    public void animateStroke(){
        if(strokePoints.size()>0) {
            inAnimation = true;
            animationIndex = 0;
            Point start = strokePoints.get(0);
            pathAnimation.reset();
            pathAnimation.moveTo((float) start.x, (float) start.y);
            invalidate();
            soundManager.announceDirection(strokeDirection);

        }
//        for(int animationIndex = 1; animationIndex<=strokePoints.size(); animationIndex++) {
//            //By default, the Textsize is in pixel for canvas.
//            Point start = strokePoints.get(0);
//            pathAnimation.moveTo((float) start.x, (float) start.y);
//            Point prePoint = start;
//            for (int i = 0; i < animationIndex; i++) {
//                Point curPoint = strokePoints.get(i);
//                pathAnimation.quadTo(prePoint.x, prePoint.y, curPoint.x, curPoint.y);
//                prePoint = curPoint;
//            }
//            postInvalidate();
//        }
//        try {
//            Thread.sleep(500);
//            pathAnimation.reset();
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
    }
    public void initDrawView(){
        //draw character
             if(PrintCharacterActivity.stage==Stage.BUBBLE) {
                 Log.i("cStartX", "" + ConstantCharacter.cStartX);
                 Log.i("cStartY", "" + ConstantCharacter.cStartY);

                 AssetManager assetManager = this.context.getAssets();
                 Typeface plain;
                 if(mCharacter.equals("u") || mCharacter.equals("q")) {
                     plain = Typeface.createFromAsset(assetManager, "tekton2.ttf");
                 }
                 else{
                     plain = Typeface.createFromAsset(assetManager, "ufonts.com_century-gothic.ttf");
                 }
                 Typeface bold = Typeface.create(plain, Typeface.BOLD);
                 paintUser.setTypeface(bold);
                 cacheCanvas.drawText(mCharacter, 0, ConstantCharacter.cStartY, paintUser);
             }
        //     cacheCanvas.drawText(mCharacter, 0, 0, paintUser);

        ConstantCharacter initCharacters = new ConstantCharacter();
        //draw points
        paintUser.setColor(Color.GREEN);
        paintUser.setStyle(Paint.Style.FILL);
        paintUser.setStrokeWidth(5);
        detectPoints.removeAll(detectPoints);
        strokes.removeAll(strokes);
        strokes.addAll(ConstantCharacter.map.get(mCharacter));
        numStroke = strokes.size();
        for(StrokePath strokePath : strokes) {
            for (Point point : strokePath.points) {
//                if(/*PrintCharacterActivity.stage==Stage.DOTS && */ gameMode == GameMode.ALLPOINTS) {
                if(PrintCharacterActivity.stage==Stage.DOTS && gameMode == GameMode.ALLPOINTS) {
                    //if(true){
                    cacheCanvas.drawCircle(point.x + ConstantCharacter.POINT_OFFSET_X, point.y + ConstantCharacter.POINT_OFFSET_Y, 10, paintUser);
                    paintUser.setColor(Color.BLACK);
                    paintUser.setStyle(Paint.Style.STROKE);
                    cacheCanvas.drawCircle(point.x + ConstantCharacter.POINT_OFFSET_X, point.y + ConstantCharacter.POINT_OFFSET_Y, 10, paintUser);
                    paintUser.setColor(Color.GREEN);
                    paintUser.setStyle(Paint.Style.FILL);
                }
                if(gameMode == GameMode.CURRENTSTROKE) {

                }
                detectPoints.add(point);
            }
        }
        //Draw the starting point
        if(PrintCharacterActivity.stage!=Stage.EMPTY){
            Point point=strokes.get(0).points.get(0);
            paintUser.setColor(Color.YELLOW);
            paintUser.setStyle(Paint.Style.FILL);
            cacheCanvas.drawCircle(point.x + ConstantCharacter.POINT_OFFSET_X, point.y + ConstantCharacter.POINT_OFFSET_Y,10, paintUser);
            paintUser.setColor(Color.BLACK);
            paintUser.setStyle(Paint.Style.STROKE);
            cacheCanvas.drawCircle(point.x + ConstantCharacter.POINT_OFFSET_X, point.y + ConstantCharacter.POINT_OFFSET_Y, 10, paintUser);
        }
        //Draw the ending point
        if(PrintCharacterActivity.stage==Stage.BUBBLE || PrintCharacterActivity.stage==Stage.DOTS){
            Point point=strokes.get(strokes.size()-1).points.get(strokes.get(strokes.size()-1).points.size()-1);
            paintUser.setColor(Color.RED);
            paintUser.setStyle(Paint.Style.FILL);
            cacheCanvas.drawCircle(point.x + ConstantCharacter.POINT_OFFSET_X, point.y + ConstantCharacter.POINT_OFFSET_Y,10, paintUser);
            paintUser.setColor(Color.BLACK);
            paintUser.setStyle(Paint.Style.STROKE);
            cacheCanvas.drawCircle(point.x + ConstantCharacter.POINT_OFFSET_X, point.y + ConstantCharacter.POINT_OFFSET_Y, 10, paintUser);
        }

    }
    public void initPaint(){
        paintUser = new Paint(Paint.DITHER_FLAG);	 //Create a brush
        paintUser.setColor(Color.YELLOW);	 //Color
        paintUser.setStyle(Paint.Style.STROKE);	 //Style
        paintUser.setAntiAlias(true);	 //
        paintUser.setDither(true);
        paintUser.setStrokeWidth(20);
        paintUser.setStrokeJoin(Paint.Join.ROUND);
        paintUser.setStrokeCap(Paint.Cap.ROUND);

        paintAnimation = new Paint(Paint.DITHER_FLAG);	 //Create a brush
        paintAnimation.setColor(Color.BLUE);	 //Color
        paintAnimation.setStyle(Paint.Style.STROKE);	 //Style
        paintAnimation.setAntiAlias(true);	 //
        paintAnimation.setDither(true);
        paintAnimation.setStrokeWidth(20);
    }
    public void init(){

        indexStroke=0;
        pathUser = new Path();
        pathAnimation = new Path();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
//        VIEW_WIDTH = (size.x );
//        VIEW_HEIGHT = ( size.y);

        //1.Create a bitmap cache, whose size is the same as View
        cacheBitmap = Bitmap.createBitmap(ConstantCharacter.cSizeX, ConstantCharacter.cSizeY, Config.ARGB_8888);
        //2.CacheCanvas will draw into bitmap
        cacheCanvas = new Canvas();
        cacheCanvas.setBitmap(cacheBitmap);
        //CacheCanvas will draw the box
        if(PrintCharacterActivity.stage==Stage.BOX)
        cacheCanvas.drawColor(Color.GRAY);

        //3.Set up the brush
        paintUser = new Paint(Paint.DITHER_FLAG);	 //Create a brush
        //By default, the Textsize is in pixel for canvas.
        paintUser.setStyle(Paint.Style.FILL);
        AssetManager assetManager = this.context.getAssets();
        Typeface plain = Typeface.createFromAsset(assetManager, "ufonts.com_century-gothic.ttf");
        Typeface bold = Typeface.create(plain, Typeface.BOLD);
        paintUser.setTypeface(bold);
        paintUser.setColor(Color.GRAY);
        paintUser.setTextSize(400);

        //Set up the bruth for painting numbers;
        paintNumber=new Paint();
        paintNumber.setColor(Color.RED);
        paintNumber.setTextSize(30);


        //4.Draw the initial Character;
        initDrawView();

//        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//        Display display = wm.getDefaultDisplay();
//        Point size = new Point();
//        display.getSize(size);
        int width = size.x;

        uprect = new Rect(0, (int)  ConstantCharacter.upSolidY, width, (int) (ConstantCharacter.upSolidY+ConstantCharacter.solidLineWidth));
        middlerect = new Rect(0, (int)  ConstantCharacter.dotY, width, (int) (ConstantCharacter.dotY+ConstantCharacter.solidLineWidth));
        bottomrect = new Rect(0, (int)  ConstantCharacter.bottomSolidY, width, (int) (ConstantCharacter.bottomSolidY+ConstantCharacter.solidLineWidth));

        solidLineBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.solidline);
        dotLineBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.dotline);

        //5.Set up the brush for users
        initPaint();

        //6. initCharacterStroke
        initCharacterStroke();

        invalidate();
    }

}
