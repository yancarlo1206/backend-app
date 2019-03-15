package com.tksis.backendapp.models.service;

import java.util.List;
import com.tksis.backendapp.models.entities.Perfil;

public interface IPerfilService {

	public List<Perfil> findAll();

	public void save(Perfil perfil);

	public Perfil findById(Integer id);

	public void delete(Perfil perfil);

}
