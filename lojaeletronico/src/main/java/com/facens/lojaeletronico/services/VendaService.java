package com.facens.lojaeletronico.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.lojaeletronico.models.Produto;
import com.facens.lojaeletronico.models.Venda;
import com.facens.lojaeletronico.repository.ProdutoRepository;
import com.facens.lojaeletronico.repository.VendaRepository;

@Service

public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Venda add(Venda venda) throws Exception{
        if (venda.getProdutos() == null || venda.getProdutos().isEmpty()){
            throw new Exception("tem que inserir produto filho da puta");
        }
        
        if (venda.getCliente() == null){
            throw new Exception("Para adicionar uma venda tem que ter cliente");
        }
        
        if (venda.getFuncionario() == null){
            throw new Exception("Para adicionar uma venda tem que ter funcionario");
        }
        
        Venda entidade = new Venda(venda.getCliente(), venda.getFuncionario());
        venda.getProdutos().forEach(p -> {
            Produto prodEntidade = produtoRepository.findById(p.getId()).get();
            entidade.getProdutos().add(prodEntidade);
        });

        return vendaRepository.save(entidade);
    }

    public Venda edit(Venda venda) throws Exception{
        if (venda.getProdutos().isEmpty()){
            throw new Exception("tem que inserir produto filho da puta");
        }

        if (venda.getCliente() == null){
            throw new Exception("Para adicionar uma venda tem que ter cliente");
        }

        if (venda.getFuncionario() == null){
            throw new Exception("Para adicionar uma venda tem que ter funcionario");
        }

        List<Produto> produtosEntidades = new ArrayList<>(); 
        venda.getProdutos().forEach(p -> {
            Produto prodEntidade = produtoRepository.findById(p.getId()).get();
            produtosEntidades.add(prodEntidade);
        });

        venda.setProdutos(produtosEntidades);

        return vendaRepository.save(venda);
    }

    public Venda getById(int  id){
        return vendaRepository.findById(id).get();
    }

    public Iterable<Venda> getAll(){
        return vendaRepository.findAll();
    }

    public void deleteById(int  id){
        vendaRepository.deleteById(id);
    }
}
    