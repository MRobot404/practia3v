package com.universales.practica3.wsint;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.universales.practica3.entity.Usuario;

@RestController
@RequestMapping("/noauth/usuarios")
@CrossOrigin
public interface UsuarioInt {
	@GetMapping("/buscar")
	List<Usuario> buscarUsuario();

}
