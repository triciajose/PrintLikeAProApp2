package com.example.apps4kids.printlikeaproapp;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/**
 * Created by Boya on 2015-06-14.
 */
public class Arrow {
    private Canvas myCanvas;
    private Paint myPaint;

    public Arrow(Canvas canvas){
        myCanvas=canvas;
        myPaint=new Paint();
        setPaintDefaultStyle();
    }
    /**
     * Set BrmyPaint=new Paint()ush
     */
    public void setPaintDefaultStyle(){
        myPaint.setAntiAlias(true);
        myPaint.setColor(Color.RED);
        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(10);
    }

    /**
     * Draw a line
     * @param fromX
     * @param fromY
     * @param toX
     * @param toY
     */
    public void drawLine(float fromX,float fromY,float toX,float toY){
        Path linePath=new Path();
        linePath.moveTo(fromX, fromY);
        linePath.lineTo(toX, toY);
        linePath.close();
        myCanvas.drawPath(linePath, myPaint);
    }


    /**
     * Draw an arrow
     * @param sx
     * @param sy
     * @param ex
     * @param ey
     */
    public void drawAL(int sx, int sy, int ex, int ey)
    {
        double H = 8; // The height of the arrow
        double L = 3.5; // The half of the bottom line
        int x3 = 0;
        int y3 = 0;
        int x4 = 0;
        int y4 = 0;
        double awrad = Math.atan(L / H); // angel of the arrow
        double arraow_len = Math.sqrt(L * L + H * H);
        double[] arrXY_1 = rotateVec(ex - sx, ey - sy, awrad, true, arraow_len);
        double[] arrXY_2 = rotateVec(ex - sx, ey - sy, -awrad, true, arraow_len);
        double x_3 = ex - arrXY_1[0]; // (x3,y3)is the first endpoint
        double y_3 = ey - arrXY_1[1];
        double x_4 = ex - arrXY_2[0]; // (x4,y4) is the second endpoint
        double y_4 = ey - arrXY_2[1];
        Double X3 = new Double(x_3);
        x3 = X3.intValue();
        Double Y3 = new Double(y_3);
        y3 = Y3.intValue();
        Double X4 = new Double(x_4);
        x4 = X4.intValue();
        Double Y4 = new Double(y_4);
        y4 = Y4.intValue();
        // DrawLine
        myCanvas.drawLine(sx, sy, ex, ey,myPaint);
        Path triangle = new Path();
        triangle.moveTo(ex, ey);
        triangle.lineTo(x3, y3);
        triangle.lineTo(x4, y4);
        triangle.close();
        myCanvas.drawPath(triangle,myPaint);

    }

    private double[] rotateVec(int px, int py, double ang, boolean isChLen, double newLen)
    {
        double mathstr[] = new double[2];
        double vx = px * Math.cos(ang) - py * Math.sin(ang);
        double vy = px * Math.sin(ang) + py * Math.cos(ang);
        if (isChLen) {
            double d = Math.sqrt(vx * vx + vy * vy);
            vx = vx / d * newLen;
            vy = vy / d * newLen;
            mathstr[0] = vx;
            mathstr[1] = vy;
        }
        return mathstr;
    }

    public void drawArcAL(int left, int top, int sa, int angle, int ex, int ey, int tx, int ty){
        //draw the arrow
        double H = 8; // The height of the arrow
        double L = 3.5; // The half of the bottom line
        int x3 = 0;
        int y3 = 0;
        int x4 = 0;
        int y4 = 0;
        double awrad = Math.atan(L / H); // angel of the arrow
        double arraow_len = Math.sqrt(L * L + H * H);
        double[] arrXY_1 = rotateVec(tx, ty, awrad, true, arraow_len);
        double[] arrXY_2 = rotateVec(tx, ty, -awrad, true, arraow_len);
        double x_3 = ex - arrXY_1[0]; // (x3,y3)is the first endpoint
        double y_3 = ey - arrXY_1[1];
        double x_4 = ex - arrXY_2[0]; // (x4,y4) is the second endpoint
        double y_4 = ey - arrXY_2[1];
        Double X3 = new Double(x_3);
        x3 = X3.intValue();
        Double Y3 = new Double(y_3);
        y3 = Y3.intValue();
        Double X4 = new Double(x_4);
        x4 = X4.intValue();
        Double Y4 = new Double(y_4);
        y4 = Y4.intValue();
        Path triangle = new Path();
        triangle.moveTo(ex, ey);
        triangle.lineTo(x3, y3);
        triangle.lineTo(x4, y4);
        triangle.close();
        myCanvas.drawPath(triangle, myPaint);
        //draw an arc
        myPaint.setStyle(Paint.Style.STROKE);
        RectF oval1 = new RectF(left,top,100+left,100+top);
        myCanvas.drawArc(oval1, sa, angle, false, myPaint);
    }


}
