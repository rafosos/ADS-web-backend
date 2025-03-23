package com.facens.academiatop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facens.academiatop.models.Treino;

public interface TreinoRepository extends JpaRepository<Treino, Long>{

    Iterable<Treino> findAllByAlunoId(Long alunoId);
}
