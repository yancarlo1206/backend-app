package com.tksis.backendapp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import com.tksis.backendapp.models.entities.Usuario;
import com.tksis.backendapp.models.service.IRolService;
import com.tksis.backendapp.models.service.IUsuarioService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping({"/usuario","/"})
public class UsuarioRestController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IRolService rolService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping({"/saludar"})
	public String saludar(){
		return "Hola";
	}
	
	@GetMapping("")
	public List<Usuario> index(){
		return usuarioService.findAll();
	}
	
	@GetMapping("/{id}")
	public Usuario show(@PathVariable String id) {
		return this.usuarioService.findById(id);
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario usuario) {
		usuario.setClave(passwordEncoder.encode(usuario.getClave()));
		this.usuarioService.save(usuario);
		return usuario;
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario usuario, @PathVariable String id) {
		Usuario currentUsuario = this.usuarioService.findById(id);
		currentUsuario.setNombre(usuario.getNombre());
		currentUsuario.setEmail(usuario.getEmail());
		currentUsuario.setClave(usuario.getClave());
		this.usuarioService.save(currentUsuario);
		return currentUsuario;
	}
	
	@PutMapping("/roles/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody List<Rol> rol, @PathVariable String id) {
		Usuario currentUsuario = this.usuarioService.findById(id);
		
		currentUsuario.getRols().clear();
		this.usuarioService.save(currentUsuario);
		
		for(int i = 0; i<rol.size(); i++) {
			Rol r = this.rolService.findById(rol.get(i).getId());
			currentUsuario.getRols().add(r);
			
		}
		
		/*
		currentUsuario.setNombre(usuario.getNombre());
		currentUsuario.setEmail(usuario.getEmail());
		currentUsuario.setClave(usuario.getClave());
		*/
		
		this.usuarioService.save(currentUsuario);
		return currentUsuario;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		Usuario currentUsuario = this.usuarioService.findById(id);
		this.usuarioService.delete(currentUsuario);
	}
	
}
