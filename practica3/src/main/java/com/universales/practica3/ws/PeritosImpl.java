package com.universales.practica3.ws;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.universales.practica3.dto.PeritosDTO;
import com.universales.practica3.entity.Peritos;
import com.universales.practica3.repository.PeritosRepository;
import com.universales.practica3.repository.SiniestrosRepository;
import com.universales.practica3.wsint.PeritosInt;

@Component
public class PeritosImpl implements PeritosInt {

	@Autowired
	PeritosRepository peritosRepository;
	
	@Autowired
	SiniestrosRepository siniestrosRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	

	/**
	 * Método que permite buscar todos los peritos.
	 * 
	 * @return lista de objetos Peritos
	 */
	
	@Override
	public List<Peritos> buscar() {
		return peritosRepository.findAll();
	}
	
	/**
	 * Método que permite guardar un nuevo perito.
	 * 
	 * @param peritos objeto PeritosDTO que contiene la información del perito a guardar
	 * @return objeto Peritos que se ha guardado
	 */

	@Override
	public Peritos guardar(PeritosDTO peritos) {
	Peritos perito=modelMapper.map(peritos, Peritos.class);
	return peritosRepository.save(perito);
	}
	
	/**
	 * Método que permite eliminar un perito por su DPI.
	 * 
	 * @param dpiPerito DPI del perito a eliminar
	 */

	@Override
	public void eliminar(Long dpiPerito) {
		Optional<Peritos> peritos = peritosRepository.findBydpiPerito(dpiPerito);
		if (peritos.isPresent()) {
			siniestrosRepository.deleteAll(peritos.get().getSiniestros());
			peritosRepository.delete(peritos.get());
		}
	}
	
	/**
	 * Método que permite obtener una lista paginada de peritos.
	 * 
	 * @param page número de página
	 * @param size cantidad de elementos por página
	 * @return lista de objetos Peritos paginados
	 */
	
	@Override
	public List<Peritos>getPeritos(int page,int size){
		Pageable pageable = PageRequest.of(page, size);
		Page<Peritos> peritos= peritosRepository.findAll(pageable);
		return peritos.stream().map(perito -> {
			Peritos dto = new Peritos();
			dto.setDpiPerito(perito.getDpiPerito());
			dto.setNombrePerito(perito.getNombrePerito());
			dto.setApellidoPerito1(perito.getApellidoPerito1());
			dto.setApellidoPerito2(perito.getApellidoPerito2());
			dto.setTelefonoContacto(perito.getTelefonoContacto());
			dto.setTelefonoOficina(perito.getTelefonoOficina());
			dto.setClaseVia(perito.getClaseVia());
			dto.setNombreVia(perito.getNombreVia());
			dto.setNumerovia(perito.getNumerovia());
			dto.setCodPostal(perito.getCodPostal());
			dto.setCiudad(perito.getCiudad());
			return dto;
		}).toList();
	
	}

}
