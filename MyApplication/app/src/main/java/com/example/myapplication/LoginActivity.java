package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText email, password;
    private RadioButton rdoc, rpatient;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialiseWidgets();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check()){
                    String e = email.getText().toString();
                    String p = password.getText().toString();
                    if(rdoc.isChecked()){
                        Toast.makeText(LoginActivity.this,"Doctor",Toast.LENGTH_SHORT).show();
                    }else{
                        if(rpatient.isChecked()){
                            Toast.makeText(LoginActivity.this,"Patient",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(LoginActivity.this,"Please select a role",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }

    private boolean check() {
        if(email.getText().toString().length()==0){
            Toast.makeText(LoginActivity.this,"Please enter email",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password.getText().toString().length()==0){
            Toast.makeText(LoginActivity.this,"Please enter password",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void initialiseWidgets() {
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        rdoc = findViewById(R.id.rdoc);
        rpatient = findViewById(R.id.rpatient);
        btnLogin = findViewById(R.id.btnLogin);
    }
}