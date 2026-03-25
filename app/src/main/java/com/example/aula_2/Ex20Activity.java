package com.example.aula_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Ex20Activity extends AppCompatActivity {

    // Views declaradas como atributos da classe
    EditText editEmail;
    EditText editSenha;
    Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ex20);

        // Inicializar views
        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);
        btnEntrar = findViewById(R.id.btnEntrar);

        // Listener do botão entrar com lambda
        btnEntrar.setOnClickListener(v -> {
            String email = editEmail.getText().toString().trim();
            String senha = editSenha.getText().toString().trim();

            // Validação dos campos
            if (email.isEmpty()) {
                editEmail.setError("Informe o e-mail");
                editEmail.requestFocus();
                return;
            }

            if (senha.isEmpty()) {
                editSenha.setError("Informe a senha");
                editSenha.requestFocus();
                return;
            }

            // Navegar para tela de boas-vindas passando o email
            Intent intent = new Intent(Ex20Activity.this, Ex20WelcomeActivity.class);
            intent.putExtra("email", email);
            startActivity(intent);
        });
    }
}
