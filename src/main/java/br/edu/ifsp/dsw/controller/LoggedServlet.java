package br.edu.ifsp.dsw.controller;

import java.io.IOException;

import br.edu.ifsp.dsw.controller.command.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/logged.do")
public class LoggedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var action = request.getParameter("action");
		Command command = null;
		
		if ("register".equals(action)) {
			command = new RegisterUserCommand();
		} else if ("logout".equals(action)) {
			command = new LogoutCommand();
		} else if ("register_users_page".equals(action)) {
			command = new UserRegistrationPageCommand();
		} else if ("register_pedido_page".equals(action)) {
			command = new OrderRegistrationPageCommand();
		} else if ("register_pedido".equals(action)) {
			command = new RegisterOrderCommand();
		} else if ("delete_pedido".equals(action)) {
			command = new DeleteOrderCommand();
		} else if ("page_pedidos".equals(action)) {
			command = new OrderPageCommand();
		} else if ("update_pedidos_page".equals(action)) {
			command = new OrderUpdatePageCommand();
		} else if ("update_pedido".equals(action)) {
			command = new UpdateOrderCommand();
		} else if ("search_pedidos_usuario".equals(action)) {
			command = new SearchOrdersByCustomerCommand();
		} else if ("page_relatorios".equals(action)) {
			command = new ReportRegistrationPageCommand();
		} else {
			command = new ErrorCommand();
		}
		
		var view = command.execute(request, response);
		var dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
