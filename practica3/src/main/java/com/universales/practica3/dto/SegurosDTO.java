package com.universales.practica3.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;


@Data
public class SegurosDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long numeroPoliza;
	private String ramo;
	private Date fechaInicio;
	private Date fechaVencimiento;
	private String condicionesParticulares;
	private String observaciones;
	private Long dpiCliente;
	
}
