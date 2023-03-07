package com.universales.practica3.wsint;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.universales.practica3.dto.ClientesDTO;
import com.universales.libreria.Clientes;

@RestController
@RequestMapping("/auth/clientes")
@CrossOrigin
public interface ClientesInt {

	@GetMapping("/buscar")
	public List<Clientes> buscar();

	@PostMapping("/guardar")
	Clientes guardar(@RequestBody ClientesDTO clientes);

	@DeleteMapping(path = "/eliminar/{dpiCliente}")
	void eliminar(@PathVariable("dpiCliente") Long dpiCliente);

	@GetMapping("/paginar")
	List<Clientes> getUsuario(int page, int size);
	
	@GetMapping("/buscar/por/{telefono}")
	List<Clientes> buscarPorTelefonoEmpezado24(@PathVariable("telefono") String telefono);
	
	@GetMapping("/buscar/porr/{nombreCL}")
	List<Clientes> buscarporNombre(@PathVariable("nombreCL") String nombreCL);
	

}
