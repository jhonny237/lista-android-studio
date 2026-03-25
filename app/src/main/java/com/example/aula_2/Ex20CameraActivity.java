package com.example.aula_2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Ex20CameraActivity extends AppCompatActivity {

    // Views declaradas como atributos da classe
    Button btnAbrirCamera;
    Button btnVoltar;
    ImageView imgFoto;

    // Código de requisição da câmera
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ex20_camera);

        // Inicializar views
        btnAbrirCamera = findViewById(R.id.btnAbrirCamera);
        btnVoltar = findViewById(R.id.btnVoltar);
        imgFoto = findViewById(R.id.imgFoto);

        // Abrir câmera ao clicar no botão
        btnAbrirCamera.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
            } else {
                Toast.makeText(Ex20CameraActivity.this, "Câmera não disponível", Toast.LENGTH_SHORT).show();
            }
        });

        // Botão voltar para tela de boas-vindas
        btnVoltar.setOnClickListener(v -> finish());
    }

    // Receber resultado da câmera
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            // Obter thumbnail da foto e exibir no ImageView
            Bundle extras = data.getExtras();
            Bitmap fotoBitmap = (Bitmap) extras.get("data");
            imgFoto.setImageBitmap(fotoBitmap);
        }
    }
}
