package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class RegisterActivity extends AppCompatActivity {

    private Button bDoc,bPat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initialiseWidgets();
    }

    private void initialiseWidgets() {
        bDoc = findViewById(R.id.bDoc);
        bPat = findViewById(R.id.bPat);
    }

    public void PatientLogin(View view) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(RegisterActivity.this);
        LayoutInflater inflater =  getLayoutInflater();
        View customview = inflater.inflate(R.layout.popup_patient_register, null);
        dialogBuilder.setView(customview);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

    public void DoctorLogin(View view) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(RegisterActivity.this);
        LayoutInflater inflater =  getLayoutInflater();
        View customview = inflater.inflate(R.layout.popup_doctor_register, null);
        dialogBuilder.setView(customview);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }
}