package com.example.apps4kids.printlikeaproapp;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

/**
 * Created by Laurel Chan on 2015-06-18.
 */
public class SoundManager {
    private Context pContext;
    private SoundPool sndPool;
    private float rate = 1.0f;
    private float masterVolume = 1.0f;
    private float leftVolume = 1.0f;
    private float rightVolume = 1.0f;
    private float balance = 0.5f;

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
    public void play(int sound_id)
    {
        sndPool.play(sound_id, leftVolume, rightVolume, 1, 0, rate);
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
