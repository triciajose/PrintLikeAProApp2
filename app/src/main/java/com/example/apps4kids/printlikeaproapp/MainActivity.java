package com.example.apps4kids.printlikeaproapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.graphics.Typeface;
import android.os.Handler;

import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends Activity {

    public final static String NAME = "com.example.apps4kids.printlikeaproapp.NAME";
    String name;
    TextView textView;
    Animation grow;
    Animation shrink;
    DrawView drawView = null;
    String mChracter = "l";
    GameMode gameMode = GameMode.ALLPOINTS;
    int m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        name = intent.getStringExtra(LoginActivity.NAME);
        Typeface centuryGothic = Typeface.createFromAsset(getApplicationContext().getAssets(), "ufonts.com_century-gothic.ttf");

        // Create a LinearLayout element
        View linearLayout = findViewById(R.id.name);

        for (int i = 0; i < name.length(); i++) {
            textView = new TextView(this);

            textView.setTextSize(40);
            String character = Character.toString(name.charAt(i));
            textView.setText(character);
            textView.setTypeface(centuryGothic);
            textView.setId(i);

            // Add text
            ((LinearLayout) linearLayout).addView(textView);
        }

        grow = AnimationUtils.loadAnimation(this, R.anim.highlight);
        shrink = AnimationUtils.loadAnimation(this, R.anim.shrink);

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
//                this.startAnimation(shrink);

            }
        });
        shrink.setAnimationListener(new AnimationListener() {

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
        for (int j= 0; j < name.length(); j++) {

            final TextView chartextView = (TextView) findViewById(j);
            chartextView.setText(Character.toString(name.charAt(j)));
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    chartextView.startAnimation(grow);
                }
            }, 1000 * (j + 1));
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent2 = new Intent(textView.getContext(), PrintCharacterActivity.class);
                intent2.putExtra(NAME, name); //Optional parameters
                startActivity(intent2);
            }
        }, 1000 * ( name.length() ));

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



}
