package com.facens.bolo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {

     @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

}
