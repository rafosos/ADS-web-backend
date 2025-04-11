package com.facens.lojaeletronico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.lojaeletronico.models.Funcionario;
import com.facens.lojaeletronico.repository.FuncionarioRepository;

@Service

public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

        public Funcionario add(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario edit(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario getById(int  id){
        return funcionarioRepository.findById(id).get();
    }

    public Iterable<Funcionario> getAll(){
        return funcionarioRepository.findAll();
    }

    public void deleteById(int  id){
        funcionarioRepository.deleteById(id);
    }
}
