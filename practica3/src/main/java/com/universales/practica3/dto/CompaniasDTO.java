package com.universales.practica3.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CompaniasDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombreCompania;
	private String claseVia;
	private String nombreVia;
	private String numeroVia;
	private String codPostal;
	private String telefonoContratacion;
	private String telefonoSiniestros;
	private String notas;
}
