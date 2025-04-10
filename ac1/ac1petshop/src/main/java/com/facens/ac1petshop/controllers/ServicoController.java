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

import com.facens.ac1petshop.models.Servico;
import com.facens.ac1petshop.services.ServicoService;

@RestController
@RequestMapping("/Servico")
public class ServicoController {
    @Autowired
    private ServicoService servicoService;

    @GetMapping("/")
    public Iterable<Servico> getAll(){
        return servicoService.getAll();
    }

    @GetMapping("/{id}")
    public Servico getById(@PathVariable Long id){
        return servicoService.getById(id);
    }

    @PostMapping("/")
    public Servico add(@RequestBody Servico servico){
        return servicoService.add(servico);
    }

    @PatchMapping("/")
    public Servico edit(@RequestBody Servico servico){
        return servicoService.edit(servico);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        servicoService.deleteById(id);
    }
}
