package com.universales.practica3.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universales.practica3.entity.CompaniasSeguros;

@Repository("companiassegurosRepository")
public interface CompaniasSegurosRepository extends JpaRepository<CompaniasSeguros, Serializable> {
	 public Optional<CompaniasSeguros> findById(Integer id);
	    public List<CompaniasSeguros> findByCompania(String compania);
	    public Optional<CompaniasSeguros> findByNumeroPoliza(Long numeroPoliza);
	    public List<CompaniasSeguros> findByIdAndCompaniaAndNumeroPoliza(Integer id, String compania, Long numeroPoliza);
	    public void deleteByNumeroPoliza(Long numeroPoliza);
	    public void deleteByCompania(String compania);
}
