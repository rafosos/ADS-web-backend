package com.facens.ecommerce.exceptions;

public class RegraNegocioException extends RuntimeException{
    public RegraNegocioException(String mensagem){
        super(mensagem);
    }
}
