package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Usuarios;

public interface UsuarioService {

	Usuarios save(Usuarios user);

	List<Usuarios> findAll();

	void deleteUser(Long id);


}
