package com.example.app.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.app.R;
import com.example.app.controller.PeopleController;
import com.example.app.model.People;

public class MainActivity extends AppCompatActivity {

    private Button button_save, button_finish, button_clear;
    private EditText edit_first_name,edit_last_name,edit_desired_course,edit_contact_number;
    private PeopleController peopleController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        peopleController = new PeopleController(this);

        edit_first_name = findViewById(R.id.editText_first_name);
        edit_last_name = findViewById(R.id.editText_last_name);
        edit_desired_course = findViewById(R.id.editText_desired_course);
        edit_contact_number = findViewById(R.id.editText_contact_number);

        button_clear = findViewById(R.id.button_clear);
        button_save = findViewById(R.id.button_save);
        button_finish = findViewById(R.id.button_finish);

        button_save.setOnClickListener(v -> {
            People people = new People(
                    edit_first_name.getText().toString(),
                    edit_last_name.getText().toString(),
                    edit_desired_course.getText().toString(),
                    edit_contact_number.getText().toString()
            );
            peopleController.savePeople(people);
            Toast.makeText(this, "Data saved!", Toast.LENGTH_SHORT).show();
        });

        button_clear.setOnClickListener(v -> {
            edit_first_name.setText("");
            edit_last_name.setText("");
            edit_desired_course.setText("");
            edit_contact_number.setText("");

            peopleController.deletPeople();
            Toast.makeText(this, "Fields cleared", Toast.LENGTH_SHORT).show();
        });

        button_finish.setOnClickListener(v -> {
            Toast.makeText(this, "Always come back, friend", Toast.LENGTH_SHORT).show();

            finish();
        });
        loadDataPeople();
    }

    public void loadDataPeople(){
        People people = peopleController.loadPeople();

        edit_first_name.setText(people.getFirstName());
        edit_last_name.setText(people.getLastName());
        edit_desired_course.setText(people.getDesiredCourse());
        edit_contact_number.setText(people.getContactNumber());
    }
}
