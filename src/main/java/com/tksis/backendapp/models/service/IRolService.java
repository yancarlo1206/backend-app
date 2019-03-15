package com.tksis.backendapp.models.service;

import java.util.List;
import com.tksis.backendapp.models.entities.Rol;

public interface IRolService {

	public List<Rol> findAll();

	public void save(Rol rol);

	public Rol findById(Integer id);

	public void delete(Rol rol);

}