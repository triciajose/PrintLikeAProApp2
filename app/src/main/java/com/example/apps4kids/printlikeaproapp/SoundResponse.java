package com.example.apps4kids.printlikeaproapp;
import android.media.MediaPlayer;
import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by alekh_000 on 2015-06-13.
 Class will provide all the method and file implementations of voices.
 Call this file wherever you need a sound.
 */


public class SoundResponse {

    // Play a sound file.
    // If un-successful, throw an IOException.
    public void playSoundFile(String file_name) {
        // First we're creating the pathway that the file will reside in.

        try {
            String filePath = Environment.getExternalStorageDirectory().getPath() + "/Music/" +
                    file_name;
            MediaPlayer our_player = new MediaPlayer();
            our_player.setDataSource(filePath);
            our_player.prepare();
            our_player.start();
        } catch (IOException b) {
            b.getMessage();
        }

    }

    // Slideback voice file.
    public void playSlideBack() {
        String slide_back = "slideback.mp3";
        playSoundFile(slide_back);
    }

    public void playLift() {
        String play_lift = "lift.mp3";
        playSoundFile(play_lift);
    }

    public void playSlide() {
        String slide = "slide.mp3";
        playSoundFile(slide);
    }

    public void playDown() {
        String down = "down.mp3";
        playSoundFile(down);
    }

    public void playAcrossTheMiddle() {
        String atm = "acrossthemiddle.mp3";
        playSoundFile(atm);
    }

    public void playForward() {
        String pf = "forward.mp3";
        playSoundFile(pf);
    }

    public void playClose() {
        String close = "close.mp3";
        playSoundFile(close);
    }

    public void playCurve() {
        String curve = "curve.mp3";
        playSoundFile(curve);
    }

    public void playAcross() {
        String across = "across.mp3";
        playSoundFile(across);
    }

    public void playAcrossTheTop() {
        String patt = "acrossthetop.mp3";
        playSoundFile(patt);
    }

    public void playAcrossTheBottom() {
        String patb = "acrossthebottom.mp3";
        playSoundFile(patb);
    }

    public void playMiddle() {
        String mid = "middle.mp3";
        playSoundFile(mid);
    }

    public void playBottom() {
        String bot = "bottom.mp3";
        playSoundFile(bot);
    }

    public void playStraight() {
        String straight = "straight.mp3";
        playSoundFile(straight);
    }

    public void playStraightBack() {
        String sb = "straightback.mp3";
        playSoundFile(sb);
    }

    public void playStraightUp() {
        String su = "straightup.mp3";
        playSoundFile(su);
    }

    public void playSlideDown() {
        String sd = "slidedown.mp3";
        playSoundFile(sd);
    }

    public void playAround() {
        String around = "around.mp3";
        playSoundFile(around);
    }

    public void playCurveBack() {
        String curveback = "curveback.mp3";
        playSoundFile(curveback);
    }

    public void playCurveForward() {
        String curveforward = "curveforward.mp3";
        playSoundFile(curveforward);
    }

    public void playShortSlideDown() {
        String ssd = "shortslidedown.mp3";
        playSoundFile(ssd);
    }

    public void playDot() {
        String dot = "dot.mp3";
        playSoundFile(dot);
    }

    public void playDig() {
        String dig = "dig.mp3";
        playSoundFile(dig);
    }

    public void playGoodJob() {
        String gj = "goodjob.mp3";
        playSoundFile(gj);
    }

    public void playLetterA() {
        String a = "letterA.mp3";
        playSoundFile(a);
    }

    public void playLetterB() {
        String b = "letterB.mp3";
        playSoundFile(b);
    }

    public void playLetterC() {
        String c = "letterC.mp3";
        playSoundFile(c);
    }

    public void playLetterD() {
        String d = "letterD.mp3";
        playSoundFile(d);
    }

    public void playLetterE() {
        String e = "letterE.mp3";
        playSoundFile(e);
    }

    public void playLetterF() {
        String f = "letterF.mp3";
        playSoundFile(f);
    }

    public void playLetterG() {
        String g = "letterG.mp3";
        playSoundFile(g);
    }

    public void playLetterH() {
        String h = "letterH.mp3";
        playSoundFile(h);
    }
    public void playLetterI(){
        String i = "letterI.mp3";
        playSoundFile(i);
    }
    public void playLetterJ(){
        String j = "letterJ.mp3";
        playSoundFile(j);
    }
    public void playLetterK(){
        String k = "letterK.mp3";
        playSoundFile(k);
    }
    public void playLetterL(){
        String l = "letterL.mp3";
        playSoundFile(l);
    }
    public void playLetterM(){
        String m = "letterM.mp3";
        playSoundFile(m);
    }
    public void playLetterN(){
        String n = "letterN.mp3";
        playSoundFile(n);
    }
    public void playLetterO(){

        String o = "letterO.mp3";
        playSoundFile(o);
    }
    public void playLetterP(){
        String p = "letterP.mp3";
        playSoundFile(p);
    }
    public void playLetterQ(){
        String q = "letterQ.mp3";
        playSoundFile(q);
    }
    public void playLetterR(){
        String r = "letterR.mp3";
        playSoundFile(r);
    }
    public void playLetterS(){
        String s = "letterS.mp3";
        playSoundFile(s);
    }
    public void playLetterT(){
        String t = "letterT.mp3";
        playSoundFile(t);
    }
    public void playLetterU(){
        String u = "letterU.mp3";
        playSoundFile(u);
    }
    public void playLetterV(){
        String v = "letterV.mp3";
        playSoundFile(v);
    }
    public void playLetterW(){
        String w = "letterW.mp3";
        playSoundFile(w);
    }
    public void playLetterX(){
        String x = "letterX.mp3";
        playSoundFile(x);
    }
    public void playLetterY(){
        String y = "letterY.mp3";
        playSoundFile(y);
    }
    public void playLetterZ(){
        String z = "letterZ.mp3";
        playSoundFile(z);
    }
    // Create a method that outputs some sound file.
    // Create a billion methods that read various wav files or mp3s.

}
