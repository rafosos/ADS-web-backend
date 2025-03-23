package com.facens.academiatop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.academiatop.models.Aluno;
import com.facens.academiatop.repositories.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Iterable<Aluno> getAll(){
        return alunoRepository.findAll();
    }

    public Aluno findById(Long id){
        return alunoRepository.findAlunoById(id);
    }

    public Aluno addAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }

}
