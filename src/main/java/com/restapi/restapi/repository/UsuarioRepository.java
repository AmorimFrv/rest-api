package com.restapi.restapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restapi.restapi.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

@Query(value = "select * from usuario where nome = :nome and senha = :senha",nativeQuery = true)
public Usuario Login(String nome, String senha);
	
}
