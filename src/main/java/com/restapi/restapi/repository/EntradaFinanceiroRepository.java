package com.restapi.restapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.restapi.model.EntradaFinanceiro;

@Repository
public interface EntradaFinanceiroRepository extends JpaRepository<EntradaFinanceiro, Long> {
	/*@Query(value = "select sum(valor) from entrada",nativeQuery = true)
	Long somarValores();*/
	
}
