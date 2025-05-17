package com.facens.ac2projetos.exceptions;

public class RegraNegocioException extends RuntimeException{
    public RegraNegocioException(String mensagem){
        super(mensagem);
    }
}