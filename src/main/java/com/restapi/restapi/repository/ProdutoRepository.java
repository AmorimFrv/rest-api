package com.restapi.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.restapi.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
