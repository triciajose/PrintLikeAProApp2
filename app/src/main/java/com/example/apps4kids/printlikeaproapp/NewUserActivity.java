package com.example.apps4kids.printlikeaproapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class NewUserActivity extends ActionBarActivity {
    public final static String NAME = "com.example.apps4kids.printlikeaproapp.NAME";
    private Button testButton;
    // UI references.
    public EditText mNameView;
    DatabaseHandler dbHandler;
    SoundManager sManager;
    SoundActivity sActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        // Set up the login form.
        mNameView = (EditText) findViewById(R.id.name_new);
//        testButton = (Button) findViewById(R.id.btnPrint);
//        testButton.setVisibility(View.GONE);
        Button mStart = (Button) findViewById(R.id.sign_in_button_new);
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin(view);
            }
        });

        Context context = getApplicationContext();
        dbHandler = new DatabaseHandler(context);
        // dbHandler.addUser("Alice", "Alice");
        // dbHandler.addUser("Bob", "Bob");
        // dbHandler.addUser("Kathy", "Kathy");
    }
    /**
     * Go to main welcome page and animate the name
     * */
    public void attemptLogin(View view) {
        SoundManager sManager = new SoundManager(this);
        int ourLoad =  sManager.load(R.raw.goodjob); //
        String name = mNameView.getText().toString();
        if (mNameView.getText().toString().equals("")){



            createPopUp("Please click ok and type in your name.");
            sManager.play(ourLoad);

        }
        else {
            dbHandler.addUser(name, name);
            Intent intent = new Intent(this, MainActivity.class);
            //TO DO: need to check if name already exists
            intent.putExtra(NAME, name); //Optional parameters
            startActivity(intent);
        }

    }

    public void startPrint(View v){
        Intent intent = new Intent(this, PrintCharacterActivity.class);
        startActivity(intent);
    }


    private void createPopUp(String msg){
        AlertDialog.Builder buildr = new AlertDialog.Builder(this);
        buildr.setMessage(msg);
        buildr.setNeutralButton("ok",null);
        buildr.create();
        buildr.show();
    }

    public void cancel(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}

