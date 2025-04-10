package com.facens.ac1supermercado.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.facens.ac1supermercado.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{
    // Buscar todas as vendas do cliente: José Antônio Souza e Cruz.
    @Query(value="SELECT venda.* from venda join cliente c on c.id = venda.cliente_id where c.nome = ?1", nativeQuery = true)
    Iterable<Venda> findByNomeCliente(String nomeCliente);

    // Buscar todas as vendas cujo valor total seja maior que R$ 1528,32.
    Iterable<Venda> findByValorTotalGreaterThan(double preco);

    // Buscar todas as vendas realizadas entre 01/01/2025 a 31/03/2025.
    Iterable<Venda> findByDataVendaBetween(LocalDateTime data1, LocalDateTime data2);
}