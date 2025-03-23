package com.facens.academiatop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facens.academiatop.models.Treino;
import com.facens.academiatop.services.TreinoService;

@RestController
@RequestMapping("/treino")
public class TreinoController {
    @Autowired
    private TreinoService treinoService;

    @GetMapping("/{alunoId}") //histórico
    public Iterable<Treino> historico(@PathVariable Long alunoId){
        return treinoService.findAllByAlunoId(alunoId);
    }

    @GetMapping("/")
    public Iterable<Treino> findAll(){
        return treinoService.findAll();
    }

    @PostMapping("/")
    public Treino addTreino(@RequestBody Treino treino){
        System.out.println(treino.getAluno());
        return treinoService.addTreino(treino);
    }
}
