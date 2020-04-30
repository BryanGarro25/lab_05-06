package com.example.prac_admin_pos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
        passwordView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                checkPassword();
            }
        });
        intentInformation();
    }//end of onCreate
    public void checkPassword(){
        passwordView.setError(null);
        String emailValue = emailView.getText().toString();
        String passwordValue = passwordView.getText().toString();
        for (User user : userList) {
            if(emailValue.equals(user.getEmail()) && !passwordValue.equals(user.getPassword())){
                passwordView.setError(getString(R.string.error_incorrect_password));
                passwordView.requestFocus();
                break;
            }
        }
    }

   public void validarCredenciales(View view) {
       emailView.setError(null);
       passwordView.setError(null);
       String emailValue = emailView.getText().toString();
       String passwordValue = passwordView.getText().toString();
       Boolean UserEncontrado = false;
       for (User user : userList) {
           if (emailValue.equals(user.getEmail()) && passwordValue.equals(user.getPassword())) {
               //llama la otra actividad
               UserLogged = user;
               UserEncontrado = true;
               Toast.makeText(this, "login exitoso", Toast.LENGTH_SHORT).show();
               finish();
               Intent a = new Intent(this, NavDrawerActivity.class);
               startActivity(a);
           }else{
               if(emailValue.equals(user.getEmail()) && !passwordValue.equals(user.getPassword()) ){
                   UserEncontrado = true;
                   passwordView.setError(getString(R.string.error_incorrect_password));
                   passwordView.requestFocus();
                   break;
               }
           }
       }
       if(!UserEncontrado){
           emailView.setError(getString(R.string.invalid_username));
           emailView.requestFocus();
       }


   }
   public boolean validarEmail(String email){
       for (User user : userList) {
           if(email.equals(user.getEmail())){
               UserLogged = user;
               return true;
           }
       }
       return false;
   }
   public void cambiarPasword(View view){
       this.emailView.setError(null);
       String emailValue = emailView.getText().toString();
       if(emailValue.equals("")){
           emailView.setError(getString(R.string.email_vacio));
           emailView.requestFocus();
       }else{
           if(validarEmail(emailValue)){
               Intent intent = new Intent(this, CambiarPassword.class);
               intent.putExtra("user",UserLogged);
               Toast.makeText(this, "email valido", Toast.LENGTH_SHORT).show();
               startActivity(intent);
           }else{
               emailView.setError(getString(R.string.invalid_email));
               emailView.requestFocus();
           }

       }
   }
   public void intentInformation(){
       Bundle extras = getIntent().getExtras();
       if(extras != null){
           User user = (User) getIntent().getSerializableExtra("userActualizado");
           if(user!= null){
               for (User u : userList) {
                   if(u.getId().equals(user.getId())){
                       u.setPassword(user.getPassword());
                   }
               }
           }else {
               user = (User) getIntent().getSerializableExtra("userNuevo");
               if(user!= null){
                   userList.add(user);
               }
           }
       }
   }
}//end of class

