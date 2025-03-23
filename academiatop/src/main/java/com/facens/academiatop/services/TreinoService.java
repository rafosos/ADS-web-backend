package com.facens.academiatop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.academiatop.models.Treino;
import com.facens.academiatop.repositories.TreinoRepository;

@Service
public class TreinoService {
    @Autowired
    private TreinoRepository treinoRepository;

    public Iterable<Treino> findAllByAlunoId(Long id){
        return treinoRepository.findAllByAlunoId(id);
    }

    public Iterable<Treino> findAll(){
        return treinoRepository.findAll();
    }

    public Treino addTreino(Treino treino){
        return treinoRepository.save(treino);
    }
}
