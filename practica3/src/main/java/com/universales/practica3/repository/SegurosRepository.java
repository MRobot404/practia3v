package com.universales.practica3.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universales.libreria.Seguros;

@Repository("seguroRepository")
public interface SegurosRepository extends JpaRepository<Seguros, Serializable> {
	Optional<Seguros> findBynumeroPoliza(Long numeroPoliza);
	 List<Seguros> findByObservacionesIsNull();
	 List<Seguros> findByFechaInicioBefore(Date fechaInicio);
}
