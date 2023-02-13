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

import com.universales.practica3.dto.CompaniasSegurosDTO;
import com.universales.practica3.entity.CompaniasSeguros;

@RestController
@RequestMapping("/auth/companiasseguros")
@CrossOrigin
public interface CompaniasSegurosInt {
	
	@GetMapping("/buscar")
	public List<CompaniasSeguros> buscar();
	
	@PostMapping("/guardar")
	CompaniasSeguros guardar(@RequestBody CompaniasSegurosDTO companiaseguros);
	
	@DeleteMapping("/eliminar/{id}")
	void eliminar(@PathVariable("id") Integer id);
}
