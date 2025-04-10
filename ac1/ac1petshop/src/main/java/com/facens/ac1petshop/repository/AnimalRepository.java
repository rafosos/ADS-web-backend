package com.facens.ac1petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facens.ac1petshop.models.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long>{

}
