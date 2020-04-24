package com.example.prac_admin_pos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText email ;
    private EditText password ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();
        // La actividad está creada.
        email = (EditText)findViewById(R.id.LoginEmail);
        password = (EditText)findViewById(R.id.loginPasword);
    }

    public void validarCredenciales(View view){
        String emailValue = email.getText().toString();
        String passwordValue = password.getText().toString();
        if(emailValue == "@prac" && passwordValue =="prac"){
            //llama la otra actividad
            finish();
            Intent a = new Intent(this, jobaplication.class);
            startActivity(a);
        }

    }

}
