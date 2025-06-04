package com.example.app.controller;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.app.model.People;

public class PeopleController {

    public PeopleController() {
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller Started");
        return super.toString();
    }
    public void save(People people){
        Log.d("MVC_Controller", "save: " + people.toString());
    }
}
