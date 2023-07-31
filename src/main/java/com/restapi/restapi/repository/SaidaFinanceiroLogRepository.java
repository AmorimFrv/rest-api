package com.restapi.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.restapi.model.SaidaFinanceiroLog;

@Repository
public interface SaidaFinanceiroLogRepository extends JpaRepository<SaidaFinanceiroLog, Long> {

}
