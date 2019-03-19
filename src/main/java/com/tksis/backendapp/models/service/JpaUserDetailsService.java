package com.tksis.backendapp.models.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tksis.backendapp.models.dao.IUsuarioDao;
import com.tksis.backendapp.models.entities.Rol;
import com.tksis.backendapp.models.entities.Usuario;

@Service ("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	
	private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);
	
	@Override
	@Transactional (readOnly = true)
	public UserDetails loadUserByUsername(String usuarioNombre) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.findByUsuario(usuarioNombre);
		
		if (usuario == null) {
			logger.error("Error Login: no existe el usuario " + usuarioNombre);
			throw new UsernameNotFoundException("Usuario no existe en el sistema");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(); 
		
		for(Rol rol: usuario.getRols()) {
			authorities.add(new SimpleGrantedAuthority(rol.getDescripcion()));
		}
		
		if (authorities.isEmpty()) {
			logger.error("Error Login: usuario no tiene roles");
			throw new UsernameNotFoundException("Usuario no tiene roles");
		}
		
		return new User(usuario.getUsuario(), usuario.getClave(), true, true, true, true, authorities);
	}

}
