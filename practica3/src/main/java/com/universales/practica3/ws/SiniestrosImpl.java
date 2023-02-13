package com.universales.practica3.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.universales.practica3.dto.SiniestrosDTO;
import com.universales.practica3.entity.Siniestros;
import com.universales.practica3.repository.SiniestrosRepository;
import com.universales.practica3.wsint.SiniestrosInt;

@Component
public class SiniestrosImpl implements SiniestrosInt {

	@Autowired
	SiniestrosRepository siniestrosRepository;

	@Override
	public List<Siniestros> buscar() {
		return siniestrosRepository.findAll();
	}

	@Override
	public Siniestros guardar(SiniestrosDTO siniestros) {
		Siniestros s = new Siniestros();
		s.setDpiPerito(siniestros.getDpiPerito());
		s.setIdSiniestro(siniestros.getIdSiniestro());
		s.setFechaSiniestro(siniestros.getFechaSiniestro());
		s.setCausas(siniestros.getCausas());
		s.setAceptado(siniestros.getAceptado());
		s.setIndemnizacion(siniestros.getIndemnizacion());
		s.setSeguros(siniestros.getSeguros());
		return siniestrosRepository.save(s);
	}

	@Override
	public void eliminar(Integer idSiniestro) {
		Optional <Siniestros> siniestros = siniestrosRepository.findByidSiniestro(idSiniestro);
		if (siniestros.isPresent()) {
			siniestrosRepository.delete(siniestros.get());
		}

	}
	
	@Override
	public List<Siniestros> getSiniestro(int page, int size){
		Pageable pageable = PageRequest.of(page, size);
		Page<Siniestros> siniestros= siniestrosRepository.findAll(pageable);
		return siniestros.stream().map(siniestro -> {
			Siniestros dto= new Siniestros();
			dto.setAceptado(siniestro.getAceptado());
			dto.setCausas(siniestro.getCausas());
			dto.setDpiPerito(siniestro.getDpiPerito());
			dto.setFechaSiniestro(siniestro.getFechaSiniestro());
			dto.setIdSiniestro(siniestro.getIdSiniestro());
			dto.setIndemnizacion(siniestro.getIndemnizacion());
			dto.setSeguros(siniestro.getSeguros());
			return dto;
		}).toList();
	}
	
}
