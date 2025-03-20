package com.pet.pet.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pet.pet.models.Pet;

@Service
public class PetService {
    private List<Pet> pets = new ArrayList<>();

    public int addPet(Pet pet) throws Exception{
        if(pet == null)
            throw new Exception("Pet não pode ser null");

        pets.add(pet);
        return pet.getId();
    }

    public List<Pet> getPets(){
        return pets;
    }

    public boolean deletePet(int id) throws Exception{
        try{
            pets.removeIf(pet -> pet.getId() == id);
            return true;
        }catch (Exception e){
            throw new Exception("Index não encontrado ou inválido.");
        }
    }
}
