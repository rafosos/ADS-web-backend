package com.facens.ac1petshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.ac1petshop.models.Animal;
import com.facens.ac1petshop.repository.AnimalRepository;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public Animal add(Animal animal){
        return animalRepository.save(animal);
    }

    public Animal edit(Animal animal){
        return animalRepository.save(animal);
    }

    public Animal getById(Long id){
        return animalRepository.findById(id).get();
    }

    public Iterable<Animal> getAll(){
        return animalRepository.findAll();
    }

    public void deleteById(Long id){
        animalRepository.deleteById(id);
    }
}
