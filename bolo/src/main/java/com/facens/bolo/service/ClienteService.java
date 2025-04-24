package com.facens.bolo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.bolo.dtos.ClienteDTO;
import com.facens.bolo.model.Cliente;
import com.facens.bolo.repository.ClienteRepository;

@Service
public class ClienteService implements IClienteService{
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente salvar(ClienteDTO cliente){
        Cliente entidade = new Cliente();
        entidade.setNome(cliente.getNome());
        entidade.setCpf(cliente.getCpf());
        entidade.setTelefone(cliente.getTelefone());
        return clienteRepository.save(entidade);
    }

    public Cliente edit(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente getById(int  id){
        return clienteRepository.findById(id).get();
    }

    @Override
    public Iterable<Cliente> getClientes(){
        return clienteRepository.findAll();
    }

    public void deleteById(int id){
        clienteRepository.deleteById(id);
    }
}