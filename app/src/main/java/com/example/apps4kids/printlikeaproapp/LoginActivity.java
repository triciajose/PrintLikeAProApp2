package com.example.apps4kids.printlikeaproapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ContentResolver;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity {

    public final static String NAME = "com.example.apps4kids.printlikeaproapp.NAME";

    // UI references.
    private EditText mNameView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Set up the login form.
        mNameView = (EditText) findViewById(R.id.name);

        Button mStart = (Button) findViewById(R.id.sign_in_button);
        mStart.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin(view);
            }
        });

    }

    /**
     * Go to main welcome page and animate the name
     * */
    public void attemptLogin(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(NAME, mNameView.getText().toString()); //Optional parameters
        startActivity(intent);
    }

    public void startPrint(View v){
        Intent intent = new Intent(this, PrintCharacterActivity.class);
        startActivity(intent);
    }





}

