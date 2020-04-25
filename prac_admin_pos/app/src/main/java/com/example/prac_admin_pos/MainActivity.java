package com.example.prac_admin_pos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prac_admin_pos.data.Data;
import com.example.prac_admin_pos.model.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText emailView ;
    private EditText passwordView ;
    private User UserLogged;
    private List<User> userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();
        // La actividad está creada.
        emailView = (EditText)findViewById(R.id.LoginEmail);
        passwordView = (EditText)findViewById(R.id.loginPasword);
        Data d1 = new Data();
        userList = d1.getUserList();

    }//end of onCreate

   public void validarCredenciales(View view){
        String emailValue = emailView.getText().toString();
        String passwordValue = passwordView.getText().toString();
       for (User user: userList) {
           if(emailValue.equals(user.getEmail()) && passwordValue.equals(user.getPassword())){
               //llama la otra actividad
               UserLogged = user;
               Toast.makeText(this, user.getName(), Toast.LENGTH_SHORT).show();
               //finish();
               //Intent a = new Intent(this, jobaplication.class);
               //startActivity(a);
           }
       }


    }

}
