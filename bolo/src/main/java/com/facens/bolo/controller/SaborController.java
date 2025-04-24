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

import com.facens.bolo.model.Sabor;
import com.facens.bolo.service.SaborService;

@RestController
@RequestMapping("/sabor")

public class SaborController {
    @Autowired
    private SaborService saborService;

    @GetMapping("/")
    public Iterable<Sabor> getAll(){
        return SaborService.getAll();
    }

    @GetMapping("/{id}")
    public Sabor getById(@PathVariable int  id){
        return saborService.getById(id);
    }

    @PostMapping("/")
    public Sabor add(@RequestBody Sabor sabor){
        return saborService.add(sabor);
    }

    @PatchMapping("/")
    public Sabor edit(@RequestBody Sabor sabor){
        return saborService.edit(sabor);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int  id){
       saborService.deleteById(id);
    }
}