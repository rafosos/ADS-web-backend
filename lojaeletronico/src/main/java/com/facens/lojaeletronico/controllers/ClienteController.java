package com.facens.lojaeletronico.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facens.lojaeletronico.models.Cliente;
import com.facens.lojaeletronico.services.ClienteService;

import jakarta.websocket.server.PathParam;



@RestController
@RequestMapping("/cliente")

public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/")
    public Iterable<Cliente> getAll(){
        return clienteService.getAll();
    }

    @GetMapping("/{id}")
    public Cliente getById(@PathParam("id") int  id){
        return clienteService.getById(id);
    }

    @PostMapping("/")
    public Cliente add(@RequestBody Cliente cliente){
        return clienteService.add(cliente);
    }

    @PatchMapping("/")
    public Cliente edit(@RequestBody Cliente cliente){
        return clienteService.edit(cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathParam("id") int  id){
       clienteService.deleteById(id);
    }
}