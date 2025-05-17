package com.facens.ac2projetos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.ac2projetos.dtos.ClienteDTO;
import com.facens.ac2projetos.model.Cliente;
import com.facens.ac2projetos.repository.ClienteRepository;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente cadastro(ClienteDTO cliente) {
        Cliente entidade = new Cliente();
        entidade.setNomeEmpresa(cliente.getNomeEmpresa());
        entidade.setCnpj(cliente.getCnpj());
        entidade.setContato(cliente.getContato());
        return clienteRepository.save(entidade);
    }

    @Override
    public Iterable<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

}
