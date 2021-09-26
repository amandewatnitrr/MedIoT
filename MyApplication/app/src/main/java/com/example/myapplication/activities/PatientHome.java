package com.example.myapplication.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.adapters.DoctorListAdapter;
import com.example.myapplication.models.doctor;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PatientHome extends AppCompatActivity {

    private TextView temperature,pressure,doc,pulse;
    private FirebaseAuth auth;
    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home);
        db=FirebaseDatabase.getInstance();
        initWidgets();
        DatabaseReference ref = db.getReference().child("iot").child("UUID_1");
        ref.child("temp").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String temp = temperature.getText().toString()+dataSnapshot.getValue().toString();
                temperature.setText(temp);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        ref.child("pressure").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String temp = pressure.getText().toString()+dataSnapshot.getValue().toString();
                pressure.setText(temp);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        ref.child("oxysat").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String temp = pulse.getText().toString()+dataSnapshot.getValue().toString();
                pulse.setText(temp);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void initWidgets() {
        temperature = findViewById(R.id.temperature);
        pressure = findViewById(R.id.pressure);
        doc = findViewById(R.id.doc);
        pulse = findViewById(R.id.pulse);
    }

    public void showDoctorList(View view) {
        DoctorListAcitivity dla = new DoctorListAcitivity();
        dla.populate();
        Intent intent = new Intent(PatientHome.this,DoctorListAcitivity.class);
        startActivity(intent);
    }

    /*public void showDoctorList(View view) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(PatientHome.this);
        LayoutInflater inflater =  getLayoutInflater();
        View customview = inflater.inflate(R.layout.popup_doctor_list, null);
        dialogBuilder.setView(customview);

        List<doctor> listDoc = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference().child("doctor");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String name = snapshot.child("name").getValue().toString();
                    String specialisation = snapshot.child("specialisation").getValue().toString();
                    System.out.println(name);
                    doctor d = new doctor(name,specialisation);
                    listDoc.add(d);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        doctor[] finalArr = new doctor[listDoc.size()];
        listDoc.toArray(finalArr);
        RecyclerView recyclerView = customview.findViewById(R.id.recyclerView);
        DoctorListAdapter adapter = new DoctorListAdapter(finalArr);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }*/
}