package com.facens.ac2projetos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorDTO {
    private Long id;
    private String nome;
    private String cargo;
    private String email;
}
