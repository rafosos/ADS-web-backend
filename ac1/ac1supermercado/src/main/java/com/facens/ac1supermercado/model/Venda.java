package com.facens.ac1supermercado.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false, length = 255)
    private String descricaoProduto;

    public String getDescricaoProduto() {
        return descricaoProduto;
    }
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    @Column(nullable = false)
    private int quantidade;

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Column(nullable = false)
    private double precoProduto;

    public double getPrecoProduto() {
        return precoProduto;
    }
    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    @Column(nullable = false)
    private double valorTotal; // (quantidade x precoProduto)
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal){
        this.valorTotal = this.quantidade * this.precoProduto;
    }

    // @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime dataVenda; 
    public LocalDateTime getDataVenda() {
        return dataVenda;
    }
    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name= "produto_id")
    private Produto produto;
    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Venda(){}
    public Venda(String descricaoProduto, int quantidade, double precoProduto, Cliente cliente, LocalDateTime dataVenda) {
        this.descricaoProduto = descricaoProduto;
        this.quantidade = quantidade;
        this.precoProduto = precoProduto;
        this.setValorTotal(0);
        this.cliente = cliente;
        this.dataVenda = dataVenda;
    }
}
