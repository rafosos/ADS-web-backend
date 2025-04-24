package com.facens.bolo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.bolo.dtos.SaborDTO;
import com.facens.bolo.model.Sabor;
import com.facens.bolo.repository.SaborRepository;

@Service
public class SaborService implements ISaborService{

    @Autowired
    private SaborRepository saborRepository;

    @Override
    public Sabor salvar(SaborDTO sabor){
        Sabor entidade = new Sabor();
        entidade.setNome(sabor.getNome());
        return saborRepository.save(entidade);
    }

    public Sabor edit(Sabor sabor){
        return saborRepository.save(sabor);
    }

    public Sabor getById(int  id){
        return saborRepository.findById(id).get();
    }

    @Override
    public Iterable<Sabor> getSabores(){
        return saborRepository.findAll();
    }

    public void deleteById(int id){
        saborRepository.deleteById(id);
    }
}