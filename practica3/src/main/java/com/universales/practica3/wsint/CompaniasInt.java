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

import com.universales.practica3.dto.CompaniasDTO;
import com.universales.libreria.Companias;


@RestController
@RequestMapping("/auth/companias")
@CrossOrigin
public interface CompaniasInt {

	@GetMapping("/buscar")
	List<Companias> buscar();
	
	@PostMapping("/guardar")
	Companias guardar(@RequestBody  CompaniasDTO companias);
	
	@DeleteMapping("/eliminar/{nombreCompania}")
	void eliminar(@PathVariable("nombreCompania")  String nombreCompania);
	
	
	@GetMapping("/buscar/por/{codPostal}")
	List<Companias> buscarPorCodigoPostal(@PathVariable("codPostal") String codPostal);
	
	@GetMapping("/buscar/porr/{numeroVia}")
	List<Companias> buscarPorNumeroViaFinalizaEn(@PathVariable("numeroVia")  String numeroVia);

	@GetMapping("buscar/notasVacias")
	List<Companias> buscarNotasVacias();
	

}
