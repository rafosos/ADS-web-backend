package com.facens.ecommerce.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ProdutoDTO {
    private Long id;
    private String nome;
    private BigDecimal preco;
    private int quantidadeEstoque;
    private String categoria;
    private String descricao;
}