package com.universales.practica3.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "COMPANIAS")
@Data
public class Companias implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "NOMBRE_COMPANIA")
	private String nombreCompania;

	@Column(name = "CLASE_VIA")
	private String claseVia;

	@Column(name = "NOMBRE_VIA")
	private String nombreVia;

	@Column(name = "NUMERO_VIA")
	private String numeroVia;

	@Column(name = "COD_POSTAL")
	private String codPostal;

	@Column(name = "TELEFONO_CONTRATACION")
	private String telefonoContratacion;

	@Column(name = "TELEFONO_SINIESTROS")
	private String telefonoSiniestros;

	@Column(name = "NOTAS")
	private String notas;

	@ManyToMany(mappedBy = "companiaSeguros")
	@JsonBackReference
	private List<Seguros> segurosCompania = new ArrayList<>();

}
