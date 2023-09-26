package com.projetotarefa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetotarefa.entities.Tarefa;


public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
