package com.facens.ac1petshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.ac1petshop.models.Produto;
import com.facens.ac1petshop.repository.ProdutoRepository;

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

    public Produto getById(Long id){
        return produtoRepository.findById(id).get();
    }

    public Iterable<Produto> getAll(){
        return produtoRepository.findAll();
    }

    public void deleteById(Long id){
        produtoRepository.deleteById(id);
    }
}
