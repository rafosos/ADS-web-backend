package com.facens.lojaeletronico.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facens.lojaeletronico.models.Funcionario;
import com.facens.lojaeletronico.services.FuncionarioService;

import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("/funcionario")

public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

        @GetMapping("/")
    public Iterable<Funcionario> getAll(){
        return funcionarioService.getAll();
    }

    @GetMapping("/{id}")
    public Funcionario getById(@PathParam("id") int  id){
        return funcionarioService.getById(id);
    }

    @PostMapping("/")
    public Funcionario add(@RequestBody Funcionario funcionario){
        return funcionarioService.add(funcionario);
    }

    @PatchMapping("/")
    public Funcionario edit(@RequestBody Funcionario funcionario){
        return funcionarioService.edit(funcionario);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathParam("id") int  id){
       funcionarioService.deleteById(id);
    }
}


