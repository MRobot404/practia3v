package com.universales.practica3.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idUsuario;
	private String user;
	private String contrasena;

}
