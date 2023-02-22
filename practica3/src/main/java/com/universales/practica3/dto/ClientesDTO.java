package com.universales.practica3.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ClientesDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long dpiCliente;
	private String nombreCL;
	private String apellido1;
	private String apellido2;
	private String claseVia;
	private String nombreVia;
	private String numeroVia;
	private String codPostal;
	private String ciudad;
	private String telefono;
	private String observaciones;
}
