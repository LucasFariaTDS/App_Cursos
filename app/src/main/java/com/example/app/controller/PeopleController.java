package com.example.app.controller;

import android.content.Context;
import android.widget.Toast;

import com.example.app.model.People;

public class PeopleController {
    private final Context context;

    public PeopleController(Context context) {
        this.context = context;
    }
    public void savePeople(People people){
        String msg = "People save: "+ people.getFirstName() + " " +people.getLastName();
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
