package com.facens.academiatop.models;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="treino")
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @CreationTimestamp
    private LocalDate dataTreino;
    public LocalDate getDataTreino() {
        return dataTreino;
    }

    public void setDataTreino(LocalDate dataTreino) {
        this.dataTreino = dataTreino;
    }

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Treino() { }
}
