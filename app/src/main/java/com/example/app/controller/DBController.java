package com.example.app.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.app.database.DB;

public class DBController {
    private SQLiteDatabase db;
    private DB bank;

    public DBController(Context context) {
        bank = new DB(context);
    }

    public String insertData(String name, String lastname, String numberContact, String course) {
        ContentValues data;
        long result;
        db = bank.getWritableDatabase();
        data = new ContentValues();
        data.put(DB.Name, name);
        data.put(DB.LastName, lastname);
        data.put(DB.NumberContact, numberContact);
        data.put(DB.Course, course);
        result = db.insert(DB.Table, null, data);
        if (result == -1) {
            return "Error inserting record";
        } else {
            return "Record inserted";
        }
    }
}