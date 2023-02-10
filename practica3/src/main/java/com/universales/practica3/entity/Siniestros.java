package com.universales.practica3.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "SINIESTROS")
public class Siniestros implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GenericGenerator(name = "ID_SINIESTRO", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "test_seq1"), @Parameter(name = "initial_value", value = "1"),
			@Parameter(name = "increment_size", value = "1"), @Parameter(name = "schema", value = "SEGUNI") })
	@Id
	@Basic(optional = false)
	@Column(name = "ID_SINIESTRO")
	@GeneratedValue(generator = "ID_SINIESTRO")
	private Integer idSiniestro;

	@Column(name = "FECHA_SINIESTRO")
	private Date fechaSiniestro;

	@Column(name = "CAUSAS")
	private String causas;

	@Column(name = "ACEPTADO")
	private String aceptado;

	@Column(name = "INDEMNIZACION")
	private Integer indemnizacion;
	

	@Column(name = "DPI_PERITO")
	private Long dpiPerito;

	@ManyToOne
	@JoinColumn(name = "NUMERO_POLIZA")
	Seguros seguros;

	public Integer getIndemnizacion() {
		return indemnizacion;
	}

	public void setIndemnizacion(Integer indemnizacion) {
		this.indemnizacion = indemnizacion;
	}

	public Seguros getSeguros() {
		return seguros;
	}

	public void setSeguros(Seguros seguros) {
		this.seguros = seguros;
	}

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

	public Long getDpiPerito() {
		return dpiPerito;
	}

	public void setDpiPerito(Long dpiPerito) {
		this.dpiPerito = dpiPerito;
	}

}
