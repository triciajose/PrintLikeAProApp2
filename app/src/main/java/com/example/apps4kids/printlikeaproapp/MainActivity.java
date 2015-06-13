package com.example.apps4kids.printlikeaproapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

    EmbossMaskFilter emboss;
    BlurMaskFilter blur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emboss = new EmbossMaskFilter(new float[]{1.5f, 1.5f, 1.5f}, 0.6f, 6, 4.2f);
        blur = new BlurMaskFilter(8, BlurMaskFilter.Blur.NORMAL);
    }

    //Menu part
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        DrawView dv = (DrawView) findViewById(R.id.draw);
        //menu item
        switch (id) {
            //Color setting
            case R.id.red:
                dv.paint.setColor(Color.RED);
                item.setChecked(true);
                break;
            case R.id.green:
                dv.paint.setColor(Color.GREEN);
                item.setChecked(true);
                break;
            case R.id.blue:
                dv.paint.setColor(Color.BLUE);
                item.setChecked(true);
                break;

            //Brush size
            case R.id.width_1:
                dv.paint.setStrokeWidth(5);
                break;
            case R.id.width_2:
                dv.paint.setStrokeWidth(10);
                break;
            case R.id.width_5:
                dv.paint.setStrokeWidth(15);
                break;

            //Blurring
            case R.id.blur:
                dv.paint.setMaskFilter(blur);
                break;
            //Embossing
            case R.id.emboss:
                dv.paint.setMaskFilter(emboss);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}