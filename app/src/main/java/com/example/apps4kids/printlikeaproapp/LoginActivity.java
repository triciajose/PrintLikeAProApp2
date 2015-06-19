package com.example.apps4kids.printlikeaproapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ContentResolver;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.Intent;
import android.app.AlertDialog;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity {

    public final static String NAME = "com.example.apps4kids.printlikeaproapp.NAME";
    private Button testButton;
    // UI references.
    public EditText mNameView;
    DatabaseHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

//    /**
//     * Go to main welcome page and animate the name
//     * */
//    public void attemptLogin(View view) {
//        String name = mNameView.getText().toString();
//
//        if (mNameView.getText().toString().equals("")){
//            createPopUp("Please click ok and type in your name.");
//        }
//        else {
//            dbHandler.addUser(name, name);
//            Intent intent = new Intent(this, MainActivity.class);
//            //TO DO: need to check if name already exists
//            intent.putExtra(NAME, name); //Optional parameters
//            startActivity(intent);
//        }
//
//    }

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

    public void selectUser(View view) {
            Intent intent = new Intent(this, SelectUserActivity.class);
            startActivity(intent);
    }

    public void newUser(View view) {
        Intent intent = new Intent(this, NewUserActivity.class);
        startActivity(intent);
    }
}

