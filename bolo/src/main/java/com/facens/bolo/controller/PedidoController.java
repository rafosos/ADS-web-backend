package com.facens.bolo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facens.bolo.model.Pedido;
import com.facens.bolo.service.PedidoService;

@RestController
@RequestMapping("/pedido")

public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/")
    public Iterable<Pedido> getAll(){
        return pedidoService.getAll();
    }

    @GetMapping("/{id}")
    public Pedido getById(@PathVariable int  id){
        return pedidoService.getById(id);
    }

    @PostMapping("/")
    public Pedido add(@RequestBody Pedido pedido){
        return pedidoService.add(pedido);
    }

    @PatchMapping("/")
    public Pedido edit(@RequestBody Pedido pedido){
        return pedidoService.edit(pedido);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int  id){
       pedidoService.deleteById(id);
    }
}