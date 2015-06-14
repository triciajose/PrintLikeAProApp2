package com.example.apps4kids.printlikeaproapp;

/**
 * Created by Boya on 2015-06-13.
 */
        import android.content.Context;
        import android.content.res.AssetManager;
        import android.graphics.Bitmap;
        import android.graphics.Bitmap.Config;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
        import android.graphics.Path;
        import android.graphics.Point;
        import android.graphics.Typeface;
        import android.util.AttributeSet;
        import android.util.Log;
        import android.view.MotionEvent;
        import android.view.View;

        import java.util.ArrayList;

/*double caching*/
public class DrawView extends View {
    int showPoints=0;
    float preX;
    float preY;
    private Path path;
    public Paint paint=null;
    final int VIEW_WIDTH = 960;
    final int VIEW_HEIGHT = 1440;
    int indexStroke = 0;
    int numStroke = 0;
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

        path = new Path();
        //1.Create a bitmap cache, whose size is the same as View
        cacheBitmap = Bitmap.createBitmap(VIEW_WIDTH, VIEW_HEIGHT, Config.ARGB_8888);
        //2.CacheCanvas will draw into bitmap
        cacheCanvas = new Canvas();
        cacheCanvas.setBitmap(cacheBitmap);


        //3.Set up the brush
        paint = new Paint(Paint.DITHER_FLAG);	 //Create a brush
        //By default, the Textsize is in pixel for canvas.
        paint.setStyle(Paint.Style.FILL);
        AssetManager assetManager = this.context.getAssets();
        Typeface plain = Typeface.createFromAsset(assetManager, "ufonts.com_century-gothic.ttf");
        Typeface bold = Typeface.create(plain, Typeface.BOLD);
        paint.setTypeface(bold);
        paint.setColor(Color.GRAY);
        paint.setTextSize(800);
        cacheCanvas.drawText(mCharacter, ConstantCharacter.cStartX, ConstantCharacter.cStartY, paint);

        ConstantCharacter initCharacters = new ConstantCharacter();

      //  4   draw points.
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(50);
        detectPoints.removeAll(detectPoints);
        strokes.removeAll(strokes);
        switch(mCharacter){
            case "E": strokes.addAll(ConstantCharacter.PATH_E); break;
            default: break;
        }
        numStroke = strokes.size();
        for(StrokePath strokePath : strokes) {
            for (Point point : strokePath.points) {
                if(gameMode == GameMode.ALLPOINTS) {
                    cacheCanvas.drawPoint(point.x + ConstantCharacter.POINT_OFFSET_X, point.y + ConstantCharacter.POINT_OFFSET_Y, paint);
                }
                if(gameMode == GameMode.CURRENTSTROKE) {

                }
                detectPoints.add(point);
            }
        }



        //5.Set up the brush for users
        paint = new Paint(Paint.DITHER_FLAG);	 //Create a brush
        paint.setColor(Color.RED);	 //Color
        paint.setStyle(Paint.Style.STROKE);	 //Style
        paint.setAntiAlias(true);	 //
        paint.setDither(true);

        //initStroke
        initStroke();
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
                path.moveTo(x, y);
                preX = x;
                preY = y;
                moveResult = true;
                break;
            case MotionEvent.ACTION_MOVE:
                path.quadTo(preX, preY, x, y);
                preX = x;
                preY = y;
                moveResult = checkMove((int) x, (int) y);
                if(!moveResult){
                    path.reset();
                }
                break;
            case MotionEvent.ACTION_UP:
                boolean strokeResult = checkStroke();
                if(!strokeResult){
                    path.reset();
                }
                else {
                    cacheCanvas.drawPath(path, paint);
                }//
                path.reset();
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
        canvas.drawBitmap(cacheBitmap, 0, 0, bmpPaint);
        //b.Draw along the path
        canvas.drawPath(path, paint);
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
                    initStroke();
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

    void initStroke(){
        strokePoints.removeAll(strokePoints);
        strokePoints.addAll(strokes.get(indexStroke).points);
        strokePointMatch.removeAll(strokePointMatch);
        for(Point point: strokePoints){
            strokePointMatch.add(false);
        }
        switch (indexStroke){
            case 1:
                new Arrow(cacheCanvas).drawAL(strokePoints.get(0).x-50,strokePoints.get(0).y+10,strokePoints.get(0).x-50,strokePoints.get(0).y+110);
                break;
            default:
                new Arrow(cacheCanvas).drawAL(strokePoints.get(0).x+50,strokePoints.get(0).y+30,strokePoints.get(0).x+150,strokePoints.get(0).y+30);
                break;
        }



        Log.i("indexStroke", ""+indexStroke);
    }

    void characterSucess(){
        Log.i("characterSucess", "Sucessfully draw a character");
        // where cellebration animations should be added.
    }

    void failStroke(){
        Log.i("doing wrong", "");
    }
}
