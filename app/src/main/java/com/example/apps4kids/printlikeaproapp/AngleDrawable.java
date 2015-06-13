package com.example.apps4kids.printlikeaproapp;

import android.graphics.Point;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;

/**
 * Created by peter on 15-06-13.
 */
public class AngleDrawable extends ShapeDrawable {
    public double angle;
    public Point rotatePoint;

    public AngleDrawable(double angle, Point point, Shape mShape){
        super(mShape);
        this.rotatePoint = point;
        this.angle = angle;
    }
}
