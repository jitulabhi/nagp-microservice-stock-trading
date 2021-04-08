package com.labhi.gateway.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.labhi.gateway.exception.CustomException;

import io.jsonwebtoken.JwtException;

public class JwtTokenFilter extends OncePerRequestFilter {
	private JwtTokenProvider jwtTokenProvider;

	public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@Override
	public void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String token = jwtTokenProvider.resolveToken(request);
		if (token != null) {
			if (!jwtTokenProvider.isTokenPresentInDB(token)) {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT token");
				throw new CustomException("Invalid JWT token", HttpStatus.UNAUTHORIZED);
			}
			try {
				jwtTokenProvider.validateToken(token);
			} catch (JwtException | IllegalArgumentException e) {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT token");
				throw new CustomException("Invalid JWT token", HttpStatus.UNAUTHORIZED);
			}
			Authentication auth = token != null ? jwtTokenProvider.getAuthentication(token) : null;
			// setting auth in the context.
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
		filterChain.doFilter(req, res);

	}
}
