package com.example.sibu.contactbook.repository.Impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Sibu on 2014-08-25.
 */
public class DBAdapter extends SQLiteOpenHelper {

    public static final String TABLE_CONTACTS = "contacts";

    public static final String KEY_ID = "_id";
    public static final String KEY_FNAME = "fName";
    public static final String KEY_LNAME = "lName";
    public static final String KEY_EMAIL = "emailAddress";
    public static final String KEY_CELL = "cellNumber";
    public static final String KEY_ADDRESS = "homeAddress";

    private static final String DATABASE_NAME = "contacts.db";
    private static final int DATABASE_VERSION = 1;

    public static final String CREATE_CONTACTS_TABLE = "create table " + "IF NOT EXISTS "
            + TABLE_CONTACTS + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_LNAME + " TEXT NOT NULL, "
            + KEY_CELL + " TEXT NOT NULL, "
            + KEY_FNAME + " , "
            + KEY_EMAIL + " , "
            + KEY_ADDRESS + " ); ";



    public DBAdapter(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBAdapter.class.getName(), "upgrading... " + oldVersion + " to " + newVersion + " destroyed");

        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        onCreate(db);
    }
}