package com.example.firebasenotepad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView noterv;
    FloatingActionButton noteinsert;
    ArrayList<notemodel>notemodelArrayList;
    noteAdapter noteAdapter;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noterv=findViewById(R.id.noterv);
        noteinsert=findViewById(R.id.noteinsert);
        database=FirebaseDatabase.getInstance();

        noteinsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,insertnoteActivity.class);
                startActivity(intent);
            }
        });

        notemodelArrayList=new ArrayList<>();
        noterv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        noteAdapter=new noteAdapter(MainActivity.this,notemodelArrayList);
        noterv.setAdapter(noteAdapter);

        database.getReference().child("Notes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                notemodelArrayList.clear();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    notemodel notemodels=dataSnapshot.getValue(notemodel.class);
                    notemodelArrayList.add(notemodels);
                }
                noteAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}