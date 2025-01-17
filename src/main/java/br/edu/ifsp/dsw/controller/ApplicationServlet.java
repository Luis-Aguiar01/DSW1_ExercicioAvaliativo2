package br.edu.ifsp.dsw.controller;

import java.io.IOException;

import br.edu.ifsp.dsw.controller.command.Command;
import br.edu.ifsp.dsw.controller.command.LoginCommand;
import br.edu.ifsp.dsw.controller.command.LoginPageCommand;
import br.edu.ifsp.dsw.controller.command.LogoutCommand;
import br.edu.ifsp.dsw.controller.command.RegisterCommand;
import br.edu.ifsp.dsw.controller.command.RegisterPageCommand;
import br.edu.ifsp.dsw.controller.command.RegisterPedidoCommand;
import br.edu.ifsp.dsw.controller.command.RegisterPedidoPageCommand;
import br.edu.ifsp.dsw.controller.command.RegisterUsersPageCommand;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/application.do")
public class ApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var action = request.getParameter("action");
		Command command = null;
		
		if ("login_page".equals(action)) {
			command = new LoginPageCommand();
		} else if ("register_page".equals(action)) {
			command = new RegisterPageCommand();
		} else if ("register".equals(action)) {
			command = new RegisterCommand();
		} else if ("login".equals(action)) {
			command = new LoginCommand();
		} else if ("logout".equals(action)) {
			command = new LogoutCommand();
		} else if ("register_users".equals(action)) {
			command = new RegisterCommand();
		} else if ("register_users_page".equals(action)) {
			command = new RegisterUsersPageCommand();
		} else if ("register_pedido_page".equals(action)) {
			command = new RegisterPedidoPageCommand();
		} else if ("register_pedido".equals(action)) {
			command = new RegisterPedidoCommand();
		} else if ("delete_pedido_page".equals(action)) {
			
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
