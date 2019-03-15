package com.tksis.backendapp.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.tksis.backendapp.models.entities.Rol;

public interface IRolDao extends CrudRepository<Rol, Integer> { 

}