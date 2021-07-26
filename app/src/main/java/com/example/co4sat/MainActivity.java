package com.example.co4sat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btSubmit = findViewById(R.id.bt_submit);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUsername.getText().toString().equals("mehdi") && etPassword.getText().toString().equals("mehdi")) {
                    Intent intent = new Intent(MainActivity.this, Alertes.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"logged in", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"identifiant ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}