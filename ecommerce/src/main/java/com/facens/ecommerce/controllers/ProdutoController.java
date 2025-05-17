package com.facens.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facens.ecommerce.dtos.ProdutoDTO;
import com.facens.ecommerce.models.Produto;
import com.facens.ecommerce.services.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/")
    private Iterable<ProdutoDTO> getAll(){
        return produtoService.getProdutos();
    }

    @GetMapping("/{id}")
    private ProdutoDTO getById(@PathVariable Long id){
        return produtoService.getById(id);
    }

    @PostMapping("/")
    private Produto adicionar(@Valid @RequestBody ProdutoDTO produto){
        return produtoService.salvar(produto);
    }
}
