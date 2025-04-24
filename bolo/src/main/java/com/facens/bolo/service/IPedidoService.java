package com.facens.bolo.service;

import com.facens.bolo.dtos.PedidoDTO;
import com.facens.bolo.model.Pedido;

public interface IPedidoService {
    Pedido salvar(PedidoDTO cliente);
    Iterable<Pedido> getPedidos();
    Pedido atualizarStatus(PedidoDTO pedido); 
}
