package com.facens.ac2projetos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facens.ac2projetos.dtos.ProjetoDTO;
import com.facens.ac2projetos.model.Projeto;
import com.facens.ac2projetos.service.ProjetoService;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {
    @Autowired private ProjetoService projetoService;

    @PostMapping("/")
    public Projeto cadastrar(@RequestBody ProjetoDTO projetoDTO){
        return projetoService.cadastrar(projetoDTO);
    }

    @GetMapping("/")
    public Iterable<Projeto> getAll(){
        return projetoService.getProjetos();
    }

    @PatchMapping("/status")
    public Projeto atualizarStatus(@RequestBody ProjetoDTO projetoDTO){
        return projetoService.atualizarStatus(projetoDTO);
    }

    @PutMapping("/")
    public Projeto atualizar(@RequestBody ProjetoDTO projetoDTO){
        return projetoService.atualizar(projetoDTO);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        projetoService.deletarProjeto(id);
    }

}
