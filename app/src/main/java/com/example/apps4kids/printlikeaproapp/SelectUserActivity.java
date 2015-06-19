package com.example.apps4kids.printlikeaproapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class SelectUserActivity extends ActionBarActivity {

    public final static String NAME = "com.example.apps4kids.printlikeaproapp.NAME";
    private Button testButton;
    // UI references.
    public TextView mNameView;
    DatabaseHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user);

        // Set up the login form.
        mNameView = (TextView) findViewById(R.id.name_select);
//        testButton = (Button) findViewById(R.id.btnPrint);
//        testButton.setVisibility(View.GONE);
        Button mStart = (Button) findViewById(R.id.sign_in_button_select);
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin(view);
            }
        });

        final Spinner dropdown = (Spinner)findViewById(R.id.spinner);
        int spinnerDefault = 0;
        Context context = getApplicationContext();
        dbHandler = new DatabaseHandler(context);
        // dbHandler.addUser("Alice", "Alice");
        // dbHandler.addUser("Bob", "Bob");
        // dbHandler.addUser("Kathy", "Kathy");

        ArrayList<User> nameList = new ArrayList<>();
        nameList.addAll(dbHandler.getAllUsers());
        ArrayAdapter<User> adapter = new ArrayAdapter<User>(this, android.R.layout.simple_spinner_item, nameList);
        dropdown.setAdapter(adapter);
        dropdown.setPrompt("Select a name");
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            //
            public void onItemSelected(AdapterView<?> arg0, View view, int position, long id) {
                int itemPosition = position;
                String username =  ((User) dropdown.getSelectedItem()).getName();
                mNameView = (TextView) findViewById(R.id.name_select);
                mNameView.setText(username,  TextView.BufferType.EDITABLE);

            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    /**
     * Go to main welcome page and animate the name
     * */
    public void attemptLogin(View view) {
        String name = mNameView.getText().toString();

        if (mNameView.getText().toString().equals("")){
            createPopUp("Please click ok and type in your name.");
        }
        else {
//            dbHandler.addUser(name, name);
            Intent intent = new Intent(this, MainActivity.class);
            //TODO: need to check if name already exists
            //TODO: pass in everything about the user (id, letterIndex, etc.) to the next activity so the app can load the correct letter and also beging updating his or her progress via database
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

