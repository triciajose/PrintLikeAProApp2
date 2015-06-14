package com.example.apps4kids.printlikeaproapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.Display;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by peter on 15-06-13.
 */
public class CustomDrawableView extends View {
    private ArrayList<AngleDrawable> myDrawables = new ArrayList<AngleDrawable>();
    public CustomDrawableView(Context context) {
        super(context);


        // A left line
        Point startPoint = new Point(300, 300);
        int width = 300;
        int height = 50;

        AngleDrawable leftLine = new AngleDrawable(120, startPoint, new RectShape());
        leftLine.getPaint().setColor(0xff74AC23);
        leftLine.setBounds(startPoint.x, startPoint.y, startPoint.x + width, startPoint.y + height);
        myDrawables.add(leftLine);


        startPoint = new Point(300, 300);
        width = 300;
        height = 50;

        AngleDrawable rightLine = new AngleDrawable(60, startPoint, new RectShape());
        rightLine.getPaint().setColor(0xff74AC23);
        rightLine.setBounds(startPoint.x, startPoint.y, startPoint.x + width, startPoint.y + height);
        myDrawables.add(rightLine);

        startPoint = new Point(300+25, 300);
        width = 300;
        height = 50;

        AngleDrawable middleLine = new AngleDrawable(60, startPoint, new RectShape());
        rightLine.getPaint().setColor(0xff74AC23);
        rightLine.setBounds(startPoint.x, startPoint.y, startPoint.x + width, startPoint.y + height);
        myDrawables.add(rightLine);
    }

    protected void onDraw(Canvas canvas) {
        for(AngleDrawable d : myDrawables){
            canvas.rotate((float) d.angle, d.rotatePoint.x, d.rotatePoint.y);
            d.draw(canvas);
            canvas.rotate( -(float) d.angle, d.rotatePoint.x, d.rotatePoint.y);

        }
    }
}
