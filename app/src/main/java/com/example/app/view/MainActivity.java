package com.example.app.view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;
import com.example.app.controller.PeopleController;
import com.example.app.model.People;

public class MainActivity extends AppCompatActivity {
    private Button button_save, button_finish, button_clear;
    private EditText edit_first_name, edit_last_name, edit_contact_number;
    private PeopleController peopleController;
    private Spinner edit_desired_course; // Declarado como variável de instância

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Inicializar o Spinner como variável de instância
        edit_desired_course = findViewById(R.id.spinner_course);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.itens_list,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        edit_desired_course.setAdapter(adapter);

        edit_desired_course.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCourse = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Selected: " + selectedCourse, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        peopleController = new PeopleController(this);

        edit_first_name = findViewById(R.id.editText_first_name);
        edit_last_name = findViewById(R.id.editText_last_name);
        edit_contact_number = findViewById(R.id.editText_contact_number);

        button_clear = findViewById(R.id.button_clear);
        button_save = findViewById(R.id.button_save);
        button_finish = findViewById(R.id.button_finish);

        button_save.setOnClickListener(v -> {
            String selectedCourse = edit_desired_course.getSelectedItem().toString();
            People people = new People(
                    edit_first_name.getText().toString(),
                    edit_last_name.getText().toString(),
                    selectedCourse,
                    edit_contact_number.getText().toString());
            Toast.makeText(this, "Course saved: " + selectedCourse, Toast.LENGTH_SHORT).show();
            peopleController.savePeople(people);
            Toast.makeText(this, "Data saved!", Toast.LENGTH_SHORT).show();
        });

        button_clear.setOnClickListener(v -> {
            edit_first_name.setText("");
            edit_last_name.setText("");
            edit_contact_number.setText("");
            peopleController.cleanPeopleData();
            Toast.makeText(this, "Fields cleared", Toast.LENGTH_SHORT).show();
        });

        button_finish.setOnClickListener(v -> {
            Toast.makeText(this, "Always come back, friend", Toast.LENGTH_SHORT).show();
            finish();
        });

        loadDataPeople();
    }

    public void loadDataPeople() {
        People people = peopleController.loadPeople();
        edit_first_name.setText(people.getFirstName());
        edit_last_name.setText(people.getLastName());
        edit_contact_number.setText(people.getContactNumber());
        String savedCourse = people.getDesiredCourse();
        ArrayAdapter<CharSequence> adapter = (ArrayAdapter<CharSequence>) edit_desired_course.getAdapter();
        int position = adapter.getPosition(savedCourse);
        if (position >= 0) {
            edit_desired_course.setSelection(position);
        }
    }
}