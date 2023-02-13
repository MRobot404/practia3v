package com.universales.practica3.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

}
