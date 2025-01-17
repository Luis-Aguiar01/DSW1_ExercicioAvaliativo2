package br.edu.ifsp.dsw.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw.model.dao.user.UsuarioDaoFactory;
import br.edu.ifsp.dsw.model.entity.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		var name = request.getParameter("name");
		var email = request.getParameter("email");
		var password = request.getParameter("password");
		var userDao = new UsuarioDaoFactory().factory();
		
		var findedUser = userDao.findByEmail(email);
		
		if (findedUser != null) {
			return "register.jsp?error=true";
		}
		
		userDao.create(new Usuario(email, password, name));
		
		return "register.jsp?error=false";
	}
}
