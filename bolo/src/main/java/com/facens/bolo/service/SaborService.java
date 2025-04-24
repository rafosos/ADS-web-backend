package com.facens.bolo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.bolo.model.Sabor;
import com.facens.bolo.repository.SaborRepository;

@Service

public class SaborService {


    @Autowired
    private SaborRepository saborRepository;

    public Sabor add(Sabor sabor){
        return saborRepository.save(sabor);
    }

    public Sabor edit(Sabor sabor){
        return saborRepository.save(sabor);
    }

    public Sabor getById(int  id){
        return saborRepository.findById(id).get();
    }

    public Iterable<Sabor> getAll(){
        return saborRepository.findAll();
    }

    public void deleteById(int  id){
        saborRepository.deleteById(id);
    }
}