package com.facens.ecommerce.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Produto {
    @Id
    @NotNull(message = "O id não pode ser nulo.")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotNull(message = "O nome não pode ser nulo.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    private String nome;

    @Column(nullable = true, length = 500)
    @Size(max = 500, message = "A descrição deve ter até 500 caracteres.")
    private String descricao;

    @Column(nullable = false)
    @NotNull(message = "O preço não pode ser nulo.")
    @DecimalMin(message = "O preço deve ser no mínimo 0,01.", value = "0.01")
    private BigDecimal preco;

    @Column(nullable = false)
    @Min(value = 0, message = "A quantidade míniva deve ser 0.")
    private int quantidadeEstoque;

    @Column(nullable = false)
    @NotNull(message = "A categoria não pode ser nula.")
    private String categoria;
}
