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

import com.projetotarefa.entities.ItemExecucao;
import com.projetotarefa.services.ItemExecucaoService;

@RestController 
@RequestMapping("/itemExecucao") 
public class ItemExecucaoController { 

	private final ItemExecucaoService itemExecucaoService; 

	@Autowired 
	public ItemExecucaoController(ItemExecucaoService itemExecucaoService) { 
		this.itemExecucaoService = itemExecucaoService; 
	} 

	@GetMapping("/{id}") 
	public ResponseEntity<ItemExecucao> buscaitemExecucaoControlId(@PathVariable Double percentual) { 
		ItemExecucao itemExecucao = itemExecucaoService.buscaItemExecucaoPeloCodigo(percentual); 
		if (itemExecucao != null) { 
			return ResponseEntity.ok(itemExecucao); 
		} else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 

	@GetMapping 
	public ResponseEntity<List<ItemExecucao>> buscaTodosItemExecucaoControl() { 
		List<ItemExecucao> itemExecucao = itemExecucaoService.buscaTodasItemExecucao(); 
		return ResponseEntity.ok(itemExecucao); 
	} 

	@PostMapping("/") 
	public ResponseEntity<ItemExecucao> salvaItemExecucaoControl(@RequestBody ItemExecucao itemExecucao) { 
		ItemExecucao salvaitemExecucao = itemExecucaoService.salvaItemExecucao(itemExecucao); 
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaitemExecucao); 
	} 

	@PutMapping("/{id}") 
	public ResponseEntity<ItemExecucao> alteraItemExecucaoControl(@PathVariable Double porcentual, @RequestBody ItemExecucao itemExecucao) { 
		ItemExecucao alteraritemExecucao = itemExecucaoService.alteraritemExecucao(itemExecucao, porcentual); 
		if (alteraritemExecucao != null) { 
			return ResponseEntity.ok(itemExecucao); 
		} else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 

	@DeleteMapping("/{codigo}") 
	public ResponseEntity<String> apagaItemExecucaoControl(@PathVariable Double percentual) { 
		boolean itemExecucao = itemExecucaoService.apagaritemExecucao(percentual); 
		if (itemExecucao) { 
			return ResponseEntity.ok().body("O itemExecucao foi excluído com sucesso"); 
		} else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 
} 
