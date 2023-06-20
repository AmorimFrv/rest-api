package com.restapi.restapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restapi.restapi.model.Entrada;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long> {
	@Query(value = "select sum(valor) from entrada",nativeQuery = true)
	Long somarValores();
	
}
