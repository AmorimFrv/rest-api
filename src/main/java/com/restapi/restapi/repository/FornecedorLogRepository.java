package com.restapi.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.restapi.model.FornecedorLog;

@Repository
public interface FornecedorLogRepository extends JpaRepository<FornecedorLog, Long> {

}