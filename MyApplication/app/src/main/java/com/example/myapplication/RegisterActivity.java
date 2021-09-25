package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private Button bDoc,bPat;
    private FirebaseAuth auth;
    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initialiseWidgets();
        auth=FirebaseAuth.getInstance();
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
        final EditText name = customview.findViewById(R.id.name);
        final EditText email = customview.findViewById(R.id.email);
        final EditText password = customview.findViewById(R.id.pass);
        final Button register = customview.findViewById(R.id.log);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputn = name.getText().toString();
                String inpute = email.getText().toString();
                String inputp = password.getText().toString();
                registerPatient(inputn,inpute,inputp);
            }
        });
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

    private void registerPatient(String inputn, String inpute, String inputp) {
        auth.createUserWithEmailAndPassword(inpute, inputp)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            updateDB(inputn,inpute);
                            Toast.makeText(RegisterActivity.this,"Registration Successful!",Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(RegisterActivity.this,"Registration Failed!",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void updateDB(String inputn, String inpute) {
        db = FirebaseDatabase.getInstance();
        FirebaseUser user =  auth.getCurrentUser();
        String userId = user.getUid();
        DatabaseReference ref = db.getReference().child("patient").child(userId).child("info");
        ref.child("name").setValue(inputn);
        ref.child("email").setValue(inpute);
    }

    public void DoctorLogin(View view) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(RegisterActivity.this);
        LayoutInflater inflater =  getLayoutInflater();
        View customview = inflater.inflate(R.layout.popup_doctor_register, null);
        dialogBuilder.setView(customview);
        final EditText name = customview.findViewById(R.id.name);
        final EditText email = customview.findViewById(R.id.email);
        final EditText special = customview.findViewById(R.id.special);
        final EditText password = customview.findViewById(R.id.pass);
        final Button register = customview.findViewById(R.id.log);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputn = name.getText().toString();
                String inpute = email.getText().toString();
                String inputp = password.getText().toString();
                String inputs = special.getText().toString();
                registerDoctor(inputn,inpute,inputp,inputs);
            }
        });
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

    private void registerDoctor(String inputn, String inpute, String inputp, String inputs) {
        auth.createUserWithEmailAndPassword(inpute, inputp)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            updateDB(inputn,inpute,inputs);
                            Toast.makeText(RegisterActivity.this,"Registration Successful!",Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(RegisterActivity.this,"Registration Failed!",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void updateDB(String inputn, String inpute, String inputs) {
        db = FirebaseDatabase.getInstance();
        FirebaseUser user =  auth.getCurrentUser();
        String userId = user.getUid();
        DatabaseReference ref = db.getReference().child("doctor").child(userId);
        ref.child("name").setValue(inputn);
        ref.child("email").setValue(inpute);
        ref.child("specialisation").setValue(inputs);
    }
}