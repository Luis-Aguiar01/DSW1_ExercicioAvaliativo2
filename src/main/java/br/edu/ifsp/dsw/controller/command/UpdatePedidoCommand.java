package br.edu.ifsp.dsw.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw.model.dao.pedidos.PedidoDaoFactory;
import br.edu.ifsp.dsw.model.entity.Pedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdatePedidoCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		var address = request.getParameter("address");
		var price = Double.parseDouble(request.getParameter("price"));
		var descricao = request.getParameter("descricao");
		var id = Integer.parseInt(request.getParameter("id"));
		var nomeCliente = request.getParameter("cliente");
		
		var newPedidoData = new Pedido();
		newPedidoData.setDescricao(descricao);
		newPedidoData.setEnderecoEntrega(address);
		newPedidoData.setPrice(price);
		newPedidoData.setNomeCliente(nomeCliente);
		
		var pedidoDao = new PedidoDaoFactory().factory();
		pedidoDao.update(id, newPedidoData);
		
		var pedidos = pedidoDao.getAll();
		request.setAttribute("pedidos", pedidos);
		return "/logged/pedidos.jsp";
	}
}
