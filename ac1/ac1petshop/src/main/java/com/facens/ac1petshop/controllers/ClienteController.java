package com.facens.ac1petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facens.ac1petshop.models.Cliente;
import com.facens.ac1petshop.services.ClienteService;

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
    public Cliente getById(@PathVariable Long id){
        return clienteService.getById(id);
    }

    @PostMapping("/")
    public Cliente add(@RequestBody Cliente cliente){
        try {
            return clienteService.add(cliente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return cliente;        
        }
    }

    @PatchMapping("/")
    public Cliente edit(@RequestBody Cliente cliente){
        return clienteService.edit(cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        clienteService.deleteById(id);
    }

}
