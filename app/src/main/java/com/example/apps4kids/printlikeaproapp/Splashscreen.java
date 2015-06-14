package com.example.apps4kids.printlikeaproapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;


/**
 * Created by kathywang101 on 15-06-13.
 */
public class Splashscreen extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashcreen);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(3000); // in milliseconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent openMain = new Intent(Splashscreen.this, LoginActivity.class);
                    startActivity(openMain);
                    finish();
                }
            }
        };
        timer.start();
    }
}
