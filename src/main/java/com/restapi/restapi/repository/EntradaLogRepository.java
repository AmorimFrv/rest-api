package com.restapi.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.restapi.model.EntradaLog;

@Repository
public interface EntradaLogRepository extends JpaRepository<EntradaLog, Long> {

}
