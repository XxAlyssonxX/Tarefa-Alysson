package com.projetotarefa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity  
@Table(name = "Tarefa") 
public class Tarefa { 

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id; 
	
	@NotNull(message = "nome é obrigatório")
	@NotBlank(message = "nome é obrigatório")
	@Column(name = "nome") 
	private String nome; 

	@NotNull(message = "detalhesTarefa é obrigatório")
	@NotBlank(message = "detalhesTarefa é obrigatório")
	@Column(name = "detalhesTarefalimite") 
	private String detalhesTarefaLimiteExecucao; 
	
	@NotNull(message = "detalhes é obrigatório")
	@NotBlank(message = "detalhes é obrigatório")
	@Column(name = "detalhes") 
	private String detalhesTarefa;
	
	@NotNull(message = "status é obrigatório")
	@NotBlank(message = "status é obrigatório")
	@Column(name = "status") 
	private String statusTarefa;
	

	public Long getId() { 
		return id; 
	} 

	public void setId(Long id) { 
		this.id = id; 
	} 

	public String getNome() { 
		return nome; 
	} 

	public void setNome(String nome) { 
		this.nome = nome; 
	} 

	public String getdetalhesTarefaLimiteExecucao() { 
		return detalhesTarefaLimiteExecucao; 
	}

	public void setdetalhesTarefaLimiteExecucao(String detalhesTarefaLimiteExecucao) { 
		this.detalhesTarefaLimiteExecucao = detalhesTarefaLimiteExecucao; 
	} 

	public String getdetalhesTarefa() { 
		return detalhesTarefa; 
	} 

	public void setdetalhesTarefa(String detalhesTarefa) { 
		this.detalhesTarefa = detalhesTarefa; 
	} 
	
	public String getstatusTarefa() { 
		return statusTarefa; 
	} 

	public void setstatusTarefa(String statusTarefa) { 
		this.statusTarefa = statusTarefa; 
	} 

}
