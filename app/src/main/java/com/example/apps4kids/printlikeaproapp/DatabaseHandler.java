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

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "Test";
    private static final String TABLE_TEST = "TestTable";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_CHECKPOINT = "checkpoint";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate (SQLiteDatabase db) {
        String CREATE_TEST_TABLE_ = "CREATE TABLE " + TABLE_TEST + "(" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NAME + " TEXT, "
                + KEY_CHECKPOINT + " TEXT" + ")";
        db.execSQL(CREATE_TEST_TABLE_);
    }

    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEST);

        onCreate(db);
    }

    // Adding new contact
    public void addRecord(DatabaseHelper record) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, record.getName());
        values.put(KEY_CHECKPOINT, record.get_checkPoint());

        // Inserting Row
        db.insert(TABLE_TEST, null, values);
        db.close(); // Closing database connection
    }
    // Getting single record
    public DatabaseHelper getRecord(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_TEST, new String[] { KEY_ID,
                        KEY_NAME, KEY_CHECKPOINT }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        DatabaseHelper record = new DatabaseHelper(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return record
        return record;
    }

    // Getting All Contacts
    public List<DatabaseHelper> getAllRecord() {
        List<DatabaseHelper> recordList = new ArrayList<DatabaseHelper>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_TEST;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DatabaseHelper record = new DatabaseHelper();
                record.setID(Integer.parseInt(cursor.getString(0)));
                record.setName(cursor.getString(1));
                record.setcheckPoint(cursor.getString(2));
                // Adding contact to list
                recordList.add(record);
            } while (cursor.moveToNext());
        }

        // return contact list
        return recordList;

    }

    // Getting contacts Count
    public int getRecordsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_TEST;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();

    }
    // Updating single contact
    public int updateRecord(DatabaseHelper record) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, record.getName());
        values.put(KEY_CHECKPOINT, record.get_checkPoint());

        // updating row
        return db.update(TABLE_TEST, values, KEY_NAME + " = ?",
                new String[] { String.valueOf(record.getName()) });
    }

    // Deleting single contact
    public void deleteRecord(DatabaseHelper record) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TEST, KEY_NAME + " = ?",
                new String[] { String.valueOf(record.getName()) });
        db.close();
    }

}
