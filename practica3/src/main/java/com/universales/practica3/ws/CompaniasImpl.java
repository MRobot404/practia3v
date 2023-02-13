package com.universales.practica3.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.universales.practica3.dto.CompaniasDTO;
import com.universales.practica3.entity.Companias;
import com.universales.practica3.repository.CompaniasRepository;
import com.universales.practica3.wsint.CompaniasInt;

@Component
public class CompaniasImpl implements CompaniasInt {

	
	@Autowired
	CompaniasRepository companiasRepository;
	
	@Override
	public List<Companias>buscar(){
		return companiasRepository.findAll();
	}
	
	@Override
	public Companias guardar(CompaniasDTO companias) {
		Companias c=new Companias();
		c.setNombreCompania(companias.getNombreCompania());
		c.setClaseVia(companias.getClaseVia());
		c.setNombreVia(companias.getNombreVia());
		c.setNumeroVia(companias.getNumeroVia());
		c.setCodPostal(companias.getCodPostal());
		c.setTelefonoContratacion(companias.getTelefonoContratacion());
		c.setTelefonoSiniestros(companias.getTelefonoSiniestros());
		return companiasRepository.save(c);
	}
	
	@Override
	public void eliminar(String nombreCompania) {
		Optional <Companias> companias=companiasRepository.findByNombreCompania(nombreCompania);
		if(companias.isPresent()) {
		companiasRepository.delete(companias.get());
		}
	}
}
