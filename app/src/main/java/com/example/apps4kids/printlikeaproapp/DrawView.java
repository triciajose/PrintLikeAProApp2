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
import android.view.animation.AnimationSet;
import android.widget.ImageView;

import java.util.ArrayList;

/*double caching*/
public class DrawView extends View {
    int showPoints=0;
    int animationIndex = 0;
    float preX;
    float preY;
    private Path pathUser;
    private Path pathAnimation;
    private Paint paintUser =null;
    private Paint paintAnimation = null;
    int VIEW_WIDTH;
    int VIEW_HEIGHT;
    int indexStroke = 0;
    int numStroke = 0;
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
    /*----------------------Constructor---------------------------*/
    public DrawView(Context context, AttributeSet set)
    {
        super(context, set);
        this.context = context;
        PrintCharacterActivity activity = (PrintCharacterActivity) context;
        this.mCharacter = activity.mChracter;
        this.gameMode = activity.gameMode;

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
                moveResult = true;
                break;
            case MotionEvent.ACTION_MOVE:
                pathUser.quadTo(preX, preY, x, y);
                preX = x;
                preY = y;
                moveResult = checkMove((int) x, (int) y);
                if(!moveResult){
                    pathUser.reset();
                }
                break;
            case MotionEvent.ACTION_UP:
                boolean strokeResult = checkStroke();
                if(!strokeResult){
                    pathUser.reset();
                }
                else {
                    cacheCanvas.drawPath(pathUser, paintUser);
                }//
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


        canvas.drawBitmap(solidLineBitmap, null, uprect, bmpPaint);
        canvas.drawBitmap(solidLineBitmap, null, bottomrect, bmpPaint);
        canvas.drawBitmap(dotLineBitmap, null, middlerect, bmpPaint);

        canvas.drawBitmap(cacheBitmap, 0, 0, bmpPaint);
        //b.Draw along the pathUser
        canvas.drawPath(pathUser, paintUser);
        canvas.drawPath(pathAnimation, paintAnimation);
    }

    boolean checkMove(int x, int y){
        if(!this.moveResult){
            return false;
        }
        Point point = new Point(x, y);
        Log.i("x: " + x, "y: " + y);
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
            failStroke();
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
            if(count < ConstantCharacter.STROKE_POINT_THRESHOLD){
                indexStroke++;
                if(indexStroke < numStroke) {
                    initCharacterStroke();
                    animateStroke();
                }
                else{
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
        strokePoints.addAll(strokes.get(indexStroke).points);
        strokePointMatch.removeAll(strokePointMatch);
        for(Point point: strokePoints){
            strokePointMatch.add(false);
        }
        switch (strokes.get(indexStroke).direction){
            case DOWN:
                new Arrow(cacheCanvas).drawAL(strokePoints.get(0).x-50,strokePoints.get(0).y+10,strokePoints.get(0).x-50,strokePoints.get(0).y+110);
                break;
            case RIGHT:
                new Arrow(cacheCanvas).drawAL(strokePoints.get(0).x+50,strokePoints.get(0).y+30,strokePoints.get(0).x+150,strokePoints.get(0).y+30);
                break;
            default:break;
        }
        Log.i("indexStroke", "" + indexStroke);
    }

    public void characterSucess() {
        Log.i("characterSucess", "Sucessfully draw a character");
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
//        imageView.startAnimation(animationSet);
    }

    public void failStroke(){
        Log.i("doing wrong", "");
    }


    public void animateStroke(){
        for(int animationIndex = 1; animationIndex<=strokePoints.size(); animationIndex++) {
            //By default, the Textsize is in pixel for canvas.
            Point start = strokePoints.get(0);
            pathAnimation.moveTo((float) start.x, (float) start.y);
            Point prePoint = start;
            for (int i = 0; i < animationIndex; i++) {
                Point curPoint = strokePoints.get(i);
                pathAnimation.quadTo(prePoint.x, prePoint.y, curPoint.x, curPoint.y);
                prePoint = curPoint;
            }
            invalidate();
        }
        try {
            Thread.sleep(500);
            pathAnimation.reset();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void initDrawView(){
        //draw character
        if(PrintCharacterActivity.stage==Stage.BUBBLE)
            cacheCanvas.drawText(mCharacter, ConstantCharacter.cStartX, ConstantCharacter.cStartY, paintUser);

        ConstantCharacter initCharacters = new ConstantCharacter();
        //draw points
        paintUser.setColor(Color.GREEN);
        paintUser.setStyle(Paint.Style.FILL);
        paintUser.setStrokeWidth(50);
        detectPoints.removeAll(detectPoints);
        strokes.removeAll(strokes);
        switch(mCharacter){
            case "A": strokes.addAll(ConstantCharacter.PATH_A); break;
            case "E": strokes.addAll(ConstantCharacter.PATH_E); break;
            case "F": strokes.addAll(ConstantCharacter.PATH_F); break;
            case "L": strokes.addAll(ConstantCharacter.PATH_L); break;
            case "l": strokes.addAll(ConstantCharacter.PATH_l); break;
            case "T": strokes.addAll(ConstantCharacter.PATH_T); break;
            case "P": strokes.addAll(ConstantCharacter.PATH_P); break;
            case "R": strokes.addAll(ConstantCharacter.PATH_R); break;
            case "I": strokes.addAll(ConstantCharacter.PATH_I); break;
            case "i": strokes.addAll(ConstantCharacter.PATH_i); break;
            case "t": strokes.addAll(ConstantCharacter.PATH_t); break;
            default: break;
        }
        numStroke = strokes.size();
        for(StrokePath strokePath : strokes) {
            for (Point point : strokePath.points) {
                if(/*PrintCharacterActivity.stage==Stage.DOTS && */ gameMode == GameMode.ALLPOINTS) {
                    cacheCanvas.drawPoint(point.x + ConstantCharacter.POINT_OFFSET_X, point.y + ConstantCharacter.POINT_OFFSET_Y, paintUser);
                }
                    if(gameMode == GameMode.CURRENTSTROKE) {

                }
                detectPoints.add(point);
            }
        }


    }
    public void initPaint(){
        paintUser = new Paint(Paint.DITHER_FLAG);	 //Create a brush
        paintUser.setColor(Color.RED);	 //Color
        paintUser.setStyle(Paint.Style.STROKE);	 //Style
        paintUser.setAntiAlias(true);	 //
        paintUser.setDither(true);

        paintAnimation = new Paint(Paint.DITHER_FLAG);	 //Create a brush
        paintAnimation.setColor(Color.BLUE);	 //Color
        paintAnimation.setStyle(Paint.Style.STROKE);	 //Style
        paintAnimation.setAntiAlias(true);	 //
        paintAnimation.setDither(true);
        paintAnimation.setStrokeWidth(50);
    }
    public void init(){

        indexStroke=0;
        pathUser = new Path();
        pathAnimation = new Path();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        VIEW_WIDTH = size.x;
        VIEW_HEIGHT = ( size.y);

        //1.Create a bitmap cache, whose size is the same as View
        cacheBitmap = Bitmap.createBitmap(VIEW_WIDTH, VIEW_HEIGHT, Config.ARGB_8888);
        //2.CacheCanvas will draw into bitmap
        cacheCanvas = new Canvas();
        cacheCanvas.setBitmap(cacheBitmap);


        //3.Set up the brush
        paintUser = new Paint(Paint.DITHER_FLAG);	 //Create a brush
        //By default, the Textsize is in pixel for canvas.
        paintUser.setStyle(Paint.Style.FILL);
        AssetManager assetManager = this.context.getAssets();
        Typeface plain = Typeface.createFromAsset(assetManager, "ufonts.com_century-gothic.ttf");
        Typeface bold = Typeface.create(plain, Typeface.BOLD);
        paintUser.setTypeface(bold);
        paintUser.setColor(Color.GRAY);
        paintUser.setTextSize(800);

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
