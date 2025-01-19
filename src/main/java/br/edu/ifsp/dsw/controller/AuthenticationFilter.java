package br.edu.ifsp.dsw.controller;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = { "/logged.do", "/logged/*" } )
public class AuthenticationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		var httpRequest = (HttpServletRequest) request;
		var session = httpRequest.getSession(false);
		
		if (session != null && session.getAttribute("user") != null) {
			chain.doFilter(request, response);
		} else {
			var dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}
}
