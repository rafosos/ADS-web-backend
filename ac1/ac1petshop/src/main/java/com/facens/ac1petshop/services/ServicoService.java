package com.facens.ac1petshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.ac1petshop.models.Servico;
import com.facens.ac1petshop.repository.ServicoRepository;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository servicoRepository;

    public Servico add(Servico servico){
        return servicoRepository.save(servico);
    }

    public Servico edit(Servico servico){
        return servicoRepository.save(servico);
    }

    public Servico getById(Long id){
        return servicoRepository.findById(id).get();
    }

    public Iterable<Servico> getAll(){
        return servicoRepository.findAll();
    }

    public void deleteById(Long id){
        servicoRepository.deleteById(id);
    }
}
