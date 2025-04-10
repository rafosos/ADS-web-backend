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

import com.facens.ac1petshop.models.Animal;
import com.facens.ac1petshop.services.AnimalService;

@RestController
@RequestMapping("/animal")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @GetMapping("/")
    public Iterable<Animal> getAll(){
        return animalService.getAll();
    }

    @GetMapping("/{id}")
    public Animal getById(@PathVariable Long id){
        return animalService.getById(id);
    }

    @PostMapping("/")
    public Animal add(@RequestBody Animal animal){
        return animalService.add(animal);
    }

    @PatchMapping("/")
    public Animal edit(@RequestBody Animal animal){
        return animalService.edit(animal);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        animalService.deleteById(id);
    }
}
