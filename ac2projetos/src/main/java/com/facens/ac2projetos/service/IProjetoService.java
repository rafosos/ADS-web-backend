package com.facens.ac2projetos.service;

import com.facens.ac2projetos.dtos.ProjetoDTO;
import com.facens.ac2projetos.model.Projeto;

public interface IProjetoService {
    Projeto cadastrar(ProjetoDTO projeto);
    Iterable<Projeto> getProjetos();
    Projeto atualizarStatus(ProjetoDTO projeto);
    Projeto atualizar(ProjetoDTO projeto);
    void deletarProjeto(Long id);
}
