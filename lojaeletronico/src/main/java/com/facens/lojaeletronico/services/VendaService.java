package com.facens.lojaeletronico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.lojaeletronico.models.Venda;
import com.facens.lojaeletronico.repository.VendaRepository;

@Service

public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public Venda add(Venda venda){
        return vendaRepository.save(venda);
    }

    public Venda edit(Venda venda){
        return vendaRepository.save(venda);
    }

    public Venda getById(int  id){
        return vendaRepository.findById(id).get();
    }

    public Iterable<Venda> getAll(){
        return vendaRepository.findAll();
    }

    public void deleteById(int  id){
        vendaRepository.deleteById(id);
    }
}
    