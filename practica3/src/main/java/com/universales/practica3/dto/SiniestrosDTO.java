package com.universales.practica3.dto;

import java.util.Date;

import lombok.Data;

@Data
public class SiniestrosDTO {

	private Integer idSiniestro;
	private Date fechaSiniestro;
	private String causas;
	private String aceptado;
	private Integer indemnizacion;
	private Long dpiPerito;
	private Long seguro;
	
}
