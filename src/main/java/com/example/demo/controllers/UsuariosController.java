package com.example.demo.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Usuarios;
import com.example.demo.service.UsuarioService;
import com.example.demo.util.QueryResult;
import com.example.demo.util.RestResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class UsuariosController {
	
	@Autowired
	protected UsuarioService usuarioService;
	
	protected ObjectMapper mapper;
	
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException {
		this.mapper = new ObjectMapper();
		Usuarios user = this.mapper.readValue(userJson, Usuarios.class);
		
		if(!this.validate(user)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),"faltan datos obligatorios");
		}
		
		this.usuarioService.save(user);
		
		return new RestResponse(HttpStatus.OK.value(),"Operacion Exitosa");
	}
	
	@RequestMapping(value="/getUsers", method=RequestMethod.GET)
	public List<Usuarios> getUsers() {
		return this.usuarioService.findAll();
	}
	
	@RequestMapping(value="deleteUser", method=RequestMethod.POST)
	public void deleteUser(@RequestBody String userJson) throws Exception {
		this.mapper = new ObjectMapper();
		
		Usuarios user = this.mapper.readValue(userJson, Usuarios.class);
		
		if(user.getId() == null) {
			throw new Exception("id es nulo");
		}
		
		this.usuarioService.deleteUser(user.getId());
	}
	
	private boolean validate(Usuarios user) {
		boolean isValid = true;
		
		if( StringUtils.trimToNull(user.getName()) == null) {
			isValid = false;
		}
		
		return isValid;
	}

}
