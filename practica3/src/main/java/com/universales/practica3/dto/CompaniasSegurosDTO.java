package com.universales.practica3.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CompaniasSegurosDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String compania;
	private Long numeroPoliza;
	
}
