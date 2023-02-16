package com.universales.practica3.security;

import java.io.IOException;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtFilter extends GenericFilterBean {
	/**
	 * 
	 * Sobrescribe el método doFilter para implementar la lógica de filtrado. Extrae
	 * el token JWT de la cabecera Authorization de la petición HTTP y lo valida. Si
	 * el token es válido, lo decodifica y almacena la información del usuario en un
	 * atributo del objeto HttpServletRequest.
	 * 
	 * @param servletRequest  objeto que representa la petición HTTP.
	 * @param servletResponse objeto que representa la respuesta HTTP.
	 * @param filterChain     objeto que representa la cadena de filtros a los que
	 *                        se aplica la petición HTTP.
	 * @throws IOException si hay algún error de lectura/escritura en la
	 *                     entrada/salida.
	 */

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		final HttpServletRequest request = (HttpServletRequest) servletRequest;
		final HttpServletResponse response = (HttpServletResponse) servletResponse;
		final String authHeader = request.getHeader("authorization");
		if ("OPTIONS".equals(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
			filterChain.doFilter(request, response);
		} else {
			if (authHeader == null || !authHeader.startsWith("Bearer ")) {
				throw new ServletException("An exception occurred");
			}
		}
		final String token = authHeader.substring(7);
		Claims claims = Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody();
		request.setAttribute("claims", claims);
		request.setAttribute("blog", servletRequest.getParameter("id"));
		filterChain.doFilter(request, response);
	}
}
