package com.facens.academiatop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facens.academiatop.models.Aluno;
import com.facens.academiatop.services.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping("/")
    public Iterable<Aluno> getAll(){
        return alunoService.getAll();
    }

    @GetMapping("/{id}")
    public Aluno getById(@PathVariable Long id){
        return alunoService.findById(id);
    }

    @PostMapping("/")
    public Aluno addAluno(@RequestBody Aluno aluno){
        return alunoService.addAluno(aluno);
    }
}
