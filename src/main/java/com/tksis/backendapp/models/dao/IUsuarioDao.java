package com.tksis.backendapp.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.tksis.backendapp.models.entities.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, String> { 
	
	public Usuario findByUsuario(String usuarioNombre);

}