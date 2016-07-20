package com.denisha.lambung;

/**
 * Created by USER on 7/19/2016.
 */
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "db_diagnosis";

    // Contacts table name
    private static final String TABLE_DIAGNOSIS = "diagnosis";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAMA = "nama";
    private static final String KEY_USIA = "usia";
    private static final String KEY_RIWAYAT = "riwayat";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DIAGNOSIS_TABLE = "CREATE TABLE " + TABLE_DIAGNOSIS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAMA + " TEXT,"
                + KEY_USIA + " TEXT,"
                + KEY_RIWAYAT + " TEXT" + ")" ;



        db.execSQL(CREATE_DIAGNOSIS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DIAGNOSIS);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new tabel
    void addContact(ContactModel contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAMA, contact.get_nama()); // tabel Nama
        values.put(KEY_USIA, contact.get_usia()); // tabel Usia
        values.put(KEY_RIWAYAT, contact.get_riwayat()); //tabel hasil riwayat


        // Inserting Row
        db.insert(TABLE_DIAGNOSIS, null, values);
        db.close(); // Closing database connection
    }
    void deleteAllContact(){
        SQLiteDatabase db = this.getReadableDatabase();

        db.execSQL("DELETE FROM " + TABLE_DIAGNOSIS);

    }

    // Getting single contact
    ContactModel getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_DIAGNOSIS, new String[] { KEY_ID,
                        KEY_NAMA, KEY_USIA, KEY_RIWAYAT }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        ContactModel contact = new ContactModel(Integer.parseInt(cursor.getString(0)),cursor.getString(1), cursor.getString(2), cursor.getString(3));
        // return contact
        return contact;
    }

    // Getting All Contacts
    public ArrayList<ContactModel> getAllContacts() {
        ArrayList<ContactModel> contactList = new ArrayList<ContactModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_DIAGNOSIS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ContactModel contact = new ContactModel();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.set_nama(cursor.getString(1));
                contact.set_usia(cursor.getString(2));
                contact.set_riwayat(cursor.getString(3));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    // Updating single contact
    public int updateContact(ContactModel contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAMA, contact.get_nama());
        values.put(KEY_USIA, contact.get_usia());
        values.put(KEY_RIWAYAT, contact.get_riwayat());

        // updating row
        return db.update(TABLE_DIAGNOSIS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
    }

    // Deleting single contact
    public void deleteContact(ContactModel contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_DIAGNOSIS, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
        db.close();
    }


    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_DIAGNOSIS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}
