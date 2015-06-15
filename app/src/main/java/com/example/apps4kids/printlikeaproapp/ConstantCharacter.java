package com.example.apps4kids.printlikeaproapp;

import android.graphics.*;

import java.util.ArrayList;

/**
 * Created by peter on 15-06-13.
 */
public class ConstantCharacter {
    public static float cStartX = 300;
    public static float cStartY = 1000;
    public static float upSolidY = cStartY - 600;
    public static float bottomSolidY = cStartY + 300;
    public static float dotY = (upSolidY+bottomSolidY)/2;
    public static float solidLineWidth = 20;
    public static final float POINT_OFFSET_X = 200;
    public static final float POINT_OFFSET_Y = 400;
    public static final double THRESHOLD = 10000;
    public static final int STROKE_POINT_THRESHOLD = 1;
    public static ArrayList<StrokePath> PATH_E = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_L = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_I = new ArrayList<>();
    public static  ArrayList<StrokePath> PATH_F = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_T = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_l = new ArrayList<>();
    public static ArrayList<StrokePath> PATH_P = new ArrayList<>();


    public ConstantCharacter() {
        addPathE();
        addPathL();
        addPathI();
        addPathF();
        addPathT();
        addPathl();
        addPathP();

    }

    public void addPathE() {
        PATH_E.removeAll(PATH_E);

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
        strokePath2.points.add(new Point(200, 60));
        strokePath2.points.add(new Point(270, 60));
        strokePath2.points.add(new Point(340, 60));
        strokePath2.points.add(new Point(410, 60));
        strokePath2.points.add(new Point(480, 60));
        strokePath2.direction = StrokeDirection.RIGHT; //First stoke of E is from left to right. The arrow should point to right.
        //Add sound effect for each stroke
        strokePath2.soundUri = ""; // can link to our resource file
        PATH_E.add(strokePath2);

        StrokePath strokePath3 = new StrokePath();
        strokePath3.points.add(new Point(200, 300));
        strokePath3.points.add(new Point(270, 300));
        strokePath3.points.add(new Point(340, 300));
        strokePath3.points.add(new Point(410, 300));
        strokePath3.points.add(new Point(480, 300));
        strokePath3.direction = StrokeDirection.RIGHT;
        strokePath3.soundUri = "";
        PATH_E.add(strokePath3);

        StrokePath strokePath4 = new StrokePath();
        strokePath4.points.add(new Point(200, 560));
        strokePath4.points.add(new Point(270, 560));
        strokePath4.points.add(new Point(340, 560));
        strokePath4.points.add(new Point(410, 560));
        strokePath4.points.add(new Point(480, 560));
        strokePath4.direction = StrokeDirection.RIGHT;
        strokePath4.soundUri = "";
        PATH_E.add(strokePath4);
    }


    public void addPathF(){
        PATH_F.removeAll(PATH_F);

        StrokePath strokePath1 = new StrokePath();
        strokePath1.points.add(new Point(200, 60));
        strokePath1.points.add(new Point(200, 140));
        strokePath1.points.add(new Point(200, 200));
        strokePath1.points.add(new Point(200, 280));
        strokePath1.points.add(new Point(200, 360));
        strokePath1.points.add(new Point(200, 420));
        strokePath1.points.add(new Point(200, 490));
        strokePath1.points.add(new Point(200, 560));
        strokePath1.points.add(new Point(210, 60));
        strokePath1.points.add(new Point(210, 140));
        strokePath1.points.add(new Point(210, 200));
        strokePath1.points.add(new Point(210, 280));
        strokePath1.points.add(new Point(210, 360));
        strokePath1.points.add(new Point(210, 420));
        strokePath1.points.add(new Point(210, 490));
        strokePath1.points.add(new Point(210, 560));
        strokePath1.direction = StrokeDirection.DOWN;
        strokePath1.soundUri = ""; // can link to our resource file for down.
        PATH_F.add(strokePath1);

        StrokePath strokePath2 = new StrokePath();
        strokePath2.points.add(new Point(200, 60));
        strokePath2.points.add(new Point(270, 60));
        strokePath2.points.add(new Point(340, 60));
        strokePath2.points.add(new Point(410, 60));
        strokePath2.points.add(new Point(480, 60));
        strokePath2.points.add(new Point(210, 40));
        strokePath2.points.add(new Point(280, 40));
        strokePath2.points.add(new Point(350, 40));
        strokePath2.points.add(new Point(420, 40));
        strokePath2.direction = StrokeDirection.RIGHT; //First stoke of E is from left to right. The arrow should point to right.
        //Add sound effect for each stroke
        strokePath2.soundUri = ""; // can link to our resource file
        PATH_F.add(strokePath2);

        StrokePath strokePath3 = new StrokePath();
        strokePath3.points.add(new Point(200, 300));
        strokePath3.points.add(new Point(270, 300));
        strokePath3.points.add(new Point(340, 300));
        strokePath3.points.add(new Point(410, 300));
        strokePath3.points.add(new Point(480, 300));
        strokePath3.points.add(new Point(210, 280));
        strokePath3.points.add(new Point(280, 280));
        strokePath3.points.add(new Point(350, 280));
        strokePath3.points.add(new Point(420, 280));
        strokePath3.direction = StrokeDirection.RIGHT;
        strokePath3.soundUri = "";
        PATH_F.add(strokePath3);
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

    public void addPathI() {
        PATH_I.removeAll(PATH_I);


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
        PATH_I.add(strokePath1);
    }

    public void addPathP() {
        PATH_P.removeAll(PATH_P);

        StrokePath strokePath1 = new StrokePath();
        strokePath1.points.add(new Point(210, 40));
        strokePath1.points.add(new Point(210, 130));
        strokePath1.points.add(new Point(210, 190));
        strokePath1.points.add(new Point(210, 270));
        strokePath1.points.add(new Point(210, 350));
        strokePath1.points.add(new Point(210, 410));
        strokePath1.points.add(new Point(210, 480));
        strokePath1.points.add(new Point(210, 550));
        strokePath1.direction = StrokeDirection.DOWN;
        strokePath1.soundUri = ""; // can link to our resource file for down.
        PATH_P.add(strokePath1);

        StrokePath strokePath2 = new StrokePath();
        strokePath2.points.add(new Point(210, 40));
        strokePath2.points.add(new Point(280, 40));
        strokePath2.points.add(new Point(350, 40));
        strokePath2.points.add(new Point(420, 50));
        strokePath2.points.add(new Point(490, 100));
        strokePath2.points.add(new Point(510, 170));
        strokePath2.points.add(new Point(490, 240));
        strokePath2.points.add(new Point(410, 290));
        strokePath2.points.add(new Point(350, 290));
        strokePath2.points.add(new Point(280, 290));
        strokePath2.points.add(new Point(210, 290));
        strokePath2.direction = StrokeDirection.RIGHT;
        strokePath2.soundUri = ""; // can link to our resource file for down.
        PATH_P.add(strokePath2);
    }


    public void addPathT() {
        PATH_T.removeAll(PATH_T);


        StrokePath strokePath1 = new StrokePath();
        strokePath1.points.add(new Point(270, 55));
        strokePath1.points.add(new Point(270, 131));
        strokePath1.points.add(new Point(270, 203));
        strokePath1.points.add(new Point(270, 274));
        strokePath1.points.add(new Point(270, 345));
        strokePath1.points.add(new Point(270, 416));
        strokePath1.points.add(new Point(270, 488));
        strokePath1.points.add(new Point(270, 560));
        strokePath1.direction = StrokeDirection.DOWN;
        strokePath1.soundUri = ""; // can link to our resource file for down.
        PATH_T.add(strokePath1);

        StrokePath strokePath3 = new StrokePath();
        strokePath3.points.add(new Point(140, 55));
        strokePath3.points.add(new Point(210, 55));
        strokePath3.points.add(new Point(325, 55));
        strokePath3.points.add(new Point(400, 55));
        strokePath3.direction = StrokeDirection.RIGHT;
        strokePath3.soundUri = "";
        PATH_T.add(strokePath3);
    }

    public void addPathl() {
        PATH_l.removeAll(PATH_l);


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
        PATH_l.add(strokePath1);


    }

}





