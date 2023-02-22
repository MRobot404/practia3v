package com.universales.practica3.entity;

import java.io.Serializable;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "COMPANIAS_SEGUROS")
@Data
public class CompaniasSeguros implements Serializable {

	private static final long serialVersionUID = 1L;
	@GenericGenerator(name = "ID", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "test_seq3"), @Parameter(name = "initial_value", value = "1"),
			@Parameter(name = "increment_size", value = "1"), @Parameter(name = "schema", value = "SEGUNI") })
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	@GeneratedValue(generator = "ID")
	private Integer id;

	@Column(name = "NOMBRE_COMPANIA")
	private String compania;

	@Column(name = "NUMERO_POLIZA")
	private Long numeroPoliza;

}
