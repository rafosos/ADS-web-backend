package com.facens.cursos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String nome;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Column(nullable = false)
    private int cargaHoraria;
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Curso() { }
    public Curso(Long id, String nome, int cargaHoraria) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }
}
