package com.universales.practica3.dto;

import java.io.Serializable;


public class CompaniasSegurosDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String compania;
	private Long numeroPoliza;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCompania() {
		return compania;
	}
	public void setCompania(String compania) {
		this.compania = compania;
	}
	public Long getNumeroPoliza() {
		return numeroPoliza;
	}
	public void setNumeroPoliza(Long numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}
	
	
	
}
