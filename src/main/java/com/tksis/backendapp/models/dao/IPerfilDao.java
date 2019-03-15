package com.tksis.backendapp.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.tksis.backendapp.models.entities.Perfil;

public interface IPerfilDao extends CrudRepository<Perfil, Integer> { 

}