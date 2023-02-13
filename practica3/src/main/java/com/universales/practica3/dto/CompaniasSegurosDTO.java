package com.universales.practica3.dto;

import java.io.Serializable;

import com.universales.practica3.entity.Companias;
import com.universales.practica3.entity.Seguros;

public class CompaniasSegurosDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Companias compania;
	private Seguros seguro;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Companias getCompania() {
		return compania;
	}
	public void setCompania(Companias compania) {
		this.compania = compania;
	}
	public Seguros getSeguro() {
		return seguro;
	}
	public void setSeguro(Seguros seguro) {
		this.seguro = seguro;
	}
	
	
}
