package com.facens.seguranca.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AutenticacaoDTO {
    private String email;
    private String senha;
}
