package com.example.app.view;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.app.R;
import com.example.app.controller.CourserController;
import com.example.app.controller.PeopleController;
import com.example.app.model.People;

public class MainActivity extends AppCompatActivity {

    People people;
    private Button button_save, button_finish, button_clear;
    private EditText edit_first_name,edit_last_name,edit_desired_course,edit_contact_number;
    private PeopleController peopleController;
    private CourserController courserController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        courserController = new CourserController();
        peopleController = new PeopleController(this);

        edit_first_name = findViewById(R.id.editText_first_name);
        edit_last_name = findViewById(R.id.editText_last_name);
        edit_desired_course = findViewById(R.id.editText_desired_course);
        edit_contact_number = findViewById(R.id.editText_contact_number);

        button_clear = findViewById(R.id.button_clear);
        button_save = findViewById(R.id.button_save);
        button_finish = findViewById(R.id.button_finish);

        button_save.setOnClickListener(v -> {
             people = new People(
                    edit_first_name.getText().toString(),
                    edit_last_name.getText().toString(),
                    edit_contact_number.getText().toString(),
                    edit_desired_course.getText().toString()
            );
        });
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 people = new People();
                 people.setFirstName(String.valueOf(edit_first_name.getText()));
                 people.setLastName(String.valueOf(edit_last_name.getText()));
                 people.setContactNumber(String.valueOf(edit_contact_number.getText()));
                 people.setDiseredCourse(String.valueOf(edit_desired_course.getText()));
            }
        });
        button_clear.setOnClickListener(v -> {
                    edit_first_name.setText("");
                    edit_last_name.setText("");
                    edit_desired_course.setText("");
                    edit_contact_number.setText("");
        });
        button_finish.setOnClickListener(v ->{
            finish();
        });

    }



}