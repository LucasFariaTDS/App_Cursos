package com.example.Lista_vip.view;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.Lista_vip.controller.DBController;
import com.example.Lista_vip.controller.PeopleController;
import com.example.Lista_vip.model.People;
import com.example.app.R;

public class MainActivity extends AppCompatActivity {
    private Button button_save, button_finish, button_clear;
    private EditText edit_first_name, edit_last_name, edit_contact_number;
    private Spinner spinner_course;
    private PeopleController peopleController;
    private DBController dbController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner);

        peopleController = new PeopleController(this);
        dbController = new DBController(this);

        edit_first_name = findViewById(R.id.editText_first_name);
        edit_last_name = findViewById(R.id.editText_last_name);
        edit_contact_number = findViewById(R.id.editText_contact_number);

        button_clear = findViewById(R.id.button_clear);
        button_save = findViewById(R.id.button_save);
        button_finish = findViewById(R.id.button_finish);

        spinner_course = findViewById(R.id.spinner_course);

        setupSpinner();

        button_save.setOnClickListener(v -> {
            if (edit_first_name.getText().toString().trim().isEmpty() ||
                    edit_last_name.getText().toString().trim().isEmpty() ||
                    edit_contact_number.getText().toString().trim().isEmpty()) {

                Toast.makeText(this, getString(R.string.msg_please_fill_in_all_fields), Toast.LENGTH_SHORT).show();
                return;
            }

            String result;
            String selectedCourse = spinner_course.getSelectedItem().toString();

            People people = new People(
                    edit_first_name.getText().toString(),
                    edit_last_name.getText().toString(),
                    selectedCourse,
                    edit_contact_number.getText().toString());

            peopleController.savePeople(people);
            result = dbController.insertData(people.getFirstName(),people.getLastName(),people.getDesiredCourse(),people.getContactNumber());
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        });

        button_clear.setOnClickListener(v -> {
            edit_first_name.setText("");
            edit_last_name.setText("");
            edit_contact_number.setText("");
            spinner_course.setSelection(0);
            peopleController.cleanPeopleData();
            Toast.makeText(this, getString(R.string.msg_fields_cleared), Toast.LENGTH_SHORT).show();
        });

        button_finish.setOnClickListener(v -> {
            Toast.makeText(this, getString(R.string.msg_always_come_back), Toast.LENGTH_SHORT).show();
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
        int position = ((ArrayAdapter<CharSequence>) spinner_course.getAdapter()).getPosition(savedCourse);
        if (position >= 0) {
            spinner_course.setSelection(position);
        }
    }

    private void setupSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.itens_list,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_course.setAdapter(adapter);
    }
}