package com.universales.practica3.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universales.practica3.entity.Companias;

@Repository("companiasRepository")
public interface CompaniasRepository  extends JpaRepository<Companias, Serializable> {
	public Optional<Companias> findByNombreCompania(String nombreCompania);
	List<Companias> findByCodPostalContainingIgnoreCase(String codPostal);
	List<Companias> findByNumeroViaEndingWith(String numeroVia);
	List<Companias> findByNotasIsNull();
}
