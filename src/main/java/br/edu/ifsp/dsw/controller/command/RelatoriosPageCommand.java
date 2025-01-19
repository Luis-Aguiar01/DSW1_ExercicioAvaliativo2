package br.edu.ifsp.dsw.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw.model.dao.pedidos.PedidoDaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RelatoriosPageCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		var pedidosDao = new PedidoDaoFactory().factory();
		var pedidos = pedidosDao.getAll();
		request.setAttribute("pedidos", pedidos);
		return "/logged/relatorios.jsp";
	}
}
