package com.facens.bolo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.bolo.model.Cliente;
import com.facens.bolo.repository.ClienteRepository;

@Service

public class ClienteService {


    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente add(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente edit(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente getById(int  id){
        return clienteRepository.findById(id).get();
    }

    public Iterable<Cliente> getAll(){
        return clienteRepository.findAll();
    }

    public void deleteById(int  id){
        clienteRepository.deleteById(id);
    }
}