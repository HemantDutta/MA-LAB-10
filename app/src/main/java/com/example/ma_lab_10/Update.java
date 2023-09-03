package com.example.ma_lab_10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Update extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        EditText id, name, subs;
        id = (EditText) findViewById(R.id.editTextNumber3);
        name = (EditText) findViewById(R.id.editTextText4);
        subs = (EditText) findViewById(R.id.editTextText5);

        DatabaseHelper databaseHelper = new DatabaseHelper(Update.this);
        List<Item> list = databaseHelper.getEveryone();
        RecyclerView recyclerView = findViewById(R.id.recList);
        recyclerView.setLayoutManager(new LinearLayoutManager(Update.this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), list));

        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!id.getText().toString().equalsIgnoreCase("") && !name.getText().toString().equalsIgnoreCase("") && !subs.getText().toString().equalsIgnoreCase("")){
                    Boolean b = databaseHelper.updateUser(Integer.parseInt(id.getText().toString()), name.getText().toString(), subs.getText().toString());

                    if(b==true){
                        Toast.makeText(Update.this, "User Updated", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Update.this, "Error! Try again!", Toast.LENGTH_SHORT).show();
                    }
                    List<Item> list = databaseHelper.getEveryone();
                    recyclerView.setLayoutManager(new LinearLayoutManager(Update.this));
                    recyclerView.setAdapter(new MyAdapter(getApplicationContext(), list));
                }
            }
        });
    }
}