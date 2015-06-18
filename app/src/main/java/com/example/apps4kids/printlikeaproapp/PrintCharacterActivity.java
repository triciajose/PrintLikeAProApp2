package com.example.apps4kids.printlikeaproapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class PrintCharacterActivity extends ActionBarActivity {
    DrawView drawView = null;
    String mChracter = "A";
    GameMode gameMode = GameMode.ALLPOINTS;
    String name = "";
    int cIndex = 0;
    private TextView nameTextView;
    Button button;
    static State state = State.fail;
    static Stage stage = Stage.DOTS;
    static Stage nextStage;
    Button nextCharButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_character);
        Intent intent = getIntent();
        name = intent.getStringExtra(LoginActivity.NAME);
        mChracter = name.charAt(cIndex)+"";
//        drawView = (DrawView) findViewById(R.id.drawView);
        drawView = new DrawView(this, null);
        nameTextView = (TextView) findViewById(R.id.textView);
        Typeface centuryGothic = Typeface.createFromAsset(getApplicationContext().getAssets(), "ufonts.com_century-gothic.ttf");
        nameTextView.setTypeface(centuryGothic);
        nameTextView.setText(name);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Click the button", "");
                switch (stage) {
                    case BUBBLE:
                        nextStage = Stage.DOTS;
                        break;
                    case DOTS:
                        nextStage = Stage.BOX;
                        break;
                    case BOX:
                        nextStage = Stage.STARTING_POINT;
                        break;
                    case STARTING_POINT:
                        nextStage = Stage.EMPTY;
                        break;
                    case EMPTY:
                        nextStage = Stage.BUBBLE;
                        break;
                    default:
                        break;
                }
                if (state == State.success) {
                    stage = nextStage;
                }
                drawView.cacheCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                drawView.init();
            }
        });
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.drawViewGroupLayout);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.leftMargin = (width - ConstantCharacter.cSizeX) / 2;
        params.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
//        params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        //params.topMargin = (height - ConstantCharacter.cSizeY - 100) / 2 + 100;

 //       params.topMargin = 0;
        Log.i("leftMargin", ""+params.leftMargin);
        Log.i("topMargin", ""+params.topMargin);
        rl.addView(drawView, params);
        rl.invalidate();
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

    public void nextChar(View v){
        cIndex++;
        if(cIndex<name.length()) {
            mChracter = name.charAt(cIndex)+"";
            drawView.mCharacter = this.mChracter;
            drawView.cacheCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
            drawView.init();

        }
    }
}
