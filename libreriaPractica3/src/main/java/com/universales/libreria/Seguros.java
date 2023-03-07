package com.universales.libreria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "SEGUROS")
@Data
public class Seguros implements Serializable {

	private static final long serialVersionUID = 1L;
	@GenericGenerator(name = "NUMERO_POLIZA", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "test_seq2"), @Parameter(name = "initial_value", value = "1"),
			@Parameter(name = "increment_size", value = "1"), @Parameter(name = "schema", value = "SEGUNI") })
	@Id
	@Basic(optional = false)
	@Column(name = "NUMERO_POLIZA")
	@GeneratedValue(generator = "NUMERO_POLIZA")
	private Long numeroPoliza;

	@Column(name = "RAMO")
	private String ramo;

	@Column(name = "FECHA_INICIO")
	private Date fechaInicio;

	@Column(name = "FECHA_VENCIMIENTO")
	private Date fechaVencimiento;

	@Column(name = "CONDICIONES_PARTICULARES")
	private String condicionesParticulares;

	@Column(name = "OBSERVACIONES")
	private String observaciones;

	@Column(name = "DPI_CLIENTE")
	private Long dpiCliente;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "COMPANIAS_SEGUROS", joinColumns = @JoinColumn(name = "NUMERO_POLIZA"), inverseJoinColumns = @JoinColumn(name = "NOMBRE_COMPANIA"))
	@JsonManagedReference
	private List<Companias> companiaSeguros = new ArrayList<>();

}
