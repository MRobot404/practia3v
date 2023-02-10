package com.universales.practica3.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
}
