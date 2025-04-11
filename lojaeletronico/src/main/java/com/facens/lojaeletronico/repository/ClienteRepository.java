package com.facens.lojaeletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facens.lojaeletronico.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
