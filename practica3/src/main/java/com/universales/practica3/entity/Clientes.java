package com.universales.practica3.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "CLIENTES")
@Data
public class Clientes implements Serializable {

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
	
	@OneToMany(mappedBy = "dpiCliente", fetch=FetchType.LAZY)
	private List<Seguros> seguroslist;

}
