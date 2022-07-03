package com.example.agenda_android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda_android.R;
import com.example.agenda_android.dao.AlunoDAO;
import com.example.agenda_android.model.Aluno;

import java.io.Serializable;

public class FormularioCadastroAlunoActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Novo aluno";
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    private final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_cadastro_aluno);
        setTitle(APPBAR_TITLE);
        inicializacaoCampos();
        configuraBotaoSalvar();

        Intent dadosColetadosAlunos = getIntent();
        Aluno aluno = (Aluno) dadosColetadosAlunos.getSerializableExtra("aluno");
        campoNome.setText(aluno.getNome());
        campoTelefone.setText(aluno.getTelefone());
        campoEmail.setText(aluno.getEmail());
    }

    private void configuraBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.activity_formulario_botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Aluno alunoCriado = criaAluno();
                salva(alunoCriado);
            }
        });
    }

    private void inicializacaoCampos() {
        campoNome = findViewById(R.id.activity_formulario_nome_aluno);
        campoTelefone = findViewById(R.id.activity_formulario_telefone_aluno);
        campoEmail = findViewById(R.id.activity_formulario_email_aluno);
    }

    private void salva(Aluno aluno) {
        dao.salva(aluno);
        finish();
    }

    @NonNull
    private Aluno criaAluno() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        Aluno alunoCriado = new Aluno(nome, telefone, email);
        return alunoCriado;
    }
}
