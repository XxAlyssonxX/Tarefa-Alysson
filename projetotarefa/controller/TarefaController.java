package com.projetotarefa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetotarefa.entities.Tarefa;
import com.projetotarefa.services.TarefaService;

@RestController 
@RequestMapping("/tarefa") 
public class TarefaController { 

	private final TarefaService tarefaService; 

	@Autowired 
	public TarefaController(TarefaService tarefaService) { 
		this.tarefaService = tarefaService; 
	} 

	@GetMapping("/{id}") 
	public ResponseEntity<Tarefa> buscaTarefaControlId(@PathVariable Long id) { 
		Tarefa tarefa = tarefaService.buscaTarefaPeloCodigo(id); 
		if (tarefa != null) { 
			return ResponseEntity.ok(tarefa); 
		} else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 

	@GetMapping 
	public ResponseEntity<List<Tarefa>> buscaTodosTarefaControl() { 
		List<Tarefa> tarefa = tarefaService.buscaTodasTarefa(); 
		return ResponseEntity.ok(tarefa); 
	} 

	@PostMapping("/") 
	public ResponseEntity<Tarefa> salvaTarefaControl(@RequestBody Tarefa tarefa) { 
		Tarefa salvaTarefa = tarefaService.salvaTarefa(tarefa); 
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaTarefa); 
	} 

	@PutMapping("/{id}") 
	public ResponseEntity<Tarefa> alteraTarefaControl(@PathVariable Long id, @RequestBody Tarefa tarefa) { 
		Tarefa alterarTarefa = tarefaService.alterartarefa(tarefa, id); 
		if (alterarTarefa != null) { 
			return ResponseEntity.ok(tarefa); 
		} else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 

	@DeleteMapping("/{codigo}") 
	public ResponseEntity<String> apagaTarefaControl(@PathVariable Long id) { 
		boolean tarefa = tarefaService.apagarTarefa(id); 
		if (tarefa) { 
			return ResponseEntity.ok().body("O tarefa foi excluído com sucesso"); 
		} else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 
} 
