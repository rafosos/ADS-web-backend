package com.facens.cursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facens.cursos.models.Curso;

import jakarta.transaction.Transactional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Transactional
    Curso findCursoById(Long id);
    
    @Transactional
    Curso findCursoByNome(String nome);

}