package com.facens.ac1petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facens.ac1petshop.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
