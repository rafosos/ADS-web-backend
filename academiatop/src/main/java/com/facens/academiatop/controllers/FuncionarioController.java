package com.facens.academiatop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facens.academiatop.models.Funcionario;
import com.facens.academiatop.services.FuncionarioService;

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
    public Funcionario getById(@PathVariable Long id){
        return funcionarioService.getById(id);
    }

    @PostMapping("/")
    public Funcionario addFuncionario(@RequestBody Funcionario funcionario){
        return funcionarioService.addFuncionario(funcionario);
    }

    @PatchMapping("/")
    public Funcionario editarFuncionario(@RequestBody Funcionario funcionario){
        return funcionarioService.editarFuncionario(funcionario);
    }
}
