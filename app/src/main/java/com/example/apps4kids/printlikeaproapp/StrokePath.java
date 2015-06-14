package com.example.apps4kids.printlikeaproapp;

import android.graphics.Point;

import java.util.ArrayList;

/**
 * Created by peter on 15-06-13.
 */
public class StrokePath {
    public ArrayList<Point> points = new ArrayList<>(0);
    public StrokeDirection direction = StrokeDirection.NOWHERE;
    public String soundUri = "";
}