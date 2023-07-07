package com.restapi.restapi.model;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	private String especificacao1;
	
	private String especificacao2;
	
	private Long valorEntrada;
	
	private Long valorSaida;
	
	private int quantidade;
	
	private String nomeCategoria;
	
	private String nomeFornecedor;

	public Long getValorEntrada() {
		return valorEntrada;
	}

	public void setValorEntrada(Long valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

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

	public String getEspecificacao1() {
		return especificacao1;
	}

	public void setEspecificacao1(String especificacao1) {
		this.especificacao1 = especificacao1;
	}

	public String getEspecificacao2() {
		return especificacao2;
	}

	public void setEspecificacao2(String especificacao2) {
		this.especificacao2 = especificacao2;
	}
	
	public Long getValorSaida() {
		return valorSaida;
	}

	public void setValorSaida(Long valorSaida) {
		this.valorSaida = valorSaida;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}



	
	}
	
	
