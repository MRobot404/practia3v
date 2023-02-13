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

import com.universales.practica3.dto.PeritosDTO;
import com.universales.practica3.entity.Peritos;

@RestController
@RequestMapping("/auth/peritos")
@CrossOrigin
public interface PeritosInt {

	@GetMapping("/buscar")
	List<Peritos> buscar();

	@PostMapping("/guardar")
	Peritos guardar(@RequestBody PeritosDTO peritos);

	@DeleteMapping("/eliminar/{dpiPerito}")
	void eliminar(@PathVariable("dpiPerito") Long dpiPerito);

}
