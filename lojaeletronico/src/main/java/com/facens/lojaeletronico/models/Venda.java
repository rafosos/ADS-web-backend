package com.facens.lojaeletronico.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Venda {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn( name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn( name = "funcionario_id")
    private Funcionario funcionario; 

    @ ManyToMany ( cascade = CascadeType.ALL)
    @JoinTable(name = "produto_venda",
    joinColumns={@JoinColumn(name = "venda_id")},
    inverseJoinColumns= {@JoinColumn(name = "produto_id")})
    private List<Produto> produtos;

}
