package com.facens.ac2projetos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.ac2projetos.dtos.ProjetoDTO;
import com.facens.ac2projetos.exceptions.RegraNegocioException;
import com.facens.ac2projetos.model.Projeto;
import com.facens.ac2projetos.repository.ClienteRepository;
import com.facens.ac2projetos.repository.ColaboradorRepository;
import com.facens.ac2projetos.repository.ProjetoRepository;

@Service
public class ProjetoService implements IProjetoService{

    @Autowired private ProjetoRepository projetoRepository;
    @Autowired private ClienteRepository clienteRepository;
    @Autowired private ColaboradorRepository colaboradorRepository;

    @Override
    public Projeto cadastrar(ProjetoDTO projeto) {
        Projeto entidade = new Projeto();
        entidade.setStatus(projeto.getStatus());
        entidade.setCliente(clienteRepository.findById(projeto.getClienteId()).orElseThrow(() -> new RegraNegocioException("Cliente não encontrado!")));
        if(projeto.getColaboradoresIds() != null){
            entidade.setColaboradores(colaboradorRepository.findAllById(projeto.getColaboradoresIds().get()));
        }
        return projetoRepository.save(entidade);
    }
    
    @Override
    public Iterable<Projeto> getProjetos() {
        return projetoRepository.findAll();
    }
    
    @Override
    public Projeto atualizarStatus(ProjetoDTO projeto) {
        Projeto entidade = projetoRepository.findById(projeto.getId()).orElseThrow(() -> new RegraNegocioException("Projeto não encontrado!"));
        entidade.setStatus(projeto.getStatus());
        return projetoRepository.save(entidade);
    }
    
    @Override
    public Projeto atualizar(ProjetoDTO projeto) {
        Projeto entidade = projetoRepository.findById(projeto.getId()).orElseThrow(() -> new RegraNegocioException("Projeto não encontrado!"));
        entidade.setStatus(projeto.getStatus());
        entidade.setCliente(clienteRepository.findById(projeto.getClienteId()).orElseThrow(() -> new RegraNegocioException("Cliente não encontrado!")));
        if(projeto.getColaboradoresIds() != null){
            entidade.setColaboradores(colaboradorRepository.findAllById(projeto.getColaboradoresIds().get()));
        }
        return projetoRepository.save(entidade);
    }
    
    @Override
    public void deletarProjeto(Long id) {
        Projeto entidade = projetoRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Projeto não encontrado!"));
        projetoRepository.delete(entidade);
    }
}