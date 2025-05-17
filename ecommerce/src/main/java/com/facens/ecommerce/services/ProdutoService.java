package com.facens.ecommerce.services;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.ecommerce.dtos.ProdutoDTO;
import com.facens.ecommerce.exceptions.RegraNegocioException;
import com.facens.ecommerce.models.Produto;
import com.facens.ecommerce.repository.IProdutoRepository;

@Service
public class ProdutoService implements IProdutoService{

    @Autowired
    private IProdutoRepository produtoRepository;

    @Override
    public Produto salvar(ProdutoDTO produto) {
        Produto entidade = new Produto();
        return produtoRepository.save(entidade);
    }

    @Override
    public Iterable<ProdutoDTO> getProdutos() {
        return produtoRepository.findAll().stream().map((Produto p) -> {
            return ProdutoDTO.builder()
                .id(p.getId())
                .nome(p.getNome())
                .preco(p.getPreco())
                .quantidadeEstoque(p.getQuantidadeEstoque())
                .categoria(p.getCategoria())
                .build();
        }).collect(Collectors.toList());
    }

    @Override
    public ProdutoDTO getById(Long id) {
        return produtoRepository.findById(id)
        .map((Produto p) -> {
            return ProdutoDTO.builder()
                .id(p.getId())
                .nome(p.getNome())
                .preco(p.getPreco())
                .quantidadeEstoque(p.getQuantidadeEstoque())
                .categoria(p.getCategoria())
                .build();
        }).orElseThrow(() -> new RegraNegocioException("Não foi possível encontrar um produto com o id fornecido."));
    }
}
