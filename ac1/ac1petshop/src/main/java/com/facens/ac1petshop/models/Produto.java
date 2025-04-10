package com.facens.ac1petshop.models;

import java.time.LocalDate;

import com.facens.ac1petshop.CategoriaProduto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Produto {
//     id (Long) → Identificador único do produto.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

// descricao (String) → Descrição do produto.
    @Column(nullable = false, length = 255)
    private String descricao;

// categoria (String) → Exemplo: "Ração", "Medicamento", "Acessórios".
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoriaProduto categoria;

// validade (LocalDate) → Data de validade (opcional).
    @Column
    private LocalDate validade;

// preco (Double) → Preço unitário do produto.
    @Column(nullable = false)
    private double preco;
}
