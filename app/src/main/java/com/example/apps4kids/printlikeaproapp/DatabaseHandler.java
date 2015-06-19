package com.example.apps4kids.printlikeaproapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan on 2015-06-13.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 6;
    private static final String DATABASE_NAME = "db";
    private static final String PROGRESS_TABLE = "progressTable";

    private static final String PROGRESS_COLUMN_ID = "id";
    private static final String PROGRESS_COLUMN_NAME = "name";
    private static final String PROGRESS_COLUMN_LETTER_INDEX = "letterIndex";
    private static final String PROGRESS_COLUMN_LEVEL = "level";
    private static final String PROGRESS_COLUMN_WRITTEN_NAME = "writtenName";
    private static final String PROGRESS_COLUMN_SCORE = "score";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate (SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + PROGRESS_TABLE + "(" +
                PROGRESS_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + 
                PROGRESS_COLUMN_NAME + " TEXT, " +
                PROGRESS_COLUMN_LETTER_INDEX + " INTEGER, " +
                PROGRESS_COLUMN_LEVEL + " INTEGER, " +
                PROGRESS_COLUMN_WRITTEN_NAME + " TEXT, " +
                PROGRESS_COLUMN_SCORE + " INTEGER " +
                ")";
        db.execSQL(createTableQuery);
    }

    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        db.execSQL("DROP TABLE IF EXISTS " + PROGRESS_TABLE);

        onCreate(db);
    }

    // Adding new user
    public void addUser(final String username, final String writtenName) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PROGRESS_COLUMN_NAME, username);
        values.put(PROGRESS_COLUMN_WRITTEN_NAME, writtenName);
        values.put(PROGRESS_COLUMN_LETTER_INDEX, 0);
        values.put(PROGRESS_COLUMN_LEVEL, 1);
        values.put(PROGRESS_COLUMN_SCORE, 0);

        // Inserting Row
        db.insert(PROGRESS_TABLE, null, values);
        db.close(); // Closing database connection
    }



    public User getUserRecord(final String username) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(PROGRESS_TABLE, new String[]{
                        PROGRESS_COLUMN_ID,
                        PROGRESS_COLUMN_LETTER_INDEX,
                        PROGRESS_COLUMN_LEVEL,
                        PROGRESS_COLUMN_WRITTEN_NAME,
                        PROGRESS_COLUMN_SCORE
                }, PROGRESS_COLUMN_NAME + "=?",
                new String[]{username}, null, null, null, null);

        User user = null;
        if (cursor != null && cursor.moveToFirst()) {

            int id = cursor.getInt(cursor.getColumnIndex(PROGRESS_COLUMN_ID));
            int letterIndex = cursor.getInt(cursor.getColumnIndex(PROGRESS_COLUMN_LETTER_INDEX));
            int level = cursor.getInt(cursor.getColumnIndex(PROGRESS_COLUMN_LEVEL));
            String writtenName = cursor.getString(cursor.getColumnIndex(PROGRESS_COLUMN_WRITTEN_NAME));
            int score = cursor.getInt(cursor.getColumnIndex(PROGRESS_COLUMN_SCORE));

            user = new User(id, username, letterIndex, level, writtenName, score);
        }

        cursor.close();
        db.close();

        return user;
    }

    // Getting All Contacts
    public List<String> getAllUserNamesAsString() {
        List<String> userListAsString = new ArrayList<String>();


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(PROGRESS_TABLE, new String[]{
                        PROGRESS_COLUMN_NAME
                }, null,
                null, null, null, PROGRESS_COLUMN_NAME + " ASC");

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                try {
                    String username = cursor.getString(cursor.getColumnIndex(PROGRESS_COLUMN_NAME));


                    // Adding contact to list
                    userListAsString.add(username);
                } catch (Exception e)
                {

                }
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        // return contact list
        return userListAsString;

    }

    // Getting All Contacts
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(PROGRESS_TABLE, new String[]{
                        PROGRESS_COLUMN_ID,
                        PROGRESS_COLUMN_NAME,
                        PROGRESS_COLUMN_LETTER_INDEX,
                        PROGRESS_COLUMN_LEVEL,
                        PROGRESS_COLUMN_WRITTEN_NAME,
                        PROGRESS_COLUMN_SCORE
                }, null,
                null, null, null, PROGRESS_COLUMN_NAME + " ASC");

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                try {
                    int id = cursor.getInt(cursor.getColumnIndex(PROGRESS_COLUMN_ID));
                    String username = cursor.getString(cursor.getColumnIndex(PROGRESS_COLUMN_NAME));
                    int letterIndex = cursor.getInt(cursor.getColumnIndex(PROGRESS_COLUMN_LETTER_INDEX));
                    int level = cursor.getInt(cursor.getColumnIndex(PROGRESS_COLUMN_LEVEL));
                    String writtenName = cursor.getString(cursor.getColumnIndex(PROGRESS_COLUMN_WRITTEN_NAME));
                    int score = cursor.getInt(cursor.getColumnIndex(PROGRESS_COLUMN_SCORE));


                    User user = new User(id, username, letterIndex, level, writtenName, score);
                    // Adding contact to list
                    userList.add(user);
                } catch (Exception e)
                {

                }
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        // return contact list
        return userList;

    }

    // Getting contacts Count
    public int getUserCount() {
        String countQuery = "SELECT  * FROM " + PROGRESS_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        db.close();

        // return count
        return cursor.getCount();

    }
    // Updating single contact
    public void updateUserProgress(int id, int letterIndex, int level, int score) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PROGRESS_COLUMN_LETTER_INDEX, letterIndex);
        values.put(PROGRESS_COLUMN_LEVEL, level);
        values.put(PROGRESS_COLUMN_SCORE, score);


        // updating row
        db.update(PROGRESS_TABLE, values, PROGRESS_COLUMN_ID + " = ?",
                new String[] { String.valueOf(id) });
        db.close();
    }

    public void updateUserName(int id, String username) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PROGRESS_COLUMN_NAME, username);


        // updating row
        db.update(PROGRESS_TABLE, values, PROGRESS_COLUMN_ID + " = ?",
                new String[] { String.valueOf(id) });
        db.close();
    }

    // Deleting single contact
    public void deleteUser(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(PROGRESS_TABLE, PROGRESS_COLUMN_ID + " = ?",
                new String[] {String.valueOf(id) });
        db.close();
    }

}