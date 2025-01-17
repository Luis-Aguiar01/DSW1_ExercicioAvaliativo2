package br.edu.ifsp.dsw.model.dao.user;

import br.edu.ifsp.dsw.model.entity.Usuario;

public interface UsuarioDao {
	
	boolean create(Usuario usuario);
	
	Usuario findByEmail(String email);
}
