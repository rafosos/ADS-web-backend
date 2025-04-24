package com.facens.bolo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facens.bolo.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}