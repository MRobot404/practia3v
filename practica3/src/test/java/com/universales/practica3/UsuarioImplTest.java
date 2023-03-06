/*  package com.universales.practica3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.universales.practica3.dto.UsuarioDTO;
import com.universales.practica3.entity.Usuario;
import com.universales.practica3.ws.UsuarioImpl;

@SpringBootTest
class UsuarioImplTest {
	private static final Log LOG = LogFactory.getLog(UsuarioImpl.class);
	@Autowired
	UsuarioImpl usuario;

	@Test
	void buscarUsuariosTest() {
		List<Usuario> usuarios = usuario.buscarUsuario();
		assertNotNull(usuarios, "Los ususarios no existen");
	}

	@Test
	void guardarUsuariosTest() {
		try {
			UsuarioDTO usuarios = new UsuarioDTO();
			usuarios.setUser("Pruebas");
			usuarios.setContrasena("Pruebas");
			Usuario u = usuario.guardar(usuarios);
			assertNotNull(u, "Usuario guardado");
			usuario.eliminar(u.getIdUsuario());
		} catch (Exception e) {
			LOG.error(e.getMessage());
			fail("No se pudo guardar al usuario");
		}
	}

	@Test
	void eliminarUsuarioTest() {
		try {
			Integer idUsuario = 1;
			usuario.eliminar(idUsuario);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			fail("No se borro el usuario");
		}
	}

	@Test
	void buscarPorIdUsuarioTest() {
		List<Usuario> usuarios=usuario.buscarPorIdUsuario(10);
		if(usuarios.get(0)!=null) {
			assertTrue(true);
		}else {
			LOG.error("El usuario no existe");
			fail("Usuario no encontrado");
		}
	}
	
	@Test
	void loginUserUsuarioYContrasenaValidos() {
	    // Arrange
	    String user = "test";
	    String contrasena = "test";
	    Usuario usuarios = new Usuario();
	    usuarios.setUser(user);
	    usuarios.setContrasena(contrasena);
	    ResponseEntity<Object> response = usuario.loginUser(usuarios);
	    assertEquals(HttpStatus.OK, response.getStatusCode());
	    assertNotNull(response.getBody());
	}
	
	@Test
	void getUsuarioByUsuarioAndContrasenaUsuarioYContrasenaValidos() throws UserPrincipalNotFoundException {
	    String user = "test";
	    String contrasena = "test";
	    Usuario usuarios = usuario.getUsuarioByUsuarioAndContrasena(user, contrasena);
	    assertNotNull(usuarios);
	}
	
	
}
*/