package com.facens.seguranca.exceptions;

public class RegraNegocioException extends RuntimeException{
    public RegraNegocioException(String mensagem){
        super(mensagem);
    }
}