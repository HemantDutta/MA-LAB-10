package com.example.ma_lab_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText email = findViewById(R.id.editTextText);
        EditText password = findViewById(R.id.editTextText2);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!email.getText().toString().equalsIgnoreCase("") && password.getText().toString().equalsIgnoreCase("admin")){
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, User.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(MainActivity.this, "Wrong Credentials! Try again!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}