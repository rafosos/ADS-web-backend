package com.facens.ac1petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facens.ac1petshop.models.Produto;
import com.facens.ac1petshop.services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/")
    public Iterable<Produto> getAll(){
        return produtoService.getAll();
    }

    @GetMapping("/{id}")
    public Produto getById(@PathVariable Long id){
        return produtoService.getById(id);
    }

    @PostMapping("/")
    public Produto add(@RequestBody Produto produto){
        return produtoService.add(produto);
    }

    @PatchMapping("/")
    public Produto edit(@RequestBody Produto produto){
        return produtoService.edit(produto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        produtoService.deleteById(id);
    }
}
