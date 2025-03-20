package com.pet.pet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.pet.models.Pet;
import com.pet.pet.services.PetService;

@RestController
@RequestMapping("pets")
public class PetController{
    @Autowired
    private PetService petService;

    @PostMapping("/")
    public int addPet(@RequestBody Pet pet){
        try{
            return petService.addPet(pet);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    } 

    @GetMapping("/")
    public List<Pet> getPets(){
        List<Pet> pets = petService.getPets(); 
        return pets;
    }

    @DeleteMapping("/{id}")
    public boolean deletePet(@PathVariable("id") int id){
        try {
            return petService.deletePet(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}