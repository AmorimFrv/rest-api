package com.restapi.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.restapi.model.ProdutoLog;

@Repository
public interface ProdutoLogRepository extends JpaRepository<ProdutoLog, Long> {

}
