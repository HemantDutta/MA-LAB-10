package com.example.ma_lab_10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class User extends AppCompatActivity {

    //References
    Button add, viewAll;
    EditText userName, durationPack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        RecyclerView recyclerView = findViewById(R.id.userList);
        DatabaseHelper databaseHelper = new DatabaseHelper(User.this);
        List<Item> list1 = databaseHelper.getEveryone();

        recyclerView.setLayoutManager(new LinearLayoutManager(User.this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),list1));

        userName = findViewById(R.id.editTextText3);
        durationPack = findViewById(R.id.editTextNumber);
        add = findViewById(R.id.addUser);
        viewAll = findViewById(R.id.viewAll);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!userName.getText().toString().equalsIgnoreCase("") && !durationPack.getText().toString().equalsIgnoreCase("")){
                    Item item = new Item(userName.getText().toString(), durationPack.getText().toString(), -1);
                    DatabaseHelper databaseHelper = new DatabaseHelper(User.this);
                    boolean b = databaseHelper.addOne(item);
                    Toast.makeText(User.this, ""+b, Toast.LENGTH_SHORT).show();
                    List<Item> list = databaseHelper.getEveryone();

                    recyclerView.setLayoutManager(new LinearLayoutManager(User.this));
                    recyclerView.setAdapter(new MyAdapter(getApplicationContext(),list));
                }
                else{
                    Toast.makeText(User.this, "Please fill all the fields...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper databaseHelper = new DatabaseHelper(User.this);
                List<Item> list = databaseHelper.getEveryone();

                recyclerView.setLayoutManager(new LinearLayoutManager(User.this));
                recyclerView.setAdapter(new MyAdapter(getApplicationContext(),list));
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(User.this, Delete.class);
                startActivity(i);
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(User.this, Update.class);
                startActivity(i);
            }
        });
    }
}