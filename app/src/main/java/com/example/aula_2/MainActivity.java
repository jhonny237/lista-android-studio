package com.example.aula_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnEx20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnEx20 = findViewById(R.id.btnEx20);

        // Abrir o app completo Ex20
        btnEx20.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Ex20Activity.class);
            startActivity(intent);
        });
    }
}
