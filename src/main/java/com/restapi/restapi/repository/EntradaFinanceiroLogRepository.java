package com.restapi.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.restapi.model.EntradaFinanceiroLog;

@Repository
public interface EntradaFinanceiroLogRepository extends JpaRepository<EntradaFinanceiroLog, Long> {

}
