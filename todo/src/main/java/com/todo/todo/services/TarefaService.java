package com.todo.todo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.todo.models.Tarefa;
import com.todo.todo.repositories.TarefaRepository;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    public Iterable<Tarefa> listarTarefas(){
        return tarefaRepository.findAll();
    }

    public Tarefa criarTarefa(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    public Tarefa atualizarTarefa(Tarefa tarefa, Long id){
        Tarefa entidade = tarefaRepository.getReferenceById(id);
        entidade.setConcluida(tarefa.isConcluida());
        entidade.setDescricao(tarefa.getDescricao());
        return tarefaRepository.save(entidade);
    }

    public void deletarTarefa(Long id){
        tarefaRepository.deleteById(id);
    }

    public Tarefa getTarefaById(Long id){
        return tarefaRepository.findById(id).get();
    }
}
