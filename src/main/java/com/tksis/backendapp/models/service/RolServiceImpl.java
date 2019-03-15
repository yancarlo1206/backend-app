package com.tksis.backendapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tksis.backendapp.models.dao.IRolDao;
import com.tksis.backendapp.models.entities.Rol;
import com.tksis.backendapp.models.service.IRolService;

@Service
public class RolServiceImpl implements IRolService {

	@Autowired
	private IRolDao rolDao;

	@Override
	@Transactional(readOnly = true)
	public List<Rol> findAll() {
		return (List<Rol>) rolDao.findAll();
	}

	@Override
	@Transactional
	public void save(Rol rol) {
		rolDao.save(rol);
	}

	@Override
	@Transactional(readOnly = true)
	public Rol findById(Integer id) {
		return rolDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Rol rol) {
		rolDao.delete(rol);

	}

}