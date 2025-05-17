package com.facens.cadastro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facens.cadastro.dtos.ClienteDTO;
import com.facens.cadastro.models.Cliente;
import com.facens.cadastro.services.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired private ClienteService clienteService;

    @GetMapping("/")
    private Iterable<ClienteDTO> getAll(){
        return clienteService.getAll();
    }

    @PostMapping("/")
    private Cliente adicionar(@Valid @RequestBody ClienteDTO cliente){
        return clienteService.adicionar(cliente);
    }
}