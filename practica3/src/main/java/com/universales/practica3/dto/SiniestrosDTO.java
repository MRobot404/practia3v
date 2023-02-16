package com.universales.practica3.dto;

import java.util.Date;



public class SiniestrosDTO {

	/**
	 * 
	 */
	private Integer idSiniestro;
	private Date fechaSiniestro;
	private String causas;
	private String aceptado;
	private Integer indemnizacion;
	private Long dpiPerito;
	private Long seguro;
	public Integer getIdSiniestro() {
		return idSiniestro;
	}
	public void setIdSiniestro(Integer idSiniestro) {
		this.idSiniestro = idSiniestro;
	}
	public Date getFechaSiniestro() {
		return fechaSiniestro;
	}
	public void setFechaSiniestro(Date fechaSiniestro) {
		this.fechaSiniestro = fechaSiniestro;
	}
	public String getCausas() {
		return causas;
	}
	public void setCausas(String causas) {
		this.causas = causas;
	}
	public String getAceptado() {
		return aceptado;
	}
	public void setAceptado(String aceptado) {
		this.aceptado = aceptado;
	}
	public Integer getIndemnizacion() {
		return indemnizacion;
	}
	public void setIndemnizacion(Integer indemnizacion) {
		this.indemnizacion = indemnizacion;
	}
	public Long getDpiPerito() {
		return dpiPerito;
	}
	public void setDpiPerito(Long dpiPerito) {
		this.dpiPerito = dpiPerito;
	}
	public Long getSeguro() {
		return seguro;
	}
	public void setSeguro(long seguro) {
		this.seguro = seguro;
	}

	
	
	
	
}
