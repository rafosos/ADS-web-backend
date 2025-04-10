package com.facens.ac1petshop.models;

import java.util.ArrayList;
import java.util.List;

import com.facens.ac1petshop.Cor;
import com.facens.ac1petshop.Especie;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Animal {
    // id (Long) → Identificador único do animal.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // especie (String) → Exemplo: "Cão", "Gato".
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Especie especie;

    // nome (String) → Nome do animal.
    @Column(nullable = false, length = 255)
    private String nome;
    
    // idade (Integer) → Idade do animal.
    @Column(nullable = false)
    private int idade;
    
    // cor (String) → Cor predominante do animal.
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Cor cor;
    
    // observacao (String) → Campo para observações gerais.
    @Column(nullable = false, length = 255)
    private String observacao;
    
    // clienteId (Long) → Referência ao dono do animal.
    // Relacionamento: Cada animal pertence a um cliente.
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="clienteId", nullable = false) //Um Animal não pode ser cadastrado sem um Cliente.
    private Cliente cliente;
    
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Servico> servicos = new ArrayList<>();}
