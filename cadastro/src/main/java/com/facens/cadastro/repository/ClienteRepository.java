package com.facens.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facens.cadastro.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
