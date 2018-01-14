package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Usuarios;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long>{
	@SuppressWarnings("unchecked")
	Usuarios save(Usuarios user);
}
