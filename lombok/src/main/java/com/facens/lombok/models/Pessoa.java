package com.facens.lombok.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;
    public String getNome() {
        return nome;
    }

    @Column(nullable = false)
    private double salario;

    public Pessoa() { }
    public Pessoa(Long id, String nome, double salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }
}
