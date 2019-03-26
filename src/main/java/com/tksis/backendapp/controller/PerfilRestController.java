package com.tksis.backendapp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tksis.backendapp.models.entities.Perfil;
import com.tksis.backendapp.models.service.IPerfilService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping({"/perfil","/"})
public class PerfilRestController {
	
	@Autowired
	private IPerfilService perfilService;
	
	@GetMapping("")
	public List<Perfil> index(){
		return perfilService.findAll();
	}
	
	@GetMapping("/{id}")
	public Perfil show(@PathVariable Integer id) {
		return this.perfilService.findById(id);
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Perfil create(@RequestBody Perfil perfil) {
		this.perfilService.save(perfil);
		return perfil;
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Perfil update(@RequestBody Perfil perfil, @PathVariable Integer id) {
		Perfil currentPerfil = this.perfilService.findById(id);
		currentPerfil.setDescripcion(perfil.getDescripcion());
		this.perfilService.save(currentPerfil);
		return currentPerfil;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		Perfil currentPerfil = this.perfilService.findById(id);
		this.perfilService.delete(currentPerfil);
	}
	
}