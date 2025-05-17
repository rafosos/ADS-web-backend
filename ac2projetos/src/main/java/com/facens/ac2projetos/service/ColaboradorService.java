package com.facens.ac2projetos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.ac2projetos.dtos.ColaboradorDTO;
import com.facens.ac2projetos.model.Colaborador;
import com.facens.ac2projetos.repository.ColaboradorRepository;

@Service
public class ColaboradorService implements IColaboradorService{

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Override
    public Colaborador cadastrar(ColaboradorDTO colaborador) {
        Colaborador entidade = new Colaborador();
        entidade.setNome(colaborador.getNome());
        entidade.setCargo(colaborador.getCargo());
        entidade.setEmail(colaborador.getEmail());
        return colaboradorRepository.save(entidade);
    }

    @Override
    public Iterable<Colaborador> getColaboradores() {
        return colaboradorRepository.findAll();
    }

}
