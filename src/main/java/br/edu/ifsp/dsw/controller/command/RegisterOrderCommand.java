package br.edu.ifsp.dsw.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw.model.dao.pedidos.PedidoDaoFactory;
import br.edu.ifsp.dsw.model.dao.user.UsuarioDaoFactory;
import br.edu.ifsp.dsw.model.entity.Pedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterOrderCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		var address = request.getParameter("address");
		var price = Double.parseDouble(request.getParameter("price"));
		var descricao = request.getParameter("descricao");
		var email = request.getParameter("email");
		var nomeCliente = request.getParameter("cliente");
			
		var pedidoDao = new PedidoDaoFactory().factory();
		var userDao = new UsuarioDaoFactory().factory();
		
		var findedUser = userDao.findByEmail(email);
			
		if (findedUser == null) {
			return "/logged/register-pedido.jsp?error=true";
		}
		
		pedidoDao.create(new Pedido(address, price, descricao, findedUser, nomeCliente));
		
		return "/logged/register-pedido.jsp?error=false";
	}	
}
