package com.facens.cursos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facens.cursos.models.Curso;
import com.facens.cursos.services.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping("/")
    public Iterable<Curso> getCursos(){
        return cursoService.getCursos();
    }

    @GetMapping("/by-id/{id}")
    public Curso getById(@PathVariable Long id){
        return cursoService.findById(id);
    }

    @GetMapping("/by-nome/{name}")
    public Curso getByName(@PathVariable String name){
        return cursoService.findByNome(name);
    }

    @PostMapping("/")
    public void addCurso(@RequestBody Curso curso){
        cursoService.addCurso(curso);
    }

}
