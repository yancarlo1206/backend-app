package com.tksis.backendapp.models.entities;

import java.io.Serializable;

public class User implements Serializable{
	
	private String usuario;
	private String clave;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}	
	
}
