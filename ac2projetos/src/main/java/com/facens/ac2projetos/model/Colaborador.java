package com.facens.ac2projetos.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false, length = 255)
    private String cargo;

    @Column(nullable = false, length = 255)
    private String email;

    @ManyToMany
    @JoinTable(name = "colaborador_projeto",
    joinColumns = @JoinColumn(name="colaborador_id"),
    inverseJoinColumns = @JoinColumn(name="projeto_id"))
    private List<Projeto> projetos;
}
