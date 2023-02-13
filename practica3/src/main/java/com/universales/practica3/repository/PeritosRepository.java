package com.universales.practica3.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universales.practica3.entity.Peritos;
@Repository("peritosRepository")
public interface PeritosRepository extends JpaRepository<Peritos, Serializable> {
	Optional<Peritos> findBydpiPerito(Long dpiPerito);
}
