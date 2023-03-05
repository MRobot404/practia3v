package com.universales.practica3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.universales.practica3.dto.SiniestrosDTO;
import com.universales.practica3.entity.Siniestros;
import com.universales.practica3.ws.SiniestrosImpl;
import com.universales.practica3.ws.UsuarioImpl;

@SpringBootTest
class SiniestrosImplTest {
	private static final Log LOG = LogFactory.getLog(UsuarioImpl.class);
	
	@Autowired
	SiniestrosImpl siniestro;
	public SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Test
	void buscarSiniestroTest() {
		List<Siniestros> siniestros = siniestro.buscar();
		assertNotNull(siniestros, "Los ususarios no existen");
	}
	
	@Test
	void guardarSiniestrosTest() {
		try {
			SiniestrosDTO siniestros=new SiniestrosDTO();
			siniestros.setFechaSiniestro(dateFormat.parse("2022-02-24 15:30:00"));
			siniestros.setCausas("pérdidas financieras");
			siniestros.setAceptado("no");
			siniestros.setIndemnizacion(1500);
			siniestros.setDpiPerito((long) 123456);
			siniestros.setSeguro((long) 13);
			Siniestros s= siniestro.guardar(siniestros);
			assertNotNull(s,"Siniestro creado");
			siniestro.eliminar(s.getIdSiniestro());
		} catch (Exception e) {
			LOG.error(e.getMessage());
			fail("No se pudo guardar el siniestro");
		}
	}
	
	@Test
	void eliminarSiniestroTest() {
		try {
			Integer idSiniestro=18;
			Siniestros siniestros=new Siniestros();
			siniestros.setIdSiniestro(idSiniestro);
			siniestro.eliminar(idSiniestro);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			fail("No se borro el siniestro");
		}
	}

	@Test
	void getSiniestroTest() {
		List<Siniestros> result = siniestro.getSiniestro(0, 10);
		 assertEquals(10, result.size());
	}
	

	
}
