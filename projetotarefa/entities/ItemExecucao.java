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
@Table(name = "ItemExecucao") 
public class ItemExecucao { 
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@NotNull(message = "percentual é obrigatório")
	@NotBlank(message = "percentual é obrigatório")
	@Column(name = "percentual") 
	private Double percentual; 
	
	@NotNull(message = "descricao é obrigatório")
	@NotBlank(message = "descricao é obrigatório")
	@Column(name = "descricao") 
	private String descricao; 

	@NotNull(message = "dataExecucao é obrigatório")
	@NotBlank(message = "dataExecucao é obrigatório")
	@Column(name = "dataExecucao") 
	private String dataExecucao; 

	public double getPercentual() { 
		return percentual; 
	} 

	public void setPercentual(Double percentual) { 
		this.percentual = percentual; 
	} 

	public String getDescricao() { 
		return descricao; 
	} 

	public void setDescricao(String descricao) { 
		this.descricao = descricao; 
	} 

	public String getDataExecucao() { 
		return dataExecucao; 
	}

	public void setDataExecucao(String dataExecucao) { 
		this.dataExecucao = dataExecucao; 
	} 

}