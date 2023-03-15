package com.universales.practica3.security;


import java.util.Map;

import com.universales.libreria.Usuario;


public interface JwtGeneratorInterface {
	Map<String, String> generateToken(Usuario usuario);
}
