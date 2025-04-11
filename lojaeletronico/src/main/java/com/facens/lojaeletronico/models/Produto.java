package com.facens.lojaeletronico.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Produto {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column (nullable= false, length = 255)
    private String nome;

    @Column (nullable = false)
    private String codBarra;

    @Column (nullable = false)
    private Double preco;

    @ManyToMany (mappedBy= "produtos")
    private List<Venda> vendas;

}
