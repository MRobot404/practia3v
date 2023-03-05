package com.universales.practica3;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.universales.practica3.dto.SegurosDTO;
import com.universales.practica3.entity.Seguros;
import com.universales.practica3.ws.SegurosImpl;
import com.universales.practica3.ws.UsuarioImpl;
@SpringBootTest
class SegurosImplTest {
	private static final Log LOG = LogFactory.getLog(UsuarioImpl.class);
	
	@Autowired
	SegurosImpl seguro;
	
	public SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Test
	void buscarSegurosTest() {
		List<Seguros> seguros=seguro.buscar();
		assertNotNull(seguros,"Los seguros no existen");
	}
	
	@Test
	void guardarSegurosTest() {
		try {
		SegurosDTO seguros=new SegurosDTO();
		seguros.setRamo("Seguros personales");
		seguros.setDpiCliente((long) 564323);
		seguros.setFechaVencimiento(dateFormat.parse("2022-02-24 15:30:00"));
		seguros.setFechaVencimiento(dateFormat.parse("2023-02-28 15:30:00"));
		seguros.setObservaciones("");
		Seguros s=seguro.guardar(seguros);
		assertNotNull(s,"Seguro creado");
		seguro.eliminar(s.getNumeroPoliza());
		} catch (Exception e) {
			LOG.error(e.getMessage());
			fail("No se pudo guardar el seguro");
		}
	}
	
	@Test
	void eliminarTest() {
		try {
			Long numeropoliza=(long) 14;
			seguro.eliminar(numeropoliza);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			fail("No se borro el seguro");
		}
	}
	
	@Test
	void buscarObservacionesVaciasTest() {
	List<Seguros> seguros=seguro.buscarObservacionesVacias();
	if(seguros.get(0)!=null) {
		assertTrue(true);
	}else {
		LOG.error("El usuario no existe");
		fail("Usuario no encontrado");
	}
	}
	
	@Test
	void buscarFechaAntesTest() {
	try {
		List<Seguros> seguros=seguro.buscarFechaAntes(dateFormat.parse("2022-02-24 15:30:00"));
		if(seguros.get(0)!=null) {
			assertTrue(true);
		}
	} catch (ParseException e) {
		e.printStackTrace();
	}
	}
	
}
