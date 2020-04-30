package com.example.prac_admin_pos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prac_admin_pos.model.JobApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

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
    private ImageButton uploadButton;
    private ImageButton sendButton;
    private ImageButton cancelButton;

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
        sendButton = findViewById(R.id.send_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    buildJobApp();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
        cancelButton = findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelJobApp();
            }
        });
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
    private void buildJobApp() throws ParseException {
        JobApp jobApp = new JobApp();
        if(!setErrors()){
            try {
                jobApp.setName(this.firstName.getText().toString());
                jobApp.setLastName(this.lastName.getText().toString());
                jobApp.setAddress1(this.streetAddress.getText().toString());
                jobApp.setAddress2(this.streetAddress2.getText().toString());
                jobApp.setCity(this.city.getText().toString());
                jobApp.setState(this.state.getText().toString());
                jobApp.setPostalCode(Integer.parseInt(this.postal.getText().toString()));
                jobApp.setEmailAddress(this.emailAddress.getText().toString());
                jobApp.setAreaCode(Integer.parseInt(this.areaCode.getText().toString()));
                jobApp.setPhoneNumber(this.phoneNumber.getText().toString());
                jobApp.setCountry(this.country.getSelectedItem().toString());
                jobApp.setPosition(this.position.getSelectedItem().toString());
                jobApp.setDate(this.date.getText().toString());
                sendJobApp(jobApp);
            }catch (Exception ex){
                Toast.makeText(this, "Error has ocurred. Please, try again", Toast.LENGTH_SHORT).show();
            }
        } else{
            Toast.makeText(this, "Information missing. Fill the requeriments", Toast.LENGTH_SHORT).show();
        }

    }
    public void sendJobApp(JobApp jobApp){

        Intent jobAppReady = new Intent(this, JobAppList.class);
        jobAppReady.putExtra("jobApp", jobApp);
        startActivity(jobAppReady);
        finish();
        Toast.makeText(this, "Registration has finished succesfully", Toast.LENGTH_SHORT).show();
    }
    private void cancelJobApp(){
        Intent cancel = new Intent(this,  NavDrawerActivity.class);
        startActivity(cancel);
        finish();
    }
    private boolean setErrors(){
        boolean flag = false;
        if(this.firstName.getText().toString().isEmpty()){
            this.firstName.setError("Name is required");
            flag = true;
        }
        if(this.lastName.getText().toString().isEmpty()){
            this.lastName.setError("LastName is required");
            flag = true;
        }
        if(this.streetAddress.getText().toString().isEmpty()){
            this.streetAddress.setError("Address is required");
            flag = true;
        }
        if(this.city.getText().toString().isEmpty()){
            this.city.setError("City is required");
            flag = true;
        }
        if(this.state.getText().toString().isEmpty()){
            this.state.setError("State is required");
            flag = true;
        }
        if(this.postal.getText().toString().isEmpty()){
            this.postal.setError("Postal is required");
            flag = true;
        }
        if(this.emailAddress.getText().toString().isEmpty()){
            this.emailAddress.setError("Email is required");
            flag = true;
        } else {
            if (!this.emailAddress.getText().toString().contains("@") || !this.emailAddress.getText().toString().contains(".")) {
                this.emailAddress.setError("Email is invalid");
                flag = true;
            }
        }
        if(this.areaCode.getText().toString().isEmpty()){
            this.areaCode.setError("Code required");
            flag = true;
        }
        if(this.phoneNumber.getText().toString().isEmpty()){
            this.phoneNumber.setError("Phone is required");
            flag = true;
        }
        return flag;
    }
}

