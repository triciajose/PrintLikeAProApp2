package com.example.apps4kids.printlikeaproapp;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

/**
 * Created by Laurel Chan on 2015-06-18.
 *
 * Tag teamed with Alek. boo yeah.
 *
 */
public class SoundManager {
    private Context pContext;
    private SoundPool sndPool;
    private float rate = 1.0f;
    private float masterVolume = 1.0f;
    private float leftVolume = 1.0f;
    private float rightVolume = 1.0f;
    private float balance = 0.5f;

    int across, acrossthebottom, acrossthetop, around, aroundthemiddle, bottom, close, curve, curveback,
            curveforward, dig, dot, down, forward, goodjob, lift, middle, shortslidedown, slide, slideback, slidedown, straight,
            straightback, straightup, tryagain, zero, one, two, three, four, five, six, seven, eight, nine, letterA, letterB, letterC,
            letterD, letterE, letterF, letterG, letterH, letterI, letterJ, letterK, letterL, letterM, letterN, letterO, letterP, letterQ,
            letterR, letterS, letterT, letterU, letterV, letterW, letterX, letterY, letterZ;

    // Constructor
    public SoundManager(Context appContext)
    {
        sndPool = new SoundPool(16, AudioManager.STREAM_MUSIC, 0);
        pContext = appContext;
    }


    // load sound
    public int load(int sound_id)
    {
        return sndPool.load(pContext, sound_id, 1);

    }

    // play sound
    // may debug this, I need to make the delay longer somehow... 
    public void play(int sound_id)
    {int streamID = -1;
        do {
            streamID = sndPool.play(sound_id, leftVolume, rightVolume, 1, 0, rate); // credit this do/while from stackoverflow: http://stackoverflow.com/questions/5202510/soundpool-sample-not-ready
        } while(streamID==0);
    }

    public void announceLetter(char letter) {
        if (Character.toUpperCase(letter) == 'A') {
            letterA = load(R.raw.a);
            play(letterA);
        }
        else if (Character.toUpperCase(letter) == 'B') {
            letterB = load(R.raw.b);
            try{wait(3000);}
            catch(InterruptedException b) {b.getMessage();}
            notify();
            play(letterB);
        } else if (Character.toUpperCase(letter) == 'C') {
            letterC = load(R.raw.c);
            play(letterC);
        } else if (Character.toUpperCase(letter) == 'D') {
            letterD = load(R.raw.d);
            play(letterD);
        } else if (Character.toUpperCase(letter) == 'E') {
            letterE = load(R.raw.e);
            play(letterE);
        } else if (Character.toUpperCase(letter) == 'F') {
            letterF = load(R.raw.f);
            play(letterF);
        } else if (Character.toUpperCase(letter) == 'G') {
            letterG = load(R.raw.g);
            play(letterG);
        } else if (Character.toUpperCase(letter) == 'H') {
            letterH = load(R.raw.h);
            play(letterH);
        } else if (Character.toUpperCase(letter) == 'I') {
            letterI = load(R.raw.i);
            play(letterI);
        } else if (Character.toUpperCase(letter) == 'J') {
            letterJ = load(R.raw.j);
            play(letterJ);
        } else if (Character.toUpperCase(letter) == 'K') {
            letterK = load(R.raw.k);
            play(letterK);
        } else if (Character.toUpperCase(letter) == 'L') {
            letterL = load(R.raw.l);
            play(letterL);
        } else if (Character.toUpperCase(letter) == 'M') {
            letterM = load(R.raw.m);
            play(letterM);
        } else if (Character.toUpperCase(letter) == 'N') {
            letterN = load(R.raw.n);
            play(letterN);
        } else if (Character.toUpperCase(letter) == 'O') {
            letterO = load(R.raw.o);
            play(letterO);
        } else if (Character.toUpperCase(letter) == 'P') {
            letterP = load(R.raw.p);
            play(letterP);
        } else if (Character.toUpperCase(letter) == 'Q') {
            letterQ = load(R.raw.q);
            play(letterQ);
        } else if (Character.toUpperCase(letter) == 'R') {
            letterR = load(R.raw.r);
            play(letterR);
        } else if (Character.toUpperCase(letter) == 'S') {
            letterS = load(R.raw.s);
            play(letterS);
        } else if (Character.toUpperCase(letter) == 'T') {
            letterT = load(R.raw.t);
            play(letterT);
        } else if (Character.toUpperCase(letter) == 'U') {
            letterU = load(R.raw.u);
            play(letterU);
        } else if (Character.toUpperCase(letter) == 'V') {
            letterV = load(R.raw.v);
            play(letterV);
        } else if (Character.toUpperCase(letter) == 'W') {
            letterW = load(R.raw.w);
            play(letterW);
        } else if (Character.toUpperCase(letter) == 'X') {
            letterX = load(R.raw.x);
            play(letterX);
        } else if (Character.toUpperCase(letter) == 'Y') {
            letterY = load(R.raw.y);
            play(letterY);
        } else { // do we account for only A-Z?
            letterZ = load(R.raw.z);
            play(letterZ);
        }
    }

    // Set volume values
    public void setVolume(float vol)
    {
        masterVolume = vol;

        if(balance < 1.0f) // Left dominant
        {
            leftVolume = masterVolume;
            rightVolume = masterVolume * balance;
        }
        else  // Right dominant
        {
            rightVolume = masterVolume;
            leftVolume = masterVolume * ( 2.0f - balance );
        }

    }

    // set playback speed for sound
    public void setSpeed(float speed)
    {
        rate = speed;

        // Speed of zero is invalid
        if(rate < 0.01f)
            rate = 0.01f;

        // Speed has a maximum of 2.0
        if(rate > 2.0f)
            rate = 2.0f;
    }

    public void setBalance(float balVal)
    {
        balance = balVal;

        // Recalculate volume levels
        setVolume(masterVolume);
    }

    // unload everything
    public void unloadAll()
    {
        sndPool.release();
    }
}
