package com.universales.practica3.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.universales.practica3.dto.SegurosDTO;
import com.universales.practica3.entity.Seguros;
import com.universales.practica3.repository.CompaniasRepository;
import com.universales.practica3.repository.SegurosRepository;
import com.universales.practica3.wsint.SegurosInt;

@Component
public class SegurosImpl implements SegurosInt{

	@Autowired
	SegurosRepository segurosRepository;
	
	@Autowired
	CompaniasRepository companiasRepository;
	
	
	@Override
	public List<Seguros> buscar(){
		return segurosRepository.findAll();
	}
	
	@Override
	public Seguros guardar(SegurosDTO seguros) {
		Seguros s=new Seguros();
		s.setDpiCliente(seguros.getDpiCliente());
		s.setNumeroPoliza(seguros.getNumeroPoliza());
		s.setFechaInicio(seguros.getFechaInicio());
		s.setFechaVencimiento(seguros.getFechaVencimiento());
		s.setCondicionesParticulares(seguros.getCondicionesParticulares());
		s.setObservaciones(seguros.getObservaciones());
		return segurosRepository.save(s);
		
	}
	
	@Override
	public void eliminar(Long numeroPoliza) {
		Optional<Seguros> seguros = segurosRepository.findBynumeroPoliza(numeroPoliza);
		if(seguros.isPresent()) {
			segurosRepository.delete(seguros.get());
		}
	}
}
