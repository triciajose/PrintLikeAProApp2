package com.example.apps4kids.printlikeaproapp;

import android.app.Activity;

/**
 * Created by Laurel Chan on 2015-06-18.
 */
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;

public class SoundActivity extends Activity {

    SoundManager snd;
    int across, acrossthebottom, acrossthetop, around, aroundthemiddle, bottom, close, curve, curveback,
            curveforward, dig, dot, down, forward, goodjob, lift, middle, shortslidedown, slide, slideback, slidedown, straight,
            straightback, straightup, tryagain;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_sound);    //I just need help on how to set up the .xml resource


        snd = new SoundManager(this);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        //load samples from res/raw
        across = snd.load(R.raw.across);
        acrossthebottom  = snd.load(R.raw.acrossthebottom);
        acrossthetop = snd.load(R.raw.acrossthetop);
        around = snd.load(R.raw.around);
        aroundthemiddle = snd.load(R.raw.aroundthemiddle);
        bottom = snd.load(R.raw.bottom);
        close = snd.load(R.raw.close);
        curve = snd.load(R.raw.curve);
        curveback = snd.load(R.raw.curveback);
        curveforward = snd.load(R.raw.curveforward);
        dig = snd.load(R.raw.dig);
        dot = snd.load(R.raw.dot);
        down = snd.load(R.raw.down);
        forward = snd.load(R.raw.forward);
        goodjob = snd.load(R.raw.goodjob);
        lift = snd.load(R.raw.lift);
        middle = snd.load(R.raw.middle);
        shortslidedown = snd.load(R.raw.shortslidedown);
        slide = snd.load(R.raw.slide);
        slideback = snd.load(R.raw.slideback);
        slidedown = snd.load(R.raw.slidedown);
        straight = snd.load(R.raw.straight);
        straightback = snd.load(R.raw.straightback);
        straightup = snd.load(R.raw.straightup);
        tryagain = snd.load(R.raw.tryagain);
    }
    }
