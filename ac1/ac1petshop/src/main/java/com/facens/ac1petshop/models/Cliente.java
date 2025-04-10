package com.facens.ac1petshop.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Cliente {
    // id (Long) → Identificador único do cliente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // nome (String) → Nome do cliente.
    @Column(nullable = false, length = 255)
    private String nome;
    
    // cpf (String) → CPF do cliente (único).
    @Column(nullable = false, length = 11)
    private String cpf;
    
    // celular (String) → Número de celular do cliente.
    @Column(nullable = false, length = 15)
    private String celular;

    // Relacionamento: Um cliente pode ter vários animais.
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Animal> animais = new ArrayList<>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Servico> servicos = new ArrayList<>();
}
