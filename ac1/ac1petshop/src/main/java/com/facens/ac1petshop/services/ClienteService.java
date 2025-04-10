package com.facens.ac1petshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.ac1petshop.models.Cliente;
import com.facens.ac1petshop.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente add(Cliente cliente) throws Exception{
        if(cliente.getServicos().isEmpty()){
            throw new Exception("Cliente deve ter ao menos um serviço!");
        }

        return clienteRepository.save(cliente);
    }

    public Cliente edit(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente getById(Long id){
        return clienteRepository.findById(id).get();
    }

    public Iterable<Cliente> getAll(){
        return clienteRepository.findAll();
    }

    public void deleteById(Long id){
        clienteRepository.deleteById(id);
    }
}
