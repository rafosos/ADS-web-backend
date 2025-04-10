package com.facens.ac1supermercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facens.ac1supermercado.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    // Buscar um cliente pelo CPF.
    Cliente findByCpfIs(String cpf);
    
    // Buscar um cliente pelo número de celular.
    Cliente findByCelularIs(String celular);
}
