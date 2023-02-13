package com.universales.practica3.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.universales.practica3.dto.CompaniasSegurosDTO;
import com.universales.practica3.entity.CompaniasSeguros;
import com.universales.practica3.repository.CompaniasRepository;
import com.universales.practica3.repository.CompaniasSegurosRepository;
import com.universales.practica3.repository.SegurosRepository;
import com.universales.practica3.wsint.CompaniasSegurosInt;

@Component
public class CompaniasSegurosImpl implements CompaniasSegurosInt {
	
	@Autowired
	CompaniasSegurosRepository companiassegurosRepository;
	
	@Autowired
	CompaniasRepository companiasRepository;
	
	@Autowired
	SegurosRepository segurosRepository;

	@Override
	public List<CompaniasSeguros> buscar() {
		return companiassegurosRepository.findAll();
	}

	@Override
	public CompaniasSeguros guardar(CompaniasSegurosDTO companiaseguros) {
		CompaniasSeguros c=new CompaniasSeguros();
		c.setId(companiaseguros.getId());
		c.setCompania(companiaseguros.getCompania());
		c.setSeguro(companiaseguros.getSeguro());
		return companiassegurosRepository.save(c);
	}

	@Override
	public void eliminar(Integer id) {
	Optional <CompaniasSeguros> companiasseguros= companiassegurosRepository.findById(id);
	if(companiasseguros.isPresent()) {
		companiassegurosRepository.delete(companiasseguros.get());
		
	}

	}

}
