package com.facens.bolo.service;

import com.facens.bolo.dtos.SaborDTO;
import com.facens.bolo.model.Sabor;

public interface ISaborService {
    Sabor salvar(SaborDTO cliente);
    Iterable<Sabor> getSabores();
}
