package com.example.prac_admin_pos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.prac_admin_pos.model.User;

public class RegistroActivity extends AppCompatActivity {
    private User newUser;
    private EditText cedulaView ;
    private EditText nombreView;
    private EditText emailView;
    private EditText contrasennaView;
    private EditText confirmView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        cedulaView = (EditText)findViewById(R.id.cedula_txt);
        nombreView = (EditText)findViewById(R.id.nombre_txt);
        emailView = (EditText)findViewById(R.id.email_txt);
        contrasennaView = (EditText)findViewById(R.id.contrasenna_txt);
        confirmView = (EditText)findViewById(R.id.confirm_txt);
    }
    public void realizarRegistro(final View view){
        String cedulaText = cedulaView.getText().toString();
        String nombreText = nombreView.getText().toString();
        String emailText = emailView.getText().toString();
        String contrasennaText = contrasennaView.getText().toString();
        String confirmText = confirmView.getText().toString();
        boolean pass = true;
        if(cedulaText.equals("")){
            cedulaView.setError(getString(R.string.campo_vacio));
            pass = false;
        }
        if(nombreText.equals("")){
            nombreView.setError(getString(R.string.campo_vacio));
            pass = false;
        }
        if(emailText.equals("")){
            emailView.setError(getString(R.string.campo_vacio));
            pass = false;
        }
        if(contrasennaText.equals("")){
            contrasennaView.setError(getString(R.string.campo_vacio));
            pass = false;
        }
        if(confirmText.equals("")){
            confirmView.setError(getString(R.string.campo_vacio));
            pass = false;
        }
        if(!contrasennaText.equals(confirmText)){
            confirmView.setError(getString(R.string.invalid_password_repeticion));
            pass = false;
        }
        if(pass){
            //hacer el Registro
            newUser = new User(cedulaText,nombreText,emailText,contrasennaText,"2");
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("userNuevo",newUser);
            startActivity(intent);
            finish();
        }

    }
    public void salir(final View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
