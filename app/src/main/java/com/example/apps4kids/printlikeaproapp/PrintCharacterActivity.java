package com.example.apps4kids.printlikeaproapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;


public class PrintCharacterActivity extends ActionBarActivity {
    DrawView drawView = null;
    String mChracter = "A";
    GameMode gameMode = GameMode.ALLPOINTS;
    String name = "";
    int cIndex = 0;
    private TextView nameTextView;
    Button button;
    Button showMe;
    static State state = State.fail;
    static Stage stage = Stage.BUBBLE;
    static Stage nextStage;
    static Stage previousStage;
    Button nextCharButton;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_character);
        Intent intent = getIntent();
        name = intent.getStringExtra(LoginActivity.NAME);
        mChracter = name.charAt(cIndex) + "";
//        drawView = (DrawView) findViewById(R.id.drawView);
        drawView = new DrawView(this, null);
        nameTextView = (TextView) findViewById(R.id.textView);
        Typeface centuryGothic = Typeface.createFromAsset(getApplicationContext().getAssets(), "ufonts.com_century-gothic.ttf");
        nameTextView.setTypeface(centuryGothic);
 //       nameTextView.setText(name);
        updateTitleText();

        Spinner dropdown = (Spinner)findViewById(R.id.spinner1);
        String[] items = new String[]{"simple", "normal", "difficulty"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        dropdown.setVisibility(View.GONE);
//        dropdown.setAdapter(adapter);
//        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view,
//                                       int position, long id) {
//                Log.i("drop down selected at:", (String) parent.getItemAtPosition(position));
//                switch(position){
//                    case 2:
//                        ConstantCharacter.THRESHOLD = 3000;
//                        ConstantCharacter.STROKE_POINT_THRESHOLD = 0.3;
//                        break;
//                    case 1:
//                        ConstantCharacter.THRESHOLD = 4000;
//                        ConstantCharacter.STROKE_POINT_THRESHOLD = 0.4;
//                    case 0:
//                        ConstantCharacter.THRESHOLD = 5000;
//                        ConstantCharacter.STROKE_POINT_THRESHOLD = 0.5;
//
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                // TODO Auto-generated method stub
//            }
//        });

        button = (Button) findViewById(R.id.neststatebutton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Click the button", "");
                switch (stage) {
                    case BUBBLE:
                        nextStage = Stage.DOTS;
                        Log.i("Entering the stage Dots", "");
                        break;
                    case DOTS:
                        nextStage = Stage.BOX;
                        Log.i("Entering the stage Box", "");
                        break;
                    case BOX:
                        nextStage = Stage.STARTING_POINT;
                        Log.i("Entering  S_point", "");
                        break;
                    case STARTING_POINT:
                        nextStage = Stage.EMPTY;
                        Log.i("Entering empty", "");
                        break;
                    case EMPTY:
                        nextStage = Stage.BUBBLE;
                        nextChar(null);
                        break;
                    default:
                        break;
                }
                if (state == State.success) {
                    stage = nextStage;
                    state = State.fail;
                }
                drawView.cacheCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                drawView.init();
            }
        });
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.rootRL);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.leftMargin = (width - ConstantCharacter.cSizeX) / 2;
        params.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
//        params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        params.topMargin = (height - ConstantCharacter.cSizeY - 50) / 2 + 50; // the constant is the height of the title.
//        params.bottomMargin = (height - ConstantCharacter.cSizeY - 40) / 2; // the constant is the height of the title.
        //       params.topMargin = 0;
        Log.i("leftMargin", "" + params.leftMargin);
        Log.i("topMargin", "" + params.topMargin);


        RelativeLayout lines = (RelativeLayout) findViewById(R.id.lines);
        RelativeLayout.LayoutParams linesParams = (RelativeLayout.LayoutParams) lines.getLayoutParams();
        linesParams.topMargin = params.topMargin-50;

        rl.addView(drawView, params);
        rl.invalidate();
    }

    public void updateTitleText(){
        String htmlString = "";
        if(cIndex<=name.length()) {
            htmlString += "<font color=\"#64DD17\">" + name.substring(0, cIndex) + "</font>";
        }
        else{
            return;
        }
        if(cIndex<name.length()) {
            htmlString += "<font color=\"#E91E63\">" + name.substring(cIndex, cIndex + 1) + "</font>";
        }
        if(cIndex+1<name.length()) {
            htmlString += "" + name.substring(cIndex + 1) + "";
        }
        nameTextView.setText(Html.fromHtml(htmlString));
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

    public void nextChar(View v) {
        cIndex++;
        while (cIndex < name.length() && name.charAt(cIndex) == ' ') {
            cIndex++;
        }
        if (cIndex < name.length()) {
            mChracter = name.charAt(cIndex) + "";
            drawView.mCharacter = this.mChracter;
            stage = Stage.BUBBLE;
            drawView.cacheCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
            drawView.init();
        }
        updateTitleText();


    }

    public void backChar(View v){
        cIndex--;
        while (cIndex >0 && name.charAt(cIndex) == ' ') {
            cIndex--;
        }
        if (cIndex >= 0) {
            mChracter = name.charAt(cIndex) + "";
            drawView.mCharacter = this.mChracter;
            stage = Stage.BUBBLE;
            drawView.cacheCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
            drawView.init();
            updateTitleText();
        }
    }

    public void Modelling(View v) {
        drawView.animateStroke();
    }
    public void goPrevious(View v){
        switch (stage) {
            case BUBBLE:
                previousStage = Stage.EMPTY;
                break;
            case DOTS:
                previousStage = Stage.BUBBLE;
                break;
            case BOX:
                previousStage = Stage.DOTS;
                break;
            case STARTING_POINT:
                previousStage = Stage.BOX;
                break;
            case EMPTY:
                previousStage = Stage.STARTING_POINT;
                break;
            default:
                break;

        }
        stage=previousStage;
        drawView.cacheCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        drawView.init();
    }

    public void showWooHoo(){
        if(cIndex >= name.length()-1 && stage == Stage.EMPTY) {
            Intent intent = new Intent(this, CelebrateActivity.class);
            startActivity(intent);
        }
    }
}

