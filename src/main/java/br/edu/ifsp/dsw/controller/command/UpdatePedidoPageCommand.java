package br.edu.ifsp.dsw.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw.model.dao.pedidos.PedidoDaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdatePedidoPageCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		var id = Integer.parseInt(request.getParameter("id"));
		var pedidoDao = new PedidoDaoFactory().factory();
		var pedido = pedidoDao.findById(id);
		request.setAttribute("pedido", pedido);
		return "/logged/update-pedido.jsp";
	}
}
