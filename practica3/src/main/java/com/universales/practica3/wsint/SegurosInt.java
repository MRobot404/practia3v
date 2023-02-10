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

import com.universales.practica3.dto.SegurosDTO;
import com.universales.practica3.entity.Seguros;

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

}
