package com.example.ma_lab_10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class Delete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        EditText userID = (EditText) findViewById(R.id.editTextNumber2);
        DatabaseHelper databaseHelper = new DatabaseHelper(Delete.this);
        List<Item> list = databaseHelper.getEveryone();

        RecyclerView recyclerView = findViewById(R.id.deleteList);
        recyclerView.setLayoutManager(new LinearLayoutManager(Delete.this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), list));

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!userID.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(Delete.this, userID.getText().toString(), Toast.LENGTH_SHORT).show();
                    boolean b = databaseHelper.deleteUser(Integer.parseInt(userID.getText().toString()));
                    Toast.makeText(Delete.this, ""+b, Toast.LENGTH_SHORT).show();
                    List<Item> list = databaseHelper.getEveryone();
                    recyclerView.setLayoutManager(new LinearLayoutManager(Delete.this));
                    recyclerView.setAdapter(new MyAdapter(getApplicationContext(), list));
                }
                else{
                    Toast.makeText(Delete.this, "Please fill the ID field", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}