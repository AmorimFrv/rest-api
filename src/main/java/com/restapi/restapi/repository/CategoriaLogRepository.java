package com.restapi.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.restapi.model.CategoriaLog;

@Repository
public interface CategoriaLogRepository extends JpaRepository<CategoriaLog, Long> {

}
