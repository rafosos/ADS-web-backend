package com.facens.ac2projetos.service;

import com.facens.ac2projetos.dtos.ClienteDTO;
import com.facens.ac2projetos.model.Cliente;

public interface IClienteService {
    Cliente cadastro(ClienteDTO cliente);
    Iterable<Cliente> getClientes();
}
