package com.example.demo.modelo;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
@Access(AccessType.FIELD)
public class Usuarios extends ParentEntity{

	private static final long serialVersionUID = 4147435607093020041L;
	
	
	@Column(name="name",nullable=false,length=10)
	private String name;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
	
}
