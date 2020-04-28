package com.example.prac_admin_pos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class JobActivity extends AppCompatActivity {
    private EditText firstName;
    private EditText lastName;
    private EditText streetAddress;
    private EditText streetAddress2;
    private EditText city;
    private EditText state;
    private EditText postal;
    private Spinner country;
    private EditText emailAddress;
    private EditText areaCode;
    private EditText phoneNumber;
    private Spinner position;
    private TextView date;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private Button uploadButton;
    private Button sendButton;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
        getSupportActionBar().setTitle(getString(R.string.careers));
        date = findViewById(R.id.startDate);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(JobActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, dateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=+1;
                String date_string = month + "/" + dayOfMonth + "/"+ year;
                date.setText(date_string);
            }
        };
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        streetAddress = findViewById(R.id.address1);
        streetAddress2 = findViewById(R.id.address2);
        city = findViewById(R.id.city);
        state = findViewById(R.id.state);
        postal = findViewById(R.id.postal);
        country = findViewById(R.id.country);
        emailAddress = findViewById(R.id.email);
        areaCode = findViewById(R.id.areaCode);
        phoneNumber = findViewById(R.id.phone);
        position = findViewById(R.id.position);

        uploadButton = findViewById(R.id.upload_button2);
        /*sendButton = findViewById(R.id.send_button);
        cancelButton = findViewById(R.id.cancelButton);*/
        cleanText();
        //date picker

    }

    private void cleanText(){
        firstName.setText("");
        lastName.setText("");
        streetAddress.setText("");
        streetAddress2.setText("");
        city.setText("");
        state.setText("");
        postal.setText("");
        emailAddress.setText("");
        areaCode.setText("");
        phoneNumber.setText("");
    }
}

