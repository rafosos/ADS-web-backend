package com.facens.lojaeletronico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.lojaeletronico.models.Produto;
import com.facens.lojaeletronico.repository.ProdutoRepository;

@Service

public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

        public Produto add(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto edit(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto getById(int  id){
        return produtoRepository.findById(id).get();
    }

    public Iterable<Produto> getAll(){
        return produtoRepository.findAll();
    }

    public void deleteById(int  id){
        produtoRepository.deleteById(id);
    }
}

