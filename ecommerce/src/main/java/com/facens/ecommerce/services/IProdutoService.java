package com.facens.ecommerce.services;

import com.facens.ecommerce.dtos.ProdutoDTO;
import com.facens.ecommerce.models.Produto;

public interface IProdutoService {
    Produto salvar(ProdutoDTO produto);
    Iterable<ProdutoDTO> getProdutos();
    ProdutoDTO getById(Long id);
}
