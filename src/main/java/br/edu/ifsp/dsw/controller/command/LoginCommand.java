package br.edu.ifsp.dsw.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw.model.dao.user.UsuarioDaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		var email = request.getParameter("email");
		var password = request.getParameter("password");
		var userDao = new UsuarioDaoFactory().factory();
		
		var findedUser = userDao.findByEmail(email);
		
		if (findedUser == null || !findedUser.getPassword().equals(password)) {
			return "login.jsp?error=true";
		}
		
		var session = request.getSession();
		session.setAttribute("user", findedUser);
		
		return "index.jsp";
	}
}
