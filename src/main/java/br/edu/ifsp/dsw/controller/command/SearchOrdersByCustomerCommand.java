package br.edu.ifsp.dsw.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw.model.dao.pedidos.PedidoDaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SearchOrdersByCustomerCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		var name = request.getParameter("name");
		var pedidosDao = new PedidoDaoFactory().factory();
		var pedidosByName = pedidosDao.getAllByName(name);
		
		request.setAttribute("pedidos", pedidosByName);
		return "/logged/relatorios.jsp";
	}
}
