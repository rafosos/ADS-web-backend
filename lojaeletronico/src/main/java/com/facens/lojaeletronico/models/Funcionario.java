package com.facens.lojaeletronico.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Id;

    @Column ( nullable= false, length= 255)
    private String nome;

    @Column (nullable= false, length = 11)
    private String cpf;

    @OneToMany( mappedBy= "funcionario", cascade = CascadeType.ALL)
    private List<Venda> vendas = new ArrayList<>();
}
