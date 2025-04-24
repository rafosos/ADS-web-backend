package com.facens.bolo.model;

import java.util.List;

import com.facens.bolo.EStatusPedido;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Pedido {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<SaborPedido> sabores;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EStatusPedido status;
}