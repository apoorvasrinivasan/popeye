package com.aspire.hackathon.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.aspire.hackathon.utils.JwtUtils;

@Component
public class AuthorizationFilter extends OncePerRequestFilter{

	private JwtUtils jwtUtils;
	private UserDetailsService userDetailsService;
	
	@Autowired
	public AuthorizationFilter(JwtUtils jwtUtils, UserDetailsService userDetailsService) {
		this.jwtUtils = jwtUtils;
		this.userDetailsService = userDetailsService;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String authorizationHeaderValue = request.getHeader("Authorization");
		String jwt = null;
		String userName = null;
		
		if(authorizationHeaderValue != null && authorizationHeaderValue.startsWith("Bearer ")) {
			jwt = authorizationHeaderValue.substring(7);
			userName = jwtUtils.extractUserName(jwt);
		}
		
		if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(userName);

			if(Boolean.TRUE.equals(jwtUtils.validateToken(jwt, userDetails))) {
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, null);
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
		
		filterChain.doFilter(request, response);
	}
}
