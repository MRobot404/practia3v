package com.universales.practica3.ws;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.universales.practica3.dto.SegurosDTO;
import com.universales.practica3.entity.Seguros;
import com.universales.practica3.repository.CompaniasSegurosRepository;
import com.universales.practica3.repository.SegurosRepository;
import com.universales.practica3.wsint.SegurosInt;

@Component
public class SegurosImpl implements SegurosInt {

	@Autowired
	SegurosRepository segurosRepository;

	@Autowired
	CompaniasSegurosRepository companiassegurosRepository;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Busca todos los seguros en la base de datos
	 * 
	 * @return Lista de todos los seguros
	 */

	@Override
	public List<Seguros> buscar() {
		return segurosRepository.findAll();
	}

	/**
	 * Guarda un nuevo seguro en la base de datos
	 * 
	 * @param seguros DTO del seguro a guardar
	 * @return El seguro guardado en la base de datos
	 */

	@Override
	public Seguros guardar(SegurosDTO seguros) {
		Seguros seguro = modelMapper.map(seguros, Seguros.class);
		return segurosRepository.save(seguro);

	}

	/**
	 * Elimina un seguro de la base de datos, y todas las compañías asociadas a ese
	 * seguro
	 * 
	 * @param numeroPoliza Número de póliza del seguro a eliminar
	 */

	@Override
	public void eliminar(Long numeroPoliza) {
		Optional<Seguros> seguros = segurosRepository.findBynumeroPoliza(numeroPoliza);
		if (seguros.isPresent()) {
			segurosRepository.delete(seguros.get());
			companiassegurosRepository.deleteByNumeroPoliza(numeroPoliza);
		}
	}

	/**
	 * Busca todos los seguros en la base de datos que no tienen observaciones
	 * 
	 * @return Lista de seguros sin observaciones
	 */

	@Override
	public List<Seguros> buscarObservacionesVacias() {
		return segurosRepository.findByObservacionesIsNull();
	}

	/**
	 * Busca todos los seguros en la base de datos que tienen una fecha de inicio
	 * antes de la fecha proporcionada
	 * 
	 * @param fechaInicio Fecha para comparar con la fecha de inicio de los seguros
	 * @return Lista de seguros con fecha de inicio antes de la fecha proporcionada
	 */

	@Override
	public List<Seguros> buscarFechaAntes(Date fechaInicio) {
		return segurosRepository.findByFechaInicioBefore(fechaInicio);
	}
}
