package com.restapi.restapi.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EntradaFinanceiroLog {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long id_EntradaFinanceiro;
	
	private String operacao;
	
	private String dataAtualizacao;
	
	private String nome;
	
	public void setId_EntradaFinanceiro(Long id_EntradaFinanceiro) {
		this.id_EntradaFinanceiro = id_EntradaFinanceiro;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public void setDataAtualizacao(String dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}



	}
	