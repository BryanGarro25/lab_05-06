package com.example.prac_admin_pos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prac_admin_pos.model.User;

public class CambiarPassword extends AppCompatActivity {
    private User presentUser;
    private EditText oldPasswordView ;
    private EditText nuevoPasswordView;
    private EditText repeticionPasswordView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_password);

        oldPasswordView = (EditText)findViewById(R.id.oldPassword);
        nuevoPasswordView = (EditText)findViewById(R.id.nuevoPassword);
        repeticionPasswordView = (EditText)findViewById(R.id.repeticionPassword);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            presentUser = (User) getIntent().getSerializableExtra("user");
        }

        oldPasswordView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                checkOldPassword();
            }
        });
        repeticionPasswordView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                checkRepeticionPasswordView();
            }
        });
    }

    public void checkOldPassword(){
        String oldPassword = oldPasswordView.getText().toString();
        if(!oldPassword.equals(presentUser.getPassword())){
            oldPasswordView.setError(getString(R.string.error_incorrect_password));
            oldPasswordView.requestFocus();
        }
    }
    public void checkRepeticionPasswordView(){
        String newPassword = nuevoPasswordView.getText().toString();
        String repeticionPassword = repeticionPasswordView.getText().toString();
        if(!repeticionPassword.equals(newPassword)){
            repeticionPasswordView.setError(getString(R.string.invalid_password_repeticion));
            repeticionPasswordView.requestFocus();
        }
    }
    public void realizarCambio(final View view){
        String oldPassword = oldPasswordView.getText().toString();
        String newPassword = nuevoPasswordView.getText().toString();
        String repeticionPassword = repeticionPasswordView.getText().toString();
        boolean pass = true;
        if(oldPassword.equals("")){
            oldPasswordView.setError(getString(R.string.campo_vacio));
            pass = false;
        }
        if(newPassword.equals("")){
            nuevoPasswordView.setError(getString(R.string.campo_vacio));
            pass = false;
        }
        if(repeticionPassword.equals("")){
            repeticionPasswordView.setError(getString(R.string.campo_vacio));
            pass = false;
        }
        if(!oldPassword.equals(presentUser.getPassword())){
            oldPasswordView.setError(getString(R.string.error_incorrect_password));
            pass = false;
        }
        if(!repeticionPassword.equals(newPassword)){
            repeticionPasswordView.setError(getString(R.string.invalid_password_repeticion));
            pass = false;
        }
        if(pass){
            //hacer el cambio de contraseña
            presentUser.setPassword(newPassword);
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("userActualizado",presentUser);
            startActivity(intent);
            finish();
        }

    }

}
