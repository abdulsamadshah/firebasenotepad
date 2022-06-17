package com.example.firebasenotepad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class insertnoteActivity extends AppCompatActivity {

    EditText etitle,edesc;
    Button insertdata;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertnote);

        etitle=findViewById(R.id.etitle);
        edesc=findViewById(R.id.edesc);
        insertdata=findViewById(R.id.insertdata);
        database=FirebaseDatabase.getInstance();

        insertdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                notemodel notemodel=new notemodel();
                notemodel.setTitle(etitle.getText().toString());
                notemodel.setDescription(edesc.getText().toString());

                database.getReference().child("Notes").push().setValue(notemodel).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(insertnoteActivity.this, "data inserted successfully", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(insertnoteActivity.this, "something wrong", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

    }
}