package com.example.apps4kids.printlikeaproapp;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by alekh_000 on 2015-06-13.
 Class will provide all the method and file implementations of voices.
 Call this file wherever you need a sound.


 A number of commands have been highlighted out until they've been recorded.
 */


public class SoundResponse {

    private MediaPlayer our_player;
    private Context a_context;

    // Play a sound file.
    // If un-successful, throw an IOException.
    public void stopPlayer(){
        if (our_player != null){
            our_player.release();;
            our_player = null;
        }
    }

    public void playSoundFile(int resourceid) {
        // First we're creating the pathway that the file will reside in]
        this.stopPlayer();
        MediaPlayer ours = new MediaPlayer();
        ours = MediaPlayer.create(a_context.getApplicationContext(), resourceid);
        try {
            ours.prepare();
            ours.start();
        } catch (IOException b) {
            b.getMessage();
        }

    }

    /*  // Slideback voice file.
    public void playSlideBack() {
        String slide_back = "slideback.mp3";
        playSoundFile(this, R.raw.);
    }
    */

    public void playLift() {
        int play_lift = R.raw.lift;
        playSoundFile(play_lift);
    }
    /*
    public void playSlide() {
        int slide =
        playSoundFile(slide);
    }
     */
    public void playDown() {
        int down = R.raw.down;
        playSoundFile(down);
    }

    public void playAcrossTheMiddle() {
        int atm = R.raw.aroundthemiddle;
        playSoundFile(atm);
    }

    public void playForward() {
        int pf = R.raw.forward;
        playSoundFile(pf);
    }

    public void playClose() {
        int close = R.raw.close;
        playSoundFile(close);
    }

    public void playCurve() {
        int curve = R.raw.curve;
        playSoundFile(curve);
    }

    public void playAcross() {
        int across = R.raw.across;
        playSoundFile(across);
    }

    public void playAcrossTheTop() {
        int patt = R.raw.acrossthetop;
        playSoundFile(patt);
    }

    public void playAcrossTheBottom() {
        int patb = R.raw.acrossthebottom;
        playSoundFile(patb);
    }

    public void playBottom() {
        int bot = R.raw.bottom;
        playSoundFile(bot);
    }
  /*
    public void playStraight() {
       int straight = R.raw.
        playSoundFile(straight);
    }


    public void playStraightBack() {
        String sb = R.raw.
        playSoundFile(sb);
    }

    public void playStraightUp() {
        String su = "straightup.mp3";
        playSoundFile(su);
    }

    public void playSlideDown() {
        String sd = R.raw.
        playSoundFile(sd);
    }
    */

    public void playAround() {
        int around = R.raw.around;
        playSoundFile(around);
    }

    public void playCurveBack() {
        int curveback = R.raw.curveback;
        playSoundFile(curveback);
    }

    public void playCurveForward() {
        int curveforward = R.raw.curveforward;
        playSoundFile(curveforward);
    }
    /*
    public void playShortSlideDown() {
        int ssd = R.raw.
        playSoundFile(ssd);
    }
    */
    public void playDot() {
        int dot = R.raw.dot;
        playSoundFile(dot);
    }

    public void playDig() {
        int dig = R.raw.dig;
        playSoundFile(dig);
    }

    public void playGoodJob() {
        int gj = R.raw.goodjob;
        playSoundFile(gj);
    }
/*
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
    */
    // Create a method that outputs some sound file.
    // Create a billion methods that read various wav files or mp3s.

}
