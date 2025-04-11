package com.facens.lojaeletronico.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facens.lojaeletronico.models.Produto;
import com.facens.lojaeletronico.services.ProdutoService;

import jakarta.websocket.server.PathParam;

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
    public Produto getById(@PathParam("id") int  id){
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
    public void deleteById(@PathParam("id") int  id){
       produtoService.deleteById(id);
    }
}
