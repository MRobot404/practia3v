package com.universales.practica3.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.universales.practica3.dto.ClientesDTO;
import com.universales.practica3.entity.Clientes;
import com.universales.practica3.repository.ClientesRepository;
import com.universales.practica3.repository.SegurosRepository;
import com.universales.practica3.wsint.ClientesInt;

@Component
public class ClientesImpl implements ClientesInt {

	@Autowired
	ClientesRepository clientesRepository;

	@Autowired
	SegurosRepository segurosRepository;

	@Override
	public List<Clientes> buscar() {
		return clientesRepository.findAll();
	}

	@Override
	public Clientes guardar(ClientesDTO clientes) {
		Clientes c = new Clientes();
		c.setDpiCliente(clientes.getDpiCliente());
		c.setNombreCL(clientes.getNombreCL());
		c.setApellido1(clientes.getApellido1());
		c.setApellido2(clientes.getApellido2());
		c.setClaseVia(clientes.getClaseVia());
		c.setNombreVia(clientes.getNombreVia());
		c.setNumeroVia(clientes.getNumeroVia());
		c.setTelefono(clientes.getTelefono());
		c.setObservaciones(clientes.getObservaciones());
		c.setSeguroslist(clientes.getSeguroslist());
		return clientesRepository.save(c);
	}

	@Override
	public void eliminar(Long dpiCliente) {
		Optional<Clientes> clientes = clientesRepository.findBydpiCliente(dpiCliente);
		if (clientes.isPresent()) {
			segurosRepository.deleteAll(clientes.get().getSeguroslist());
			clientesRepository.delete(clientes.get());
		}
	}

	@Override
	public List<Clientes> getUsuario(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Clientes> clientes = clientesRepository.findAll(pageable);
		return clientes.stream().map(cliente -> {
			Clientes dto = new Clientes();
			dto.setApellido1(cliente.getApellido1());
			dto.setApellido2(cliente.getApellido2());
			dto.setCiudad(cliente.getCiudad());
			dto.setClaseVia(cliente.getClaseVia());
			dto.setCodPostal(cliente.getCodPostal());
			dto.setDpiCliente(cliente.getDpiCliente());
			dto.setNombreCL(cliente.getNombreCL());
			dto.setNombreVia(cliente.getNombreVia());
			dto.setNombreVia(cliente.getNombreVia());
			dto.setNumeroVia(cliente.getNumeroVia());
			dto.setObservaciones(cliente.getObservaciones());
			dto.setSeguroslist(cliente.getSeguroslist());
			dto.setTelefono(cliente.getTelefono());
			return dto;
		}).toList();
	}
}
