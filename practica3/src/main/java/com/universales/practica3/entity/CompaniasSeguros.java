package com.universales.practica3.entity;

import java.io.Serializable;

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
@Table(name = "COMPANIAS_SEGUROS")
public class CompaniasSeguros implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GenericGenerator(name = "ID", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "test_seq3"), @Parameter(name = "initial_value", value = "1"),
			@Parameter(name = "increment_size", value = "1"), @Parameter(name = "schema", value = "SEGUNI") })
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	@GeneratedValue(generator = "ID")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "NOMBRE_COMPANIA")
	private Companias compania;

	@ManyToOne
	@JoinColumn(name = "NUMERO_POLIZA")
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
