package com.se.util;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.se.config.CustomHttp403ForbiddenEntryPoint;
import com.se.entity.UserPrincipal;
import com.se.service.UserServices;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{

	@Autowired
	private JwtUltility jwtUltility;
	
	@Autowired
	private UserServices userServices;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String tokenString = null;
		String usernameString = null;
		try {
			tokenString = request.getHeader("Authorization");
			if(tokenString != null) {
				usernameString = jwtUltility.getUsernameFromToken(tokenString);
				UserPrincipal userPrincipal = userServices.getUserByUsername(usernameString);
				if(jwtUltility.validateToken(tokenString, userPrincipal)) {
					 UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userPrincipal, null, userPrincipal.getAuthorities());
		                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		                System.out.println("\n\nSign in by token successfully!\n\n");
				}
			} else {
				System.out.println("(!) Ko the truy cap request nay vi chua login or nhap token\n=> Vao postman => /login => Headers => KEY: Authorization, VALUE: token => Chuc may man");
			}
		} catch (IllegalArgumentException e) {
			System.out.println("\n\n(!) Error missing somethings: \n1.Token is null\n2.Token is invalid \n\n");
		} catch (ExpiredJwtException e) {
			System.out.println("\n\n(!) Your token is expired \n\n");
		} catch (Exception e) {
			System.out.println("\n\n(!) Somethings error exception stacktrace!\n\n");
		}
		filterChain.doFilter(request, response);
	}

}
