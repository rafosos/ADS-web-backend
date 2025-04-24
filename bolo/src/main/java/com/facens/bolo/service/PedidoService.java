package com.facens.bolo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.bolo.model.Pedido;
import com.facens.bolo.repository.PedidoRepository;

@Service

public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido add(Pedido pedido){
        
        return pedidoRepository.save(pedido);
    }

    public Pedido edit(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    public Pedido getById(int  id){
        return pedidoRepository.findById(id).get();
    }

    public Iterable<Pedido> getAll(){
        return pedidoRepository.findAll();
    }

    public void deleteById(int  id){
        pedidoRepository.deleteById(id);
    }
}