package com.example.apps4kids.printlikeaproapp;

import android.graphics.*;

import java.util.ArrayList;

/**
 * Created by peter on 15-06-13.
 */
public class ConstantCharacter {
    public static final float cStartX = 100;
    public static final float cStartY = 600;
    public static  ArrayList<PointPath> PATH_E = new ArrayList<>();
    public ConstantCharacter(){
        PATH_E.removeAll(PATH_E);
        PointPath pointPath = new PointPath();
        pointPath.points.add(new Point(300, 300));
        pointPath.points.add(new Point(300, 600));
        PATH_E.add(pointPath);
        PointPath pointPath1 = new PointPath();
        pointPath1.points.add(new Point(300, 300));
        pointPath1.points.add(new Point(300, 700));
        PATH_E.add(pointPath1);
        PointPath pointPath2 = new PointPath();
        pointPath2.points.add(new Point(300, 500));
        pointPath2.points.add(new Point(600, 500));
        PATH_E.add(pointPath2);
        PointPath pointPath3 = new PointPath();
        pointPath3.points.add(new Point(300, 700));
        pointPath3.points.add(new Point(600, 700));
        PATH_E.add(pointPath3);
    }
}
