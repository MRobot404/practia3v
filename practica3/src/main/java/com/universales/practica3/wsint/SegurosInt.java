package com.universales.practica3.wsint;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.universales.practica3.dto.SegurosDTO;
import com.universales.libreria.Seguros;

@RestController
@RequestMapping("/auth/seguros")
@CrossOrigin
public interface SegurosInt {

	@GetMapping("/buscar")
	public List<Seguros> buscar();
	
	@PostMapping("/guardar")
	Seguros guardar(@RequestBody SegurosDTO seguros);
	
	@DeleteMapping(path = "/eliminar/{numeroPoliza}")
	void eliminar(@PathVariable("numeroPoliza") Long numeroPoliza);
	
	@GetMapping("/buscar/observacionesVacias")
	List<Seguros> buscarObservacionesVacias();

	@GetMapping("/buscar/fechaInicio/")
	List<Seguros> buscarFechaAntes(@RequestParam("fechaInicio") @DateTimeFormat(pattern="yyyy-MM-dd") Date fechaInicio);

}
