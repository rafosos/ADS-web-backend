package com.facens.ac2projetos.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nomeEmpresa;

    @Column(nullable = false, length = 14)
    private String cnpj;

    @Column(nullable = false, length = 15)
    private String contato;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Projeto> projetos;
}
