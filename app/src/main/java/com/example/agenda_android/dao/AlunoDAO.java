package com.example.agenda_android.dao;

import com.example.agenda_android.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();

    public void salva(Aluno aluno) {
        alunos.add(aluno);

    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }
}
