package com.pet.pet.models;

public class Pet {
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    private String nome;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    private String raca;
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }

    private String cor;
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    private Double peso;
    public Double getPeso() {
        return peso;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }

    private String tamanho;
    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    
    public Pet() { }
    public Pet(int id, String nome, String raca, String cor, Double peso, String tamanho) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.cor = cor;
        this.peso = peso;
        this.tamanho = tamanho;
    }

}
