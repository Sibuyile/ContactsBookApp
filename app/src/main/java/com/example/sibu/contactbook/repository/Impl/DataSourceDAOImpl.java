package com.example.sibu.contactbook.repository.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.sibu.contactbook.domain.Contact;
import com.example.sibu.contactbook.repository.DataSourceDAO;

import java.util.List;

/**
 * Created by Sibu on 2014-08-25.
 */
public class DataSourceDAOImpl implements DataSourceDAO {

    private SQLiteDatabase database;
    private DBAdapter dbHelper;
    private int cur = 0;

    public DataSourceDAOImpl(Context context) {
        dbHelper = new DBAdapter(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    @Override
    public void createContact(Contact contact) {
        open();
        ContentValues values = new ContentValues();

        Log.i("","Inserting into database.");

        values.put(DBAdapter.KEY_CELL, contact.getCellNo());
        values.put(DBAdapter.KEY_LNAME, contact.getLastName());
        values.put(DBAdapter.KEY_FNAME, contact.getFirstName());
        values.put(DBAdapter.KEY_EMAIL, contact.getEmail());
        values.put(DBAdapter.KEY_ADDRESS, contact.getAddress());

        database.insert(DBAdapter.TABLE_CONTACTS, null, values);

        Log.i("","Inserted into database.");

        close();
    }

    @Override
    public void updateContact(Contact contact) {

    }

    @Override
    public Contact findContactByID(int id) {
        open();
        Cursor cursor = database.query(DBAdapter.TABLE_CONTACTS, new String[]{DBAdapter.KEY_ID, DBAdapter.KEY_LNAME, DBAdapter.KEY_CELL, DBAdapter.KEY_FNAME, DBAdapter.KEY_EMAIL,
                DBAdapter.KEY_ADDRESS}, DBAdapter.KEY_ID + " =? ", new String[]{String.valueOf(id)}, null, null, null, null);


        if (cursor != null)
            cursor.moveToFirst();

        Contact contact = new Contact.Builder(cursor.getString(2))
                .setId(cursor.getInt(0))
                .setlastName(cursor.getString(1))
                .setfirstName(cursor.getString(3))
                .setemail(cursor.getString(4))
                .setaddress(cursor.getString(5))
                .build();

        cursor.moveToLast();
        cur = cursor.getCount();

        close();

        return contact;
    }

    @Override
    public void deleteContact(Contact contact) {

    }

    @Override
    public Contact getContact() {
        return null;
    }

    @Override
    public List<Contact> getContactList() {
        return null;
    }

    @Override
    public int getCursor() {

        String selectQuery = "SELECT * FROM " + DBAdapter.TABLE_CONTACTS;

        open();
        Cursor cursor = database.rawQuery(selectQuery, null);
        cur = cursor.getCount();
        close();

        return cur;
    }
}
