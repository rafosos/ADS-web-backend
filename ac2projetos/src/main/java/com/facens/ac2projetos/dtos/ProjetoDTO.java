package com.facens.ac2projetos.dtos;

import java.util.List;
import java.util.Optional;

import com.facens.ac2projetos.EStatusProjeto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoDTO {
    private Long id;
    private EStatusProjeto status;
    private Long clienteId;
    private Optional<List<Long>> colaboradoresIds;
}
