package com.facens.cadastro.services;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.cadastro.dtos.ClienteDTO;
import com.facens.cadastro.models.Cliente;
import com.facens.cadastro.repository.ClienteRepository;

@Service
public class ClienteService implements IClienteService{
    @Autowired private ClienteRepository clienteRepository;

    @Override
    public Cliente adicionar(ClienteDTO cliente) {
        Cliente entidade = new Cliente();
        entidade.setNome(cliente.getNome());
        entidade.setCpf(cliente.getCpf());
        entidade.setDataNascimento(cliente.getDataNascimento());
        entidade.setEmail(cliente.getEmail());
        entidade.setTelefone(cliente.getTelefone());
        return clienteRepository.save(entidade);
    }

    @Override
    public Iterable<ClienteDTO> getAll() {
        return clienteRepository.findAll().stream().map((Cliente c) -> {
            return ClienteDTO.builder()
                .id(c.getId())
                .cpf(c.getCpf())
                .dataNascimento(c.getDataNascimento())
                .email(c.getEmail())
                .telefone(c.getTelefone()).build();
        }).collect(Collectors.toList());
    }
}