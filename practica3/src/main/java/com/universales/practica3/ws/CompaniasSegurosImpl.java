package com.universales.practica3.ws;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.universales.practica3.dto.CompaniasSegurosDTO;
import com.universales.libreria.CompaniasSeguros;
import com.universales.practica3.repository.CompaniasRepository;
import com.universales.practica3.repository.CompaniasSegurosRepository;
import com.universales.practica3.repository.SegurosRepository;
import com.universales.practica3.wsint.CompaniasSegurosInt;

@Component
public class CompaniasSegurosImpl implements CompaniasSegurosInt {
	
	@Autowired
	CompaniasSegurosRepository companiassegurosRepository;
	
	@Autowired
	CompaniasRepository companiasRepository;
	
	@Autowired
	SegurosRepository segurosRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	
	/**
	 * Busca y retorna todas las relaciones de CompaniasSeguros.
	 * 
	 * @return lista de CompaniasSeguros
	 */
	@Override
	public List<CompaniasSeguros> buscar() {
		return companiassegurosRepository.findAll();
	}
	
	/**
	 * Guarda la información de una compañía de seguros en la base de datos.
	 *
	 * @param companiaseguros La información de la compañía de seguros a guardar.
	 * @return La compañía de seguros guardada.
	 */

	@Override
	public CompaniasSeguros guardar(CompaniasSegurosDTO companiaseguros) {
		CompaniasSeguros companiasseguros= modelMapper.map(companiaseguros,CompaniasSeguros.class);
		return companiassegurosRepository.save(companiasseguros);
	}
	
	/**
	 * Elimina una compañía de seguros de la base de datos, dado su ID.
	 *
	 * @param id El ID de la compañía de seguros a eliminar.
	 */

	@Override
	public void eliminar(Integer id) {
	Optional <CompaniasSeguros> companiasseguros= companiassegurosRepository.findById(id);
	if(companiasseguros.isPresent()) {
		companiassegurosRepository.delete(companiasseguros.get());
		
	}
	
	/**
	 * Busca una compañía de seguros en la base de datos, dado su ID.
	 *
	 * @param id El ID de la compañía de seguros a buscar.
	 * @return Un Optional que contiene la compañía de seguros, si se encontró.
	 */
	
	}
	@Override
	public Optional<CompaniasSeguros> buscarPorId(Integer id){
		return companiassegurosRepository.findById(id);
	}
	
	/**
	 * Busca todas las compañías de seguros en la base de datos que tengan el nombre de compañía dado.
	 *
	 * @param compania El nombre de la compañía a buscar.
	 * @return Una lista de todas las compañías de seguros que tengan el nombre dado.
	 */
	
	@Override
	public List<CompaniasSeguros> buscarPorCompania(String compania){
		return companiassegurosRepository.findByCompania(compania);
	}
	
	/**
	 * Busca una compañía de seguros en la base de datos, dado su número de póliza.
	 *
	 * @param numeroPoliza El número de póliza de la compañía de seguros a buscar.
	 * @return Un Optional que contiene la compañía de seguros, si se encontró.
	 */
	
	@Override
	public Optional<CompaniasSeguros>buscarPorNumeroPoliza(Long numeroPoliza){
		return companiassegurosRepository.findByNumeroPoliza(numeroPoliza);
	}
	
	/**
	 * Busca todas las compañías de seguros en la base de datos que coincidan con los valores dados para ID, nombre de compañía y número de póliza.
	 *
	 * @param id El ID de la compañía de seguros a buscar (o null para ignorar este criterio de búsqueda).
	 * @param compania El nombre de la compañía de seguros a buscar (o null para ignorar este criterio de búsqueda).
	 * @param numeroPoliza El número de póliza de la compañía de seguros a buscar (o null para ignorar este criterio de búsqueda).
	 * @return Una lista de todas las compañías de seguros que coinciden con los valores dados.
	 */
	
	@Override
	public List<CompaniasSeguros>buscarPorTodos(Integer id, String compania,Long numeroPoliza){
		return companiassegurosRepository.findByIdAndCompaniaAndNumeroPoliza(id, compania, numeroPoliza);
	}

}
