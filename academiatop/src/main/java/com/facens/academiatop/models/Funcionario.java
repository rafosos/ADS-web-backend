package com.facens.academiatop.models;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.facens.academiatop.Cargos;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
import jakarta.persistence.Table;

@Entity
@Table(name="funcionario")
public class Funcionario {
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Cargos cargo;
    public Cargos getCargo() {
        return cargo;
    }
    public void setCargo(Cargos cargo) {
        this.cargo = cargo;
    }

    @CreationTimestamp
    private LocalDate dataContratacao;
    public LocalDate getDataContratacao() {
        return dataContratacao;
    }
    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    @ManyToMany
    @JoinTable(name="aluno_funcionario", 
    joinColumns = @JoinColumn(name="funcionario_id"),
    inverseJoinColumns = @JoinColumn(name = "aluno_id"))
    private List<Aluno> alunos;
    
    @JsonIgnore //prevenir recursão infinita no get
    public List<Aluno> getAlunos() {
        return alunos;
    }
    
    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Funcionario() { }
    public Funcionario(Long id, String nome, Cargos cargo, LocalDate dataContratacao) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.dataContratacao = dataContratacao;
    }
}
