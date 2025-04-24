package com.facens.bolo.service;

import com.facens.bolo.dtos.ClienteDTO;
import com.facens.bolo.model.Cliente;

public interface IClienteService {
    Cliente salvar(ClienteDTO cliente);
    Iterable<Cliente> getClientes();
}
