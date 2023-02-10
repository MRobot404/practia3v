package com.universales.practica3.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
}
