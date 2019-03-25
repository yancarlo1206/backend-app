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

import com.tksis.backendapp.models.entities.Rol;
import com.tksis.backendapp.models.service.IRolService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping({"/rol","/"})
public class RolRestController {
	
	@Autowired
	private IRolService rolService;
	
	@GetMapping("")
	public List<Rol> index(){
		return rolService.findAll();
	}
	
	@GetMapping("/{id}")
	public Rol show(@PathVariable Integer id) {
		return this.rolService.findById(id);
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Rol create(@RequestBody Rol rol) {
		this.rolService.save(rol);
		return rol;
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Rol update(@RequestBody Rol rol, @PathVariable Integer id) {
		Rol currentRol = this.rolService.findById(id);
		currentRol.setDescripcion(rol.getDescripcion());
		this.rolService.save(currentRol);
		return currentRol;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		Rol currentRol = this.rolService.findById(id);
		this.rolService.delete(currentRol);
	}
	
}