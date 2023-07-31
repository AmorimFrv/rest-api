package com.restapi.restapi.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProdutoLog {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long id_Produto;
	
	private String operacao;
	
	private String dataAtualizacao;
	
	private String nome;
	
	public void setId_Produto(Long id_Produto) {
		this.id_Produto = id_Produto;
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
	