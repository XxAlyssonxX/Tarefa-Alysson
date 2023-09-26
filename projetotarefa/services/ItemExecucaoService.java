package com.projetotarefa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetotarefa.entities.ItemExecucao;
import com.projetotarefa.repository.ItemExecucaoRepository;

@Service
public class ItemExecucaoService {
	private final ItemExecucaoRepository itemExecucaoRepository; 

	@Autowired 
	public ItemExecucaoService(ItemExecucaoRepository itemExecucaoRepository) { 
		this.itemExecucaoRepository = itemExecucaoRepository; 
	} 

	public List<ItemExecucao> buscaTodasItemExecucao() { 
		return itemExecucaoRepository.findAll(); 
	} 

	public ItemExecucao buscaItemExecucaoPeloCodigo(Double percentual) { 
		Optional<ItemExecucao> itemExecucao = itemExecucaoRepository.findById(percentual); 
		return itemExecucao.orElse(null); 
	} 

	public ItemExecucao salvaItemExecucao(ItemExecucao itemExecucao) { 
		return itemExecucaoRepository.save(itemExecucao); 
	} 

	public ItemExecucao alteraritemExecucao(ItemExecucao alteraritemExecucao, Double percentual) { 
		Optional<ItemExecucao> existeItemExecucao = itemExecucaoRepository.findById(percentual); 
		if (existeItemExecucao.isPresent()) { 
			alteraritemExecucao.setPercentual(percentual); 
			return itemExecucaoRepository.save(alteraritemExecucao); 
		} 
		return null; 
	} 

	public boolean apagaritemExecucao(Double percentual) { 
		Optional<ItemExecucao> existeItemExecucao = itemExecucaoRepository.findById(percentual); 
		if (existeItemExecucao.isPresent()) { 
			itemExecucaoRepository.deleteById(percentual); 
			return true; 
		} 
		return false; 
	} 
}
