package com.restapi.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.restapi.model.UsuarioLog;

@Repository
public interface UsuarioLogRepository extends JpaRepository<UsuarioLog, Long> {

}
