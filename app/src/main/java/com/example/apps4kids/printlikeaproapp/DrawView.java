package com.example.apps4kids.printlikeaproapp;

/**
 * Created by Boya on 2015-06-13.
 */
        import android.content.Context;
        import android.graphics.Bitmap;
        import android.graphics.Bitmap.Config;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
        import android.graphics.Path;
        import android.util.AttributeSet;
        import android.view.MotionEvent;
        import android.view.View;
/*double caching*/
public class DrawView extends View {
    float preX;
    float preY;
    private Path path;
    public Paint paint=null;
    final int VIEW_WIDTH = 960;
    final int VIEW_HEIGHT = 1440;
    Bitmap cacheBitmap = null;	 //Define a bitmap as a cache
    Canvas cacheCanvas = null;	 //Define a canvas
    /*----------------------Constructor---------------------------*/
    public DrawView(Context context, AttributeSet set)
    {
        super(context, set);
        path = new Path();
        //1.Create a bitmap cache, whose size is the same as View
        cacheBitmap = Bitmap.createBitmap(VIEW_WIDTH, VIEW_HEIGHT, Config.ARGB_8888);
        //2.CacheCanvas will draw into bitmap
        cacheCanvas = new Canvas();
        cacheCanvas.setBitmap(cacheBitmap);
        //3.Set up the brush
        paint = new Paint(Paint.DITHER_FLAG);	 //Create a brush
        paint.setColor(Color.RED);	 //Color
        paint.setStyle(Paint.Style.STROKE);	 //Style
        paint.setAntiAlias(true);	 //
        paint.setDither(true);
    }
    /*---------------------Touch Event Listener----------------------------*/
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        //获取拖动事件的发生位置
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                path.quadTo(preX, preY, x, y);
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_UP:
                cacheCanvas.drawPath(path, paint);	//
                path.reset();
                break;
        }
        invalidate();
        return true;	//The event has been dealt
    }
    //	/*--------------------绘图-------------------------*/
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint bmpPaint = new Paint();
        //a.draw cacheBitmap to Canvas
        canvas.drawBitmap(cacheBitmap, 0, 0, bmpPaint);
        //b.Draw along the path
        canvas.drawPath(path, paint);
    }
}
