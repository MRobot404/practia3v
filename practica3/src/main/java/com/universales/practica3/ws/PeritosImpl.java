package com.universales.practica3.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.universales.practica3.dto.PeritosDTO;
import com.universales.practica3.entity.Peritos;
import com.universales.practica3.repository.PeritosRepository;
import com.universales.practica3.wsint.PeritosInt;

@Component
public class PeritosImpl implements PeritosInt {

	@Autowired
	PeritosRepository peritosRepository;

	@Override
	public List<Peritos> buscar() {
		return peritosRepository.findAll();
	}

	@Override
	public Peritos guardar(PeritosDTO peritos) {
		Peritos p = new Peritos();
		p.setDpiPerito(peritos.getDpiPerito());
		p.setNombrePerito(peritos.getNombrePerito());
		p.setApellidoPerito1(peritos.getApellidoPerito1());
		p.setApellidoPerito2(peritos.getApellidoPerito2());
		p.setTelefonoContacto(peritos.getTelefonoContacto());
		p.setTelefonoOficina(peritos.getTelefonoOficina());
		p.setClaseVia(peritos.getClaseVia());
		p.setNombreVia(peritos.getNombreVia());
		p.setNumerovia(peritos.getNumerovia());
		p.setCodPostal(peritos.getCodPostal());
		p.setCiudad(peritos.getCiudad());
		return peritosRepository.save(p);
	}

	@Override
	public void eliminar(Long dpiPerito) {
		Optional<Peritos> peritos = peritosRepository.findBydpiPerito(dpiPerito);
		if (peritos.isPresent()) {
			peritosRepository.delete(peritos.get());
		}
	}
	
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
