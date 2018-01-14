package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UsuarioRepository;
import com.example.demo.modelo.Usuarios;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	
	@Autowired
	protected UsuarioRepository usuarioRepository;

	@Override
	public Usuarios save(Usuarios user) {
		return this.usuarioRepository.save(user);
	}

}
