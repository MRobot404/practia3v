package com.universales.practica3.wsint;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.universales.practica3.dto.UsuarioDTO;
import com.universales.practica3.entity.Usuario;

@RestController
@RequestMapping("/noauth/usuarios")
@CrossOrigin
public interface UsuarioInt {
	@GetMapping("/buscar")
	List<Usuario> buscarUsuario();

	@PostMapping("/guardar")
	Usuario guardar(@RequestBody UsuarioDTO usuario);

	@DeleteMapping(path = "/eliminar/{idUsuario}")
	void eliminar(@PathVariable("idUsuario") Integer idUsuario);

	@GetMapping("/buscar/por/{idUsuario}")
	List<Usuario> buscarPorIdUsuario(@PathVariable("idUsuario") Integer idUsuario);

	Usuario getUsuarioByUsuarioAndContrasena(String usuario, String contrasena) throws UserPrincipalNotFoundException;
	
	@PostMapping("/login")
	ResponseEntity<Object> loginUser(Usuario usuario);

}
