package com.example.jobsearch;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "EmployeeDatabase";
    private static final int DATABASE_VERSION = 1;

    // Table name and column names
    private static final String TABLE_EMPLOYEES = "employees";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_CITY = "city";
    private static final String COLUMN_PINCODE = "pincode";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the employees table
        String CREATE_TABLE_EMPLOYEES = "CREATE TABLE " + TABLE_EMPLOYEES +
                "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NAME + " TEXT," +
                COLUMN_AGE + " INTEGER," +
                COLUMN_EMAIL + " TEXT," +
                COLUMN_CITY + " TEXT," +
                COLUMN_PINCODE + " TEXT" + ")";
        db.execSQL(CREATE_TABLE_EMPLOYEES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed and create fresh tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEES);
        onCreate(db);
    }

    public long insertEmployee(String name, int age, String email, String city, String pincode) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_AGE, age);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_CITY, city);
        values.put(COLUMN_PINCODE, pincode);
        long result = db.insert(TABLE_EMPLOYEES, null, values);
        db.close();
        return result;
    }

    public long insertCompany(String companyName, String ceoName, String headOffice, String email, String contact, String companyType) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("company_name", companyName);
        values.put("ceo_name", ceoName);
        values.put("head_office", headOffice);
        values.put("email", email);
        values.put("contact", contact);
        values.put("company_type", companyType);
        long result = -1; // Default value for error handling
        try {
            result = db.insert("companies", null, values);
        } catch (Exception e) {
            Log.e("DatabaseHelper", "Error inserting company: " + e.getMessage());
        } finally {
            db.close();
        }
        return result;
    }



}

