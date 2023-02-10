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

import com.universales.practica3.dto.SiniestrosDTO;
import com.universales.practica3.entity.Siniestros;

@RestController
@RequestMapping("/auth/siniestros")
@CrossOrigin
public interface SiniestrosInt {

	@GetMapping("/buscar")
	List<Siniestros> buscar();
	
	@PostMapping("/guardar")
	Siniestros guardar(@RequestBody SiniestrosDTO siniestros);

	@DeleteMapping(path = "/eliminar/{idSiniestro}")
	void eliminar(@PathVariable("idSiniestro") Integer idSiniestro);
	
	

}
