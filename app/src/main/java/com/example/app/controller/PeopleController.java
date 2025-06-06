package com.example.app.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.app.model.People;

public class PeopleController {

    private static final String KEY_FIRST_NAME = "firstName";
    private static final String KEY_LAST_NAME = "lastName";
    private static final String KEY_DESIRED_COURSE = "desiredCourse";
    private static final String KEY_CONTACT_NUMBER = "contactNumber";

    public static final String NAME_PREFERENCES = "pref_listvip";
    private final SharedPreferences preferences;

    private Spinner edit_desired_course;

    public PeopleController(Context context) {
        preferences = context.getSharedPreferences(NAME_PREFERENCES, Context.MODE_PRIVATE);
    }

    public void savePeople(People people) {
        SharedPreferences.Editor listvip = preferences.edit();
        listvip.putString(KEY_FIRST_NAME, people.getFirstName());
        listvip.putString(KEY_LAST_NAME, people.getLastName());
        listvip.putString(KEY_DESIRED_COURSE, people.getDesiredCourse());
        listvip.putString(KEY_CONTACT_NUMBER, people.getContactNumber());
        listvip.apply();
    }

    public People loadPeople() {
        String firstName= preferences.getString(KEY_FIRST_NAME,"");
        String lastName = preferences.getString(KEY_LAST_NAME,"");
        String desiredCourse = preferences.getString(KEY_DESIRED_COURSE,"");
        String contactNumber = preferences.getString(KEY_CONTACT_NUMBER,"");

        return new People(firstName,lastName,desiredCourse,contactNumber);
    }

    public void cleanPeopleData(){
        preferences.edit().clear().apply();
    }
}
