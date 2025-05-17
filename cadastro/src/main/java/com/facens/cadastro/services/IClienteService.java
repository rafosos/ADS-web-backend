package com.facens.cadastro.services;

import com.facens.cadastro.dtos.ClienteDTO;
import com.facens.cadastro.models.Cliente;

public interface IClienteService {
    Cliente adicionar(ClienteDTO cliente);
    Iterable<ClienteDTO> getAll();
}
