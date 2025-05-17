package com.facens.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facens.ecommerce.models.Produto;

public interface IProdutoRepository extends JpaRepository<Produto, Long>{

}
