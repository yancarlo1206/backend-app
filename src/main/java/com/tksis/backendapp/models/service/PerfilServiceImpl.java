package com.tksis.backendapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tksis.backendapp.models.dao.IPerfilDao;
import com.tksis.backendapp.models.entities.Perfil;
import com.tksis.backendapp.models.service.IPerfilService;

@Service
public class PerfilServiceImpl implements IPerfilService {

	@Autowired
	private IPerfilDao perfilDao;

	@Override
	@Transactional(readOnly = true)
	public List<Perfil> findAll() {
		return (List<Perfil>) perfilDao.findAll();
	}

	@Override
	@Transactional
	public void save(Perfil perfil) {
		perfilDao.save(perfil);
	}

	@Override
	@Transactional(readOnly = true)
	public Perfil findById(Integer id) {
		return perfilDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Perfil perfil) {
		perfilDao.delete(perfil);

	}

}