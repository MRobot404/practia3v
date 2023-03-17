package com.universales.practica3.security;


import java.util.Map;

import com.universales.practica3.dto.UsuarioDTO;


public interface JwtGeneratorInterface {
	Map<String, String> generateToken(UsuarioDTO usuario);
}
