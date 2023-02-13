package com.universales.practica3.security;


import java.util.Map;

import com.universales.practica3.entity.Usuario;


public interface JwtGeneratorInterface {
	Map<String, String> generateToken(Usuario usuario);
}
