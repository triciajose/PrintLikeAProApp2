package com.example.apps4kids.printlikeaproapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.TextView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;

import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends Activity {

    public final static String NAME = "com.example.apps4kids.printlikeaproapp.NAME";
    String name;
    Animation grow;
    Animation shrink;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        name = intent.getStringExtra(LoginActivity.NAME);

        textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(name);
        setContentView(textView);
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
                textView.startAnimation(shrink);

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
//                Intent intent = new Intent(textView.getContext(), DrawView.class);
//                intent.putExtra(NAME, name); //Optional parameters
//                startActivity(intent);
            }
        });
        textView.startAnimation(grow);


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
