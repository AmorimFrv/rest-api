package com.restapi.restapi.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CategoriaLog {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long id_Categoria;
	
	private String operacao;
	
	private String dataAtualizacao;
	
	private String nome;
	
	public void setId_Categoria(Long id_Categoria) {
		this.id_Categoria = id_Categoria;
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
	