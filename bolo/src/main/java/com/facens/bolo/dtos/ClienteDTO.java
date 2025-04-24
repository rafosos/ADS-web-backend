package com.facens.bolo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private int id;
    private String cpf;
    private String telefone;
    private String nome;
}
