package br.edu.ifsp.dsw.controller;

import java.io.IOException;

import br.edu.ifsp.dsw.controller.command.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

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
		} else if ("delete_pedido".equals(action)) {
			command = new DeletePedidoCommand();
		} else if ("home_page".equals(action)) {
			command = new HomePageCommand();
		} else if ("page_pedidos".equals(action)) {
			command = new HomePagePedidosCommand();
		} else if ("update_pedidos_page".equals(action)) {
			command = new UpdatePedidoPageCommand();
		} else if ("update_pedido".equals(action)) {
			command = new UpdatePedidoCommand();
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
