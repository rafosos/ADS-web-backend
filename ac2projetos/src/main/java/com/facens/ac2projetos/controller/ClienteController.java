package com.facens.ac2projetos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facens.ac2projetos.dtos.ClienteDTO;
import com.facens.ac2projetos.model.Cliente;
import com.facens.ac2projetos.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired private ClienteService clienteService;

    @PostMapping("/")
    public Cliente cadastrar(@RequestBody ClienteDTO cliente){
        return clienteService.cadastro(cliente);
    }

    @GetMapping("/")
    public Iterable<Cliente> getAll(){
        return clienteService.getClientes();
    }
}
