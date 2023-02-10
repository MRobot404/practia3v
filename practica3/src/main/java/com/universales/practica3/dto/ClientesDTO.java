package com.universales.practica3.dto;

import java.io.Serializable;
import java.util.List;

import com.universales.practica3.entity.Seguros;

public class ClientesDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long dpiCliente;
	private String nombreCL;
	private String apellido1;
	private String apellido2;
	private String claseVia;
	private String nombreVia;
	private String numeroVia;
	private String codPostal;
	private String ciudad;
	private String telefono;
	private String observaciones;
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
