package com.facens.cursos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.cursos.models.Curso;
import com.facens.cursos.repositories.CursoRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso findById(Long id){
        return cursoRepository.findById(id).get();
    }

    public Curso findByNome(String nome){
        return cursoRepository.findCursoByNome(nome);
    }

    public Iterable<Curso> getCursos(){
        return cursoRepository.findAll();
    }

    public void addCurso(Curso curso){
        cursoRepository.save(curso);
    }
}
