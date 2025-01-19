package br.edu.ifsp.dsw.controller;

import java.io.IOException;

import br.edu.ifsp.dsw.controller.command.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/disconnected.do")
public class DisconnectedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var action = request.getParameter("action");
		Command command = null;
		
		if ("login_page".equals(action)) {
			command = new LoginPageCommand();
		}  else if ("login".equals(action)) {
			command = new LoginCommand();
		} else if ("home_page".equals(action)) {
			command = new HomePageCommand();
		} else {
			command = new ErrorCommand();
		}
		
		var view = command.execute(request, response);
		var dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
}
