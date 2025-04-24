package com.facens.bolo.dtos;

import com.facens.bolo.EStatusPedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
    private int id;
    private EStatusPedido status;
    private Iterable<SaborPedidoDTO> sabores; 
}
