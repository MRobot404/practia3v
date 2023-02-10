package com.universales.practica3.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.universales.practica3.wsint.UsuarioInt;
import com.universales.practica3.dto.UsuarioDTO;
import com.universales.practica3.entity.Usuario;
import com.universales.practica3.repository.UsuarioRepository;

@Component
public class UsuarioImpl implements UsuarioInt {

	@Autowired
	UsuarioRepository usuarioRepository;

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
}
