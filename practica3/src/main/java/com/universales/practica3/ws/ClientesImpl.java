package com.universales.practica3.ws;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.universales.practica3.dto.ClientesDTO;
import com.universales.libreria.Clientes;
import com.universales.practica3.repository.ClientesRepository;
import com.universales.practica3.repository.SegurosRepository;
import com.universales.practica3.wsint.ClientesInt;

@Component
public class ClientesImpl implements ClientesInt {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	ClientesRepository clientesRepository;

	@Autowired
	SegurosRepository segurosRepository;

	/**
	 * Devuelve la lista de todos los clientes.
	 * 
	 * @return lista de todos los clientes
	 */
	@Override
	public List<Clientes> buscar() {
		return clientesRepository.findAll();
	}

	/**
	 * Guarda un nuevo cliente en la base de datos.
	 * 
	 * @param clientes objeto ClientesDTO con los datos del nuevo cliente
	 * @return el cliente guardado
	 */

	@Override
	public Clientes guardar(ClientesDTO clientes) {
		Clientes cliente = modelMapper.map(clientes, Clientes.class);
		return clientesRepository.save(cliente);
	}

	/**
	 * Elimina un cliente y todos sus seguros asociados de la base de datos.
	 * 
	 * @param dpiCliente el DPI del cliente a eliminar
	 */

	@Override
	public void eliminar(Long dpiCliente) {
		Optional<Clientes> clientes = clientesRepository.findBydpiCliente(dpiCliente);
		if (clientes.isPresent()) {
			segurosRepository.deleteAll(clientes.get().getSeguroslist());
			clientesRepository.delete(clientes.get());
		}
	}
	
	/**
	 * Devuelve una lista de clientes paginada.
	 * 
	 * @param page el número de página a obtener
	 * @param size el tamaño de la página
	 * @return lista de clientes paginada
	 */

	@Override
	public Page<Clientes>getClientesPaginado(int page,int size){
		Pageable pageable=PageRequest.of(page, size);
		return clientesRepository.findAll(pageable);
	}
	
	/**
	 * Busca una lista de clientes cuyo número de teléfono empiece con "24".
	 * 
	 * @param telefono el prefijo del número de teléfono a buscar
	 * @return lista de clientes cuyo número de teléfono empieza por "24"
	 */

	@Override
	public List<Clientes> buscarPorTelefonoEmpezado24(String telefono) {
		return clientesRepository.findByTelefonoStartingWith("24");
	}
	
	/**
	 * Busca una lista de clientes cuyo nombre empiece por el valor dado.
	 * 
	 * @param nombreCL el valor con el que empieza el nombre de los clientes a buscar
	 * @return lista de clientes cuyo nombre empieza por el valor dado
	 */

	@Override
	public List<Clientes> buscarporNombre(String nombreCL) {
		return clientesRepository.findByNombreCLStartingWith(nombreCL);
	}

}
