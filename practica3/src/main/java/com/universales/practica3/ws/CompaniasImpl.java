package com.universales.practica3.ws;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.universales.practica3.dto.CompaniasDTO;
import com.universales.practica3.entity.Companias;
import com.universales.practica3.repository.CompaniasRepository;
import com.universales.practica3.repository.CompaniasSegurosRepository;
import com.universales.practica3.wsint.CompaniasInt;

import jakarta.transaction.Transactional;

@Component
public class CompaniasImpl implements CompaniasInt {

	@Autowired
	CompaniasRepository companiasRepository;

	@Autowired
	CompaniasSegurosRepository companiassegurosRepository;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Método que permite buscar todas las compañías.
	 * 
	 * @return lista de objetos Companias
	 */

	@Override
	public List<Companias> buscar() {
		return companiasRepository.findAll();
	}

	/**
	 * Método que permite guardar una nueva compañía.
	 *
	 * @param companias objeto CompaniasDTO que contiene la información de la
	 *                  compañía a guardar
	 * @return objeto Companias que se ha guardado
	 */

	@Override
	public Companias guardar(CompaniasDTO companias) {
		Companias compania = modelMapper.map(companias, Companias.class);
		return companiasRepository.save(compania);
	}

	/**
	 * Método que permite eliminar una compañía.
	 *
	 * @param nombreCompania nombre de la compañía a eliminar
	 */

	@Transactional
	@Override
	public void eliminar(String nombreCompania) {
		companiassegurosRepository.deleteByCompania(nombreCompania);
		Optional<Companias> companias = companiasRepository.findByNombreCompania(nombreCompania);
		if (companias.isPresent()) {
			companiasRepository.delete(companias.get());

		}
	}

	/**
	 * Método que permite buscar compañías por código postal.
	 *
	 * @param codPostal código postal a buscar
	 * @return lista de objetos Companias que coinciden con el código postal
	 */

	@Override
	public List<Companias> buscarPorCodigoPostal(String codPostal) {
		return companiasRepository.findByCodPostalContainingIgnoreCase(codPostal);
	}
	
	/**
	 * Método que permite buscar compañías por número de vía que finaliza en un valor dado.
	 *
	 * @param numeroVia número de vía a buscar
	 * @return lista de objetos Companias que tienen un número de vía que finaliza en el valor dado
	 */

	@Override
	public List<Companias> buscarPorNumeroViaFinalizaEn(String numeroVia) {
		return companiasRepository.findByNumeroViaEndingWith(numeroVia);
	}

	/**
	 * Método que permite buscar compañías que no tienen notas asociadas.
	 *
	 * @return lista de objetos Companias que no tienen notas asociadas
	 */
	
	
	@Override
	public List<Companias> buscarNotasVacias() {
		return companiasRepository.findByNotasIsNull();
	}
}
