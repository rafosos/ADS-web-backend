package com.facens.lojaeletronico.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facens.lojaeletronico.models.Venda;
import com.facens.lojaeletronico.services.VendaService;

@RestController
@RequestMapping("/venda")

public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping("/")
    public Iterable<Venda> getAll(){
        return vendaService.getAll();
    }

    @GetMapping("/{id}")
    public Venda getById(@PathVariable int  id){
        return vendaService.getById(id);
    }

    @PostMapping("/")
    public Venda add(@RequestBody Venda venda) throws Exception{
        return vendaService.add(venda);
    }

    @PatchMapping("/")
    public Venda edit(@RequestBody Venda venda) throws Exception{
        return vendaService.edit(venda);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
       vendaService.deleteById(id);
    }
}
