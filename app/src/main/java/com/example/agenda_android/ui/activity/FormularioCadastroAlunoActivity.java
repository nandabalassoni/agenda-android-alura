package com.example.agenda_android.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.agenda_android.R;
import com.example.agenda_android.dao.AlunoDAO;
import com.example.agenda_android.model.Aluno;

public class FormularioCadastroAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_cadastro_aluno);

        AlunoDAO dao = new AlunoDAO();

        final EditText campoNome = findViewById(R.id.activity_formulario_nome_aluno);
        final EditText campoTelefone = findViewById(R.id.activity_formulario_telefone_aluno);
        final EditText campoEmail = findViewById(R.id.activity_formulario_email_aluno);

        Button botaoSalvar = findViewById(R.id.activity_formulario_botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = campoNome.getText().toString();
                String telefone = campoTelefone.getText().toString();
                String email = campoEmail.getText().toString();

                Aluno alunoCriado = new Aluno(nome, telefone, email);
                dao.salva(alunoCriado);

                startActivity(new Intent(FormularioCadastroAlunoActivity.this,
                        ListaAlunosActivity.class));
            }
        });
    }
}
