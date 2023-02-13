package com.universales.practica3.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "SEGUROS")
public class Seguros implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "NUMERO_POLIZA")
	private Long numeroPoliza;
	
	@Column(name="RAMO")
	private String ramo;
	
	@Column(name="FECHA_INICIO")
	private Date fechaInicio;
	
	@Column(name="FECHA_VENCIMIENTO")
	private Date fechaVencimiento;
	
	@Column(name="CONDICIONES_PARTICULARES")
	private String condicionesParticulares;
	
	@Column(name="OBSERVACIONES")
	private String observaciones;
	
	@Column(name="DPI_CLIENTE")
	private Long dpiCliente;
	
	@ManyToMany
	@JoinTable(
			name="COMPANIAS_SEGUROS",
			joinColumns = @JoinColumn(name="NUMERO_POLIZA"),
			inverseJoinColumns = @JoinColumn(name="NOMBRE_COMPANIA"))
	@JsonManagedReference
			private List<Companias> companiaSeguros=new ArrayList<>();
	
	

	public Long getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(Long numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getCondicionesParticulares() {
		return condicionesParticulares;
	}

	public void setCondicionesParticulares(String condicionesParticulares) {
		this.condicionesParticulares = condicionesParticulares;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Long getDpiCliente() {
		return dpiCliente;
	}

	public void setDpiCliente(Long dpiCliente) {
		this.dpiCliente = dpiCliente;
	}

	public List<Companias> getCompaniaSeguros() {
		return companiaSeguros;
	}

	public void setCompaniaSeguros(List<Companias> companiaSeguros) {
		this.companiaSeguros = companiaSeguros;
	}

	

	
	
	
}
