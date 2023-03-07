package com.universales.practica3.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universales.libreria.Siniestros;

@Repository("siniestrosRepository")
public interface SiniestrosRepository extends JpaRepository<Siniestros,Serializable> {
	
	Optional<Siniestros> findByidSiniestro(Integer idSiniestro);
}
