package com.universales.practica3.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTES")
public class Clientes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7847239783144337828L;

	@Id
	@Column(name = "DPI_CLIENTE")
	private Long dpiCliente;

	@Column(name = "NOMBRE_CL")
	private String nombreCL;

	@Column(name = "APELLIDO_1")
	private String apellido1;

	@Column(name = "APELLIDO_2")
	private String apellido2;

	@Column(name = "CLASE_VIA")
	private String claseVia;

	@Column(name = "NOMBRE_VIA")
	private String nombreVia;

	@Column(name = "NUMERO_VIA")
	private String numeroVia;

	@Column(name = "COD_POSTAL")
	private String codPostal;

	@Column(name = "CIUDAD")
	private String ciudad;

	@Column(name = "TELEFONO")
	private String telefono;

	@Column(name = "OBSERVACIONES")
	private String observaciones;

	@OneToMany(mappedBy = "dpiCliente")
	private List<Seguros> seguroslist;

	public Long getDpiCliente() {
		return dpiCliente;
	}

	public void setDpiCliente(Long dpiCliente) {
		this.dpiCliente = dpiCliente;
	}

	public String getNombreCL() {
		return nombreCL;
	}

	public void setNombreCL(String nombreCL) {
		this.nombreCL = nombreCL;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getClaseVia() {
		return claseVia;
	}

	public void setClaseVia(String claseVia) {
		this.claseVia = claseVia;
	}

	public String getNombreVia() {
		return nombreVia;
	}

	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}

	public String getNumeroVia() {
		return numeroVia;
	}

	public void setNumeroVia(String numeroVia) {
		this.numeroVia = numeroVia;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public List<Seguros> getSeguroslist() {
		return seguroslist;
	}

	public void setSeguroslist(List<Seguros> seguroslist) {
		this.seguroslist = seguroslist;
	}

}
