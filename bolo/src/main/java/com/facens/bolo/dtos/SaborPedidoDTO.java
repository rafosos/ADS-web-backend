package com.facens.bolo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaborPedidoDTO {
    private int id;
    private int saborId;
    private int quantidade;
}
