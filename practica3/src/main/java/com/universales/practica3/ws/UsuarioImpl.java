package com.universales.practica3.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.universales.practica3.wsint.UsuarioInt;
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
}
