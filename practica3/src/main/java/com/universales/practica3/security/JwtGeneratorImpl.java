package com.universales.practica3.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.universales.practica3.entity.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Service
public class JwtGeneratorImpl implements JwtGeneratorInterface{

	private static final String SECRET = "secret";
	private static final String MESSAGE = "Token generado exitosamente";
	private static final long TOKENVALIDITYINSECONS = 3600;

	/**
	 * Método para generar un token 
	 * @param Usuario objeto usuario con información del usuario
	 * @return un mapa con el token JWT generado y un mensaje de éxito
	 */
	
	@Override
	public Map<String, String> generateToken(Usuario usuario) {
		String jwtToken = "";
		Date now = new Date();
		Date expiration = new Date(now.getTime() + TOKENVALIDITYINSECONS * 1000);
		jwtToken = Jwts.builder().setSubject(usuario.getUser()).setIssuedAt(now).setExpiration(expiration)
				.signWith(SignatureAlgorithm.HS256, SECRET).compact();
		Map<String, String> jwtTokenGen = new HashMap<>();
		jwtTokenGen.put("token", jwtToken);
		jwtTokenGen.put("message", MESSAGE);	
		return jwtTokenGen;
	}
	
}
