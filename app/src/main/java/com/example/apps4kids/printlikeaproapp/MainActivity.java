package com.example.apps4kids.printlikeaproapp;


import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.graphics.Typeface;
import android.os.Handler;
import android.media.SoundPool;

import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends Activity {

    public final static String NAME = "com.example.apps4kids.printlikeaproapp.NAME";
    String name;
    TextView textView;
    Animation grow;
    Animation jiggle;
    int m;
    int j;
    int soundIndex =0;
    SoundManager sM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        name = intent.getStringExtra(LoginActivity.NAME);
        Typeface centuryGothic = Typeface.createFromAsset(getApplicationContext().getAssets(), "ufonts.com_century-gothic.ttf");
        Typeface tekton = Typeface.createFromAsset(getApplicationContext().getAssets(), "tekton2.ttf");


        // Create a LinearLayout element
        View linearLayout = findViewById(R.id.name);

        for (int i = 0; i < name.length(); i++) {
            textView = new TextView(this);

            textView.setTextSize(100);
            String character = Character.toString(name.charAt(i));
            textView.setText(character);
            textView.setTypeface(centuryGothic);
            textView.setId(i);
//            textView.setTextColor(0xEF9C16);
            textView.setAlpha(255);

            // Add text
            ((LinearLayout) linearLayout).addView(textView);
        }

        grow = AnimationUtils.loadAnimation(this, R.anim.highlight);
        jiggle = AnimationUtils.loadAnimation(this, R.anim.jiggle);

        grow.setAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {
//                this.startAnimation(jiggle);

            }
        });
        jiggle.setAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {
//                Intent intent = new Intent(textView.getContext(), PrintCharacterActivity.class);
//                intent.putExtra(NAME, name); //Optional parameters
//                startActivity(intent);
            }
        });
        Handler handler = new Handler();
        sM = new SoundManager(this);

        for (j= 0; j < name.length(); j++) {
            long start = new Date().getTime();
//            while (new Date().getTime() - start < 1000L){
//                // do nothing
//            }
            final TextView chartextView = (TextView) findViewById(j);
            chartextView.setText(Character.toString(name.charAt(j)));
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    chartextView.startAnimation(grow);
                    if(soundIndex<name.length()) {
                        sM.announceLetter(name.charAt(soundIndex));
                    }
                    else{
                        soundIndex = 0;
                    }
                    soundIndex++;
                }
            }, 1600 * (j + 1));
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int k= 0; k < name.length(); k++) {

                    final TextView chartextView = (TextView) findViewById(k);
                    chartextView.setText(Character.toString(name.charAt(k)));
                    // We want to speak these letters.
                    // void helper (char k)  which is read as name.charAt(k)
                    //
                    chartextView.startAnimation(jiggle);
                }
            }
        }, (1600 * (name.length() + 1)) );


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent2 = new Intent(textView.getContext(), PrintCharacterActivity.class);
                intent2.putExtra(NAME, name); //Optional parameters
                startActivity(intent2);
            }
        }, (1600 * ( name.length() + 1) + 2000 ));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    public void goodjobAnimation() {
//        ImageView imageView = (ImageView) findViewById(R.id.goodjob_iv);
//        imageView.clearAnimation();
//
//        Animation appear = AnimationUtils.loadAnimation(
//                this, R.anim.abc_slide_in_bottom);
//
//        jiggle = AnimationUtils.loadAnimation(this, R.anim.jiggle);
//
//        AnimationSet animationSet = new AnimationSet(true);
//        animationSet.addAnimation(appear);
//        animationSet.addAnimation(jiggle);
//        animationSet.setDuration(3000);
//
//        imageView.startAnimation(animationSet);
    }

}
