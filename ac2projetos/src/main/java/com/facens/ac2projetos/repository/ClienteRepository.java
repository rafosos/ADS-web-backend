package com.facens.ac2projetos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facens.ac2projetos.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
