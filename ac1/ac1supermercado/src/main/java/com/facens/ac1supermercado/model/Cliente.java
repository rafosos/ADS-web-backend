package com.facens.ac1supermercado.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false, length = 11)
    private String cpf;
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Column(nullable = false, length = 100)
    private String nome;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(nullable = false, length = 15) //baseado na recomendação da International Telecommunication Union (ITU)
    private String celular;
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Venda> vendas = new ArrayList<>();

    public Cliente(){}
    public Cliente(String cpf, String celular, String nome) {
        this.cpf = cpf;
        this.celular = celular;
        this.nome = nome;
    }
}
