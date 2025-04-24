package com.facens.bolo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.bolo.dtos.PedidoDTO;
import com.facens.bolo.exceptions.RegraNegocioException;
import com.facens.bolo.model.Pedido;
import com.facens.bolo.model.Sabor;
import com.facens.bolo.model.SaborPedido;
import com.facens.bolo.repository.PedidoRepository;
import com.facens.bolo.repository.SaborRepository;

@Service
public class PedidoService implements IPedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private SaborRepository saborRepository;

    @Override
    public Pedido salvar(PedidoDTO pedido){
        Pedido entidade = new Pedido();
        entidade.setStatus(pedido.getStatus());

        List<SaborPedido> sabores = new ArrayList<SaborPedido>();
        pedido.getSabores().forEach(s -> {
            Sabor sabor = saborRepository.findById(s.getSaborId()).orElseThrow(() -> new RegraNegocioException("Sabor não encontrado!"));
            SaborPedido saborPedido = new SaborPedido();
            saborPedido.setSabor(sabor);
            saborPedido.setQuantidade(s.getQuantidade());
            sabores.add(saborPedido);
        });
        entidade.setSabores(sabores);

        return pedidoRepository.save(entidade);
    }

    @Override
    public Iterable<Pedido> getPedidos(){
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido atualizarStatus(PedidoDTO pedido){
        Pedido entidade = pedidoRepository.findById(pedido.getId()).orElseThrow(() -> new RegraNegocioException("Pedido não encontrado!"));
        entidade.setStatus(pedido.getStatus());
        return pedidoRepository.save(entidade);
    }

    public Pedido getById(int  id){
        return pedidoRepository.findById(id).get();
    }

    public void deleteById(int  id){
        pedidoRepository.deleteById(id);
    }
}