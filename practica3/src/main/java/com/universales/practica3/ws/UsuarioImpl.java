package com.universales.practica3.ws;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.universales.practica3.wsint.UsuarioInt;
import com.universales.practica3.dto.UsuarioDTO;
import com.universales.practica3.entity.Usuario;
import com.universales.practica3.repository.UsuarioRepository;
import com.universales.practica3.security.JwtGeneratorInterface;

@Component
public class UsuarioImpl implements UsuarioInt {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	JwtGeneratorInterface jwtGenerator;

	@Override
	public List<Usuario> buscarUsuario() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario guardar(UsuarioDTO usuario) {
		Usuario u = new Usuario();
		u.setIdUsuario(usuario.getIdUsuario());
		u.setUser(usuario.getUser());
		u.setContrasena(usuario.getContrasena());
		return usuarioRepository.save(u);
	}

	@Override
	public void eliminar(Integer idUsuario) {
		Optional<Usuario> usuarios = usuarioRepository.findById(idUsuario);
		if (usuarios.isPresent()) {
			usuarioRepository.delete(usuarios.get());
		}
	}

	@Override
	public List<Usuario> buscarPorIdUsuario(Integer idUsuario) {
		return usuarioRepository.findByidUsuario(idUsuario);
	}
	
	@Override
	public ResponseEntity<Object> loginUser(@RequestBody Usuario usuario) {
		try {
			if (usuario.getUser() == null || usuario.getContrasena() == null) {
				throw new UserPrincipalNotFoundException("Usuario o contraseña vacio");
			}
			Usuario userData = getUsuarioByUsuarioAndContrasena(usuario.getUser(), usuario.getContrasena());
			if (userData == null) {
				throw new UserPrincipalNotFoundException("Usuario o contraseña incorrectos");
			}
			return new ResponseEntity<>( jwtGenerator.generateToken(usuario), HttpStatus.OK);
		} catch (UserPrincipalNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	@Override
	public Usuario getUsuarioByUsuarioAndContrasena(String usuario,String contrasena) throws UserPrincipalNotFoundException {
	Usuario user= usuarioRepository.findByUserAndContrasena(usuario, contrasena);
	if(user==null) {
		throw new UserPrincipalNotFoundException("Usuario o password invalido");
	}
	return user;
		
		
	}
}
