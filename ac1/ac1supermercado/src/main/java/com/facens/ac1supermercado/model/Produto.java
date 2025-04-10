package com.facens.ac1supermercado.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(length = 255, nullable = false)
    private String descricao;
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column(nullable = false)
    private double preco;
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Setor setor;
    public Setor getSetor() {
        return setor;
    }
    public void setSetor(Setor setor) {
        this.setor = setor;
    }
    
    @Column(nullable = false)
    private LocalDate validade;
    public LocalDate getValidade() {
        return validade;
    }
    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Venda> vendas = new ArrayList<>();

    public Produto(){}
    public Produto(String descricao, double preco, Setor setor, LocalDate validade) {
        this.descricao = descricao;
        this.preco = preco;
        this.setor = setor;
        this.validade = validade;
    }
}
