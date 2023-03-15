package com.universales.libreria;

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
import lombok.Data;

@Entity
@Table(name = "SINIESTROS")
@Data
public class Siniestros implements Serializable {

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
	private Seguros seguro;

}

