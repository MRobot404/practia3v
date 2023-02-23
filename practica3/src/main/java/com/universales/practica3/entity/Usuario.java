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
@Table(name = "USUARIO")
@Data
public class Usuario implements Serializable {

	private static final long serialVersionUID = 3879288915592808874L;
	@GenericGenerator(name = "ID_USUARIO", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "test_seq"), @Parameter(name = "initial_value", value = "1"),
			@Parameter(name = "increment_size", value = "1"), @Parameter(name = "schema", value = "SEGUNI") })
	@Id
	@Basic(optional = false)
	@Column(name = "ID_USUARIO")
	@GeneratedValue(generator = "ID_USUARIO")
	private Integer idUsuario;

	@Column(name = "USUARIO")
	private String user;

	@Column(name = "CONTRASENA")
	private String contrasena;
	
}
