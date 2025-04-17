package com.facens.lojaeletronico.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Produto {

    public Produto() { }
    public Produto(String nome, String codBarra, Double preco) {
        this.nome = nome;
        this.codBarra = codBarra;
        this.preco = preco;
        this.vendas = new ArrayList<>();
    }

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column (nullable= false, length = 255)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column (nullable = false)
    private String codBarra;

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    @Column (nullable = false)
    private Double preco;

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @ManyToMany (mappedBy= "produtos")
    @JsonBackReference
    private List<Venda> vendas;
    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

}
