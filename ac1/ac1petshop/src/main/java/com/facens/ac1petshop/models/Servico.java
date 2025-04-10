package com.facens.ac1petshop.models;

import com.facens.ac1petshop.TipoServico;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Servico {
    // id (Long) → Identificador único do serviço.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // descricao (String) → Descrição do serviço.
    @Column(nullable = false, length = 255)
    private String descricao;
    
    // tipo (String) → Exemplo: "Banho", "Tosa", "Consulta Veterinária".
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoServico tipo;
    
    // preco (Double) → Valor do serviço.
    @Column(nullable = false)
    private double preco;
    
    // tempoDuracao (Integer) → Duração em minutos.
    @Column(nullable = false)
    private int tempoDuracao;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="animalId", nullable = true)
    private Animal animal;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="clienteId", nullable = true)
    private Cliente cliente;
}
