package com.facens.academiatop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facens.academiatop.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

    Aluno findAlunoById(Long id);
}
