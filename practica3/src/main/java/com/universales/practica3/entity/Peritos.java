package com.universales.practica3.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Peritos")
@Data
public class Peritos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DPI_PERITO")
	private Long dpiPerito;

	@Column(name = "NOMBRE_PERITO")
	private String nombrePerito;

	@Column(name = "APELLIDO_PERITO1")
	private String apellidoPerito1;

	@Column(name = "APELLIDO_PERITO2")
	private String apellidoPerito2;

	@Column(name = "TELEFONO_CONTACTO")
	private String telefonoContacto;

	@Column(name = "TELEFONO_OFICINA")
	private String telefonoOficina;

	@Column(name = "CLASE_VIA")
	private String claseVia;

	@Column(name = "NOMBRE_VIA")
	private String nombreVia;

	@Column(name = "NUMERO_VIA")
	private String numerovia;

	@Column(name = "COD_POSTAL")
	private String codPostal;

	@Column(name = "CIUDAD")
	private String ciudad;
	
	@OneToMany(mappedBy = "dpiPerito")
	private List<Siniestros> siniestros;

}
