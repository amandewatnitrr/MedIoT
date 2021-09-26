package com.example.myapplication.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.adapters.DoctorListAdapter;
import com.example.myapplication.models.doctor;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DoctorListAcitivity extends AppCompatActivity {

    private List<doctor> listDoc = new ArrayList<>();
    DoctorListAdapter adapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list_acitivity);
        context = this;
        populate();
    }

    public void populate() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("doctor");
        View view = 
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<doctor> options
                = new FirebaseRecyclerOptions.Builder<doctor>()
                .setQuery(ref, doctor.class)
                .build();
        adapter = new DoctorListAdapter(options);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        adapter.startListening();
    }

    // Function to tell the app to stop getting
    // data from database on stoping of the activity
    @Override
    protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }

}