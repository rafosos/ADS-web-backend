package com.facens.ac1supermercado.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facens.ac1supermercado.model.Produto;
import com.facens.ac1supermercado.model.Setor;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    // Buscar todos os produtos cujo preço seja maior que R$ 32,00.
    Iterable<Produto> findByPrecoGreaterThan(double preco);

    // Buscar todos os produtos do setor de laticínios.
    Iterable<Produto> findBySetorIs(Setor setor);

    // Buscar todos os produtos que vencem depois de 18/04.
    Iterable<Produto>findByValidadeAfter(LocalDate validade);
}
