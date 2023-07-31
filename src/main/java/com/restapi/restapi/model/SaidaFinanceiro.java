package com.restapi.restapi.model;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SaidaFinanceiro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String data;
	
	private String especificacao1;

	private String especificacao2;
	
	private Long valor;
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	}
	
	
