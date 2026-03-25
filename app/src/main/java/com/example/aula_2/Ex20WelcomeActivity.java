package com.example.aula_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Ex20WelcomeActivity extends AppCompatActivity {

    // Views declaradas como atributos da classe
    TextView txtBoasVindas;
    Button btnCamera;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ex20_welcome);

        // Inicializar views
        txtBoasVindas = findViewById(R.id.txtBoasVindas);
        btnCamera = findViewById(R.id.btnCamera);
        btnVoltar = findViewById(R.id.btnVoltar);

        // Receber o email enviado pela tela de login
        String email = getIntent().getStringExtra("email");
        txtBoasVindas.setText("Bem-vindo,\n" + email + "!");

        // Navegar para tela de câmera
        btnCamera.setOnClickListener(v -> {
            Intent intent = new Intent(Ex20WelcomeActivity.this, Ex20CameraActivity.class);
            startActivity(intent);
        });

        // Botão voltar para tela de login
        btnVoltar.setOnClickListener(v -> finish());
    }
}
