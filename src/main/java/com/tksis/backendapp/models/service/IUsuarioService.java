package com.tksis.backendapp.models.service;

import java.util.List;
import com.tksis.backendapp.models.entities.Usuario;

public interface IUsuarioService {

	public List<Usuario> findAll();

	public void save(Usuario usuario);

	public Usuario findById(String id);

	public void delete(Usuario usuario);

}
