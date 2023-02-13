package com.universales.practica3.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universales.practica3.entity.Usuario;

@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable>{
	public List<Usuario> findByidUsuario(int idUsuario);
	public Usuario findByUserAndContrasena(String user,String contrasena);
}
