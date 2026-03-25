# CLAUDE.md — Guia para Claude Code

## Sobre o Projeto
Aplicação Android (Java) com 20 exercícios práticos organizados em 4 níveis.
Tudo roda em um **único projeto Android Studio** — cada exercício é uma Activity separada.
A tela inicial (MainActivity) é um **menu** que lista todos os exercícios para navegação.

## Package e Configuração
- **Package**: `com.example.aula_2`
- **Linguagem**: Java (NÃO Kotlin)
- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 36
- **Build**: Groovy DSL

## Padrão de Código do Professor (SEGUIR EXATAMENTE)

O professor usa este estilo — todas as Activities devem seguir:

```java
package com.example.aula_2;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ExemploActivity extends AppCompatActivity {

    // Declarar views como atributos da classe (sem private)
    EditText editNome;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);  // SEMPRE usar EdgeToEdge
        setContentView(R.layout.activity_exemplo);

        // findViewById logo após setContentView
        editNome = findViewById(R.id.editNome);
        btnEnviar = findViewById(R.id.btnEnviar);

        // Listeners com lambda
        btnEnviar.setOnClickListener(v -> {
            // lógica aqui
        });
    }
}
```

### Padrões obrigatórios do professor:
- `EdgeToEdge.enable(this)` em toda Activity
- Views declaradas como atributos da classe (sem modificador private)
- IDs em camelCase simples: `editNome`, `btnEnviar`, `txtResultado`, `imgFoto`
- Listeners com **lambda** (não anonymous class)
- Layouts usam ConstraintLayout como root com LinearLayout dentro
- Intent com `NomeActivity.this` como context
- putExtra/getStringExtra para passar dados entre telas
- Câmera com `startActivityForResult` e `ACTION_IMAGE_CAPTURE`

### Padrão de Layout do professor:
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".NomeDaActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:padding="16dp">

        <!-- conteúdo aqui -->

    </LinearLayout>
</androidx.constraintlayout.widget.ConstraintLayout>
```

## Estrutura do Projeto

```
app/src/main/java/com/example/aula_2/
├── MainActivity.java              ← Menu principal (lista de exercícios)
├── nivel1/
│   ├── Ex01Activity.java          ← TextView + Button + Toast
│   ├── Ex02Activity.java          ← EditText → TextView
│   ├── Ex03Activity.java          ← LinearLayout vertical/horizontal
│   ├── Ex04Activity.java          ← ConstraintLayout centralizado
│   └── Ex05Activity.java          ← Formulário nome/email
├── nivel2/
│   ├── Ex06Activity.java          ← Validação campo vazio
│   ├── Ex07Activity.java          ← Soma de dois números
│   ├── Ex08Activity.java          ← Alterar texto dinamicamente
│   ├── Ex09Activity.java          ← Seleção Masculino/Feminino
│   └── Ex10Activity.java          ← Login simples
├── nivel3/
│   ├── Ex11Activity.java          ← Navegação entre 2 telas
│   ├── Ex11SecondActivity.java
│   ├── Ex12Activity.java          ← Enviar nome para 2ª tela
│   ├── Ex12SecondActivity.java
│   ├── Ex13Activity.java          ← Enviar nome+idade para 2ª tela
│   ├── Ex13SecondActivity.java
│   ├── Ex14Activity.java          ← Botão voltar
│   ├── Ex14SecondActivity.java
│   ├── Ex15Activity.java          ← Formatação dos dados recebidos
│   └── Ex15SecondActivity.java
└── nivel4/
    ├── Ex16Activity.java          ← Cadastro completo
    ├── Ex16SecondActivity.java
    ├── Ex17Activity.java          ← Validação completa
    ├── Ex17SecondActivity.java
    ├── Ex18Activity.java          ← Captura de foto (câmera)
    ├── Ex19Activity.java          ← App 3 telas (form+dados+câmera)
    ├── Ex19SecondActivity.java
    ├── Ex19ThirdActivity.java
    ├── Ex20Activity.java          ← App completo (login+boas-vindas+câmera)
    ├── Ex20WelcomeActivity.java
    └── Ex20CameraActivity.java

app/src/main/res/layout/
├── activity_main.xml              ← Menu principal
├── activity_ex01.xml
├── activity_ex02.xml
├── ...                            ← Um layout por Activity
└── activity_ex20_camera.xml
```

## Convenções de Nomes

| Tipo | Padrão | Exemplo |
|------|--------|---------|
| Activity | `Ex{nn}Activity.java` | `Ex01Activity.java` |
| 2ª tela | `Ex{nn}SecondActivity.java` | `Ex11SecondActivity.java` |
| Layout | `activity_ex{nn}.xml` | `activity_ex01.xml` |
| Layout 2ª tela | `activity_ex{nn}_second.xml` | `activity_ex11_second.xml` |
| IDs EditText | `editXxx` | `editNome`, `editEmail` |
| IDs Button | `btnXxx` | `btnEnviar`, `btnVoltar` |
| IDs TextView | `txtXxx` | `txtResultado`, `txtNome` |
| IDs ImageView | `imgXxx` | `imgFoto` |

## Regras Importantes

1. **Toda Activity DEVE ser registrada no AndroidManifest.xml**
2. **MainActivity = Menu principal** com ScrollView + LinearLayout + Buttons
3. **Cada botão do menu** abre a Activity correspondente via Intent
4. **Formato do botão**: "Ex 01 - Nome e Toast"
5. **Strings hardcoded** no layout são OK (não precisa strings.xml para textos dos exercícios)
6. **Comentários em português**
7. **Não deletar** a SecondActivity.java original do professor — ela serve como referência

## Descrição dos Exercícios

### NÍVEL 1 — FUNDAMENTOS
| Ex | Descrição | Componentes |
|----|-----------|-------------|
| 01 | Exibir nome + botão que mostra Toast | TextView, Button, Toast |
| 02 | Digitar texto e exibir em TextView | EditText, Button, TextView |
| 03 | LinearLayout: 3 botões vertical + 2 horizontal | LinearLayout, Buttons |
| 04 | ConstraintLayout com botão centralizado | ConstraintLayout, Button |
| 05 | Formulário com campo Nome e Email | EditText (nome, email), Button |

### NÍVEL 2 — INTERAÇÃO
| Ex | Descrição | Componentes |
|----|-----------|-------------|
| 06 | Validar campo vazio, exibir mensagem | EditText, Button, Toast |
| 07 | Soma de dois números | 2x EditText (number), Button, TextView |
| 08 | Alterar texto ao clicar no botão | TextView, Button |
| 09 | Seleção Masculino/Feminino | 2x Button, TextView |
| 10 | Tela de login (email+senha) com Toast "Login realizado" | EditText (email, senha), Button, Toast |

### NÍVEL 3 — NAVEGAÇÃO ENTRE TELAS
| Ex | Descrição | Componentes |
|----|-----------|-------------|
| 11 | Navegar para 2ª tela com mensagem | Intent, 2 Activities |
| 12 | Enviar nome para 2ª tela: "Olá, [nome]" | Intent + putExtra |
| 13 | Enviar nome+idade: "[nome] tem [idade] anos" | Intent + putExtra (2 dados) |
| 14 | Botão "Voltar" na 2ª tela | finish() |
| 15 | Exibir dados com formatação diferenciada | setTextSize, setTypeface, SpannableString |

### NÍVEL 4 — DESAFIOS
| Ex | Descrição | Componentes |
|----|-----------|-------------|
| 16 | Cadastro (nome+email+senha) → enviar para 2ª tela | 3 EditText + Intent |
| 17 | Validação completa: campos vazios + mensagens de erro | setError() em cada EditText |
| 18 | Botão "Abrir câmera", capturar foto e exibir | Intent ACTION_IMAGE_CAPTURE, ImageView |
| 19 | App 3 telas: formulário → dados → câmera | 3 Activities |
| 20 | App completo: login → boas-vindas → câmera | 3 Activities, validação, câmera |

## Como pedir exercícios ao Claude Code

### Para fazer um exercício específico:
```
Faça o exercício 7 da lista: soma de dois números.
Crie Ex07Activity.java e activity_ex07.xml.
Registre no AndroidManifest.xml.
Adicione o botão no menu da MainActivity.
```

### Para fazer um nível inteiro:
```
Faça todos os exercícios do Nível 1 (ex 01 a 05).
Siga as convenções do CLAUDE.md.
Registre todas Activities no Manifest.
Atualize o menu da MainActivity.
```

### Para revisar:
```
Revise todos os exercícios. Verifique se:
- Toda Activity está registrada no Manifest
- Todo layout segue o padrão de nomes
- Todo exercício tem botão no menu principal
- O código segue o padrão do professor (EdgeToEdge, lambda, camelCase IDs)
```
