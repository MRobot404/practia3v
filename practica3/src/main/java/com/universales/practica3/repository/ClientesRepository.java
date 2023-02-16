package com.universales.practica3.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universales.practica3.entity.Clientes;

@Repository("clientesRepository")
public interface ClientesRepository extends JpaRepository<Clientes, Serializable> {

	Optional<Clientes> findBydpiCliente(long dpiCliente);
	List<Clientes> findByTelefonoStartingWith(String telefono);
	List<Clientes> findByNombreCLStartingWith(String nombreCL);
}
