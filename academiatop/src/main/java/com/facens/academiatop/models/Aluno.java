package com.facens.academiatop.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.facens.academiatop.TipoPlano;
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
import jakarta.persistence.Table;

@Entity
@Table(name="aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(length = 100, nullable = false)
    private String nome;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(nullable = false)
    private int idade;
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    @CreationTimestamp
    private LocalDate dataMatricula;
    public LocalDate getDataMatricula() {
        return dataMatricula;
    }
    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoPlano plano;
    public TipoPlano getPlano() {
        return plano;
    }
    public void setPlano(TipoPlano plano) {
        this.plano = plano;
    }

    @ManyToMany
    @JoinTable(name="aluno_funcionario", 
        joinColumns = @JoinColumn(name="aluno_id"),
        inverseJoinColumns = @JoinColumn(name = "funcionario_id"))
    private List<Funcionario> funcionarios;
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Treino> treinos = new ArrayList<>();
    public List<Treino> getTreinos() {
        return treinos;
    }
    public void setTreinos(List<Treino> treinos) {
        this.treinos = treinos;
    }

    public Aluno() { }
    public Aluno(Long id, String nome, int idade, LocalDate dataMatricula, TipoPlano plano) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.dataMatricula = dataMatricula;
        this.plano = plano;
    }
}
