package com.universales.practica3.dto;



import lombok.Data;

@Data
public class UsuarioDTO  {


	private Integer idUsuario;
	private String user;
	private String contrasena;
	private Object token;


	
}
