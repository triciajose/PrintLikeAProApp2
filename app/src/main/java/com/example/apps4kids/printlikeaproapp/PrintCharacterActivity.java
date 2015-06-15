package com.example.apps4kids.printlikeaproapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class PrintCharacterActivity extends ActionBarActivity {
    DrawView drawView = null;
    String mChracter = "T";
    GameMode gameMode = GameMode.ALLPOINTS;
    String name = "";
    private TextView nameTextView;
    Button button;
    static State state=State.fail;
    static Stage stage=Stage.BUBBLE;
    static Stage nextStage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_character);
        Intent intent = getIntent();
        name = intent.getStringExtra(LoginActivity.NAME);
        drawView = (DrawView) findViewById(R.id.drawView);
        nameTextView = (TextView) findViewById(R.id.textView);
        nameTextView.setText(name);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Click the button", "");
                switch(stage){
                    case BUBBLE:
                        nextStage=Stage.DOTS;
                        break;
                    case DOTS:
                        nextStage=Stage.BOX;
                        break;
                    case BOX:
                        nextStage=Stage.STARTING_POINT;
                        break;
                    case STARTING_POINT:
                        nextStage=Stage.EMPTY;
                        break;
                    case EMPTY:
                        nextStage=Stage.BUBBLE;
                        break;
                    default:break;
                }
                if(state==State.success){
                    stage=nextStage;
                }
                drawView.cacheCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                drawView.init();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_print_character, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
