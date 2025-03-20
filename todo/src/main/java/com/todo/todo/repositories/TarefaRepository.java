package com.todo.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.todo.models.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

}
