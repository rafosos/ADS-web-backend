package com.facens.ac2projetos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facens.ac2projetos.dtos.ColaboradorDTO;
import com.facens.ac2projetos.model.Colaborador;
import com.facens.ac2projetos.service.ColaboradorService;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {
    @Autowired private ColaboradorService colaboradorService;

    @PostMapping("/")
    public Colaborador cadastrar(@RequestBody ColaboradorDTO colaboradorDTO){
        return colaboradorService.cadastrar(colaboradorDTO);
    }

    @GetMapping("/")
    public Iterable<Colaborador> getAll(){
        return colaboradorService.getColaboradores();
    }
}
