package com.facens.ac2projetos.service;

import com.facens.ac2projetos.dtos.ColaboradorDTO;
import com.facens.ac2projetos.model.Colaborador;

public interface IColaboradorService {
    Colaborador cadastrar(ColaboradorDTO colaborador);
    Iterable<Colaborador> getColaboradores();
}
