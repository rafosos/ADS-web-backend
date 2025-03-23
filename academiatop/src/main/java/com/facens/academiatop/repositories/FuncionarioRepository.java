package com.facens.academiatop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facens.academiatop.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{ }
