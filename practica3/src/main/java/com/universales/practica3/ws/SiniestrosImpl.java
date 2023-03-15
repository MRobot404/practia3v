package com.universales.practica3.ws;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.universales.practica3.dto.SiniestrosDTO;
import com.universales.libreria.Seguros;
import com.universales.libreria.Siniestros;
import com.universales.practica3.repository.SegurosRepository;
import com.universales.practica3.repository.SiniestrosRepository;
import com.universales.practica3.wsint.SiniestrosInt;

@Component
public class SiniestrosImpl implements SiniestrosInt {

	@Autowired
	SiniestrosRepository siniestrosRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	SegurosRepository segurosRepository;

	/**
	 * Método para buscar todos los siniestros.
	 *
	 * @return Lista de siniestros.
	 */

	@Override
	public List<Siniestros> buscar() {
		return siniestrosRepository.findAll();
	}

	/**
	 * Método para guardar un siniestro.
	 *
	 * @param siniestros DTO del siniestro a guardar.
	 * @return El siniestro guardado.
	 */

	@Override
	public Siniestros guardar(SiniestrosDTO siniestros) {
		Siniestros siniestro = modelMapper.map(siniestros, Siniestros.class);
		Optional<Seguros> temporal = segurosRepository.findById(siniestros.getSeguro());

		if (temporal.isPresent()) {
			siniestro.setSeguro(temporal.get());
			return siniestrosRepository.save(siniestro);
		}

		return null;
	}

	/**
	 * Método para eliminar un siniestro.
	 *
	 * @param idSiniestro ID del siniestro a eliminar.
	 */

	@Override
	public void eliminar(Integer idSiniestro) {
		Optional<Siniestros> siniestros = siniestrosRepository.findByidSiniestro(idSiniestro);
		if (siniestros.isPresent()) {
			siniestrosRepository.delete(siniestros.get());
		}

	}

	/**
	 * Método para obtener los siniestros de forma paginada.
	 *
	 * @param page Página a obtener.
	 * @param size Cantidad de elementos por página.
	 * @return Lista de siniestros obtenida.
	 */

	@Override
	public List<Siniestros> getSiniestro(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Siniestros> siniestros = siniestrosRepository.findAll(pageable);
		return siniestros.stream().map(siniestro -> {
			Siniestros dto = new Siniestros();
			dto.setAceptado(siniestro.getAceptado());
			dto.setCausas(siniestro.getCausas());
			dto.setDpiPerito(siniestro.getDpiPerito());
			dto.setFechaSiniestro(siniestro.getFechaSiniestro());
			dto.setIdSiniestro(siniestro.getIdSiniestro());
			dto.setIndemnizacion(siniestro.getIndemnizacion());
			return dto;
		}).toList();
	}

}
