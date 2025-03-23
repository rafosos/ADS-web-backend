package com.facens.academiatop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.academiatop.models.Funcionario;
import com.facens.academiatop.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Iterable<Funcionario> getAll(){
        return funcionarioRepository.findAll();
    }

    public Funcionario getById(Long id){
        return funcionarioRepository.findById(id).get();
    }

    public Funcionario addFuncionario(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }
    
    public Funcionario editarFuncionario(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }
}
