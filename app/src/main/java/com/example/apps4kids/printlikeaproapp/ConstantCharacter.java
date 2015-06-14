package com.example.apps4kids.printlikeaproapp;

import android.graphics.*;

import java.util.ArrayList;

/**
 * Created by peter on 15-06-13.
 */
public class ConstantCharacter {
    public static final float cStartX = 100;
    public static final float cStartY = 600;
    public static final float POINT_OFFSET_X = 0;
    public static final float POINT_OFFSET_Y = 0;
    public static final double THRESHOLD = 10000;
    public static final int STROKE_POINT_THRESHOLD = 1;
    public static  ArrayList<StrokePath> PATH_E = new ArrayList<>();
    public static  ArrayList<StrokePath> PATH_L = new ArrayList<>();
    public ConstantCharacter(){
        addPathE();
        addPathL();
    }

    public void addPathE(){
        PATH_E.removeAll(PATH_E);
        StrokePath strokePath = new StrokePath();
        strokePath.points.add(new Point(200, 60));
        strokePath.points.add(new Point(270, 60));
        strokePath.points.add(new Point(340, 60));
        strokePath.points.add(new Point(410, 60));
        strokePath.points.add(new Point(480, 60));
        strokePath.direction = StrokeDirection.RIGHT; //First stoke of E is from left to right. The arrow should point to right.
        //Add sound effect for each stroke
        strokePath.soundUri = ""; // can link to our resource file
        PATH_E.add(strokePath);

        StrokePath strokePath1 = new StrokePath();
        strokePath1.points.add(new Point(200, 60));
        strokePath1.points.add(new Point(200, 140));
        strokePath1.points.add(new Point(200, 200));
        strokePath1.points.add(new Point(200, 280));
        strokePath1.points.add(new Point(200, 360));
        strokePath1.points.add(new Point(200, 420));
        strokePath1.points.add(new Point(200, 490));
        strokePath1.points.add(new Point(200, 560));
        strokePath1.direction = StrokeDirection.DOWN;
        strokePath1.soundUri = ""; // can link to our resource file for down.
        PATH_E.add(strokePath1);
        StrokePath strokePath2 = new StrokePath();
        strokePath2.points.add(new Point(200, 300));
        strokePath2.points.add(new Point(270, 300));
        strokePath2.points.add(new Point(340, 300));
        strokePath2.points.add(new Point(410, 300));
        strokePath2.points.add(new Point(480, 300));
        strokePath2.direction = StrokeDirection.RIGHT;
        strokePath2.soundUri = "";
        PATH_E.add(strokePath2);
        StrokePath strokePath3 = new StrokePath();
        strokePath3.points.add(new Point(200, 560));
        strokePath3.points.add(new Point(270, 560));
        strokePath3.points.add(new Point(340, 560));
        strokePath3.points.add(new Point(410, 560));
        strokePath3.points.add(new Point(480, 560));
        strokePath3.direction = StrokeDirection.RIGHT;
        strokePath3.soundUri = "";
        PATH_E.add(strokePath3);
    }

    public void addPathL(){
        PATH_L.removeAll(PATH_L);


        StrokePath strokePath1 = new StrokePath();
        strokePath1.points.add(new Point(200, 60));
        strokePath1.points.add(new Point(200, 140));
        strokePath1.points.add(new Point(200, 200));
        strokePath1.points.add(new Point(200, 280));
        strokePath1.points.add(new Point(200, 360));
        strokePath1.points.add(new Point(200, 420));
        strokePath1.points.add(new Point(200, 490));
        strokePath1.points.add(new Point(200, 560));
        strokePath1.direction = StrokeDirection.DOWN;
        strokePath1.soundUri = ""; // can link to our resource file for down.
        PATH_L.add(strokePath1);

        StrokePath strokePath3 = new StrokePath();
        strokePath3.points.add(new Point(200, 560));
        strokePath3.points.add(new Point(270, 560));
        strokePath3.points.add(new Point(340, 560));
        strokePath3.points.add(new Point(410, 560));
        strokePath3.points.add(new Point(480, 560));
        strokePath3.direction = StrokeDirection.RIGHT;
        strokePath3.soundUri = "";
        PATH_L.add(strokePath3);
    }

}


