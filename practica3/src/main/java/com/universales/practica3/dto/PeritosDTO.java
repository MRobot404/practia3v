package com.universales.practica3.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PeritosDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long dpiPerito;
	private String nombrePerito;
	private String apellidoPerito1;
	private String apellidoPerito2;
	private String telefonoContacto;
	private String telefonoOficina;
	private String claseVia;
	private String nombreVia;
	private String numerovia;
	private String codPostal;
	private String ciudad;

}
