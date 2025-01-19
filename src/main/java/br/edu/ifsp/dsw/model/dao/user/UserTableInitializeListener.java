package br.edu.ifsp.dsw.model.dao.user;

import br.edu.ifsp.dsw.model.dao.connection.DatabaseConnectionFactory;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

// Explicação presente na classe "PedidoTableInitializeListener".
// A única diferença, é que aqui eu criei o usuário administrador do sistema
// assim que a aplicação é inicializada.

@WebListener
public class UserTableInitializeListener implements ServletContextListener {

	private static final String USER_TABLE = "CREATE TABLE IF NOT EXISTS usuario (\r\n"
			+ "	   email VARCHAR(50) PRIMARY KEY,\r\n"
			+ "    nome VARCHAR(100) NOT NULL,\r\n"
			+ "    senha VARCHAR(45) NOT NULL\r\n"
			+ ");\r\n"
			+ "";
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try (var conn = new DatabaseConnectionFactory().factory()) {
			var ps = conn.prepareStatement(USER_TABLE);
			ps.execute();
			
			ps = conn.prepareStatement(UsuarioDaoImp.CHECK_USER_ALREADY_EXISTS_SQL);
			ps.setString(1, "admin@admin.com");
			var rs = ps.executeQuery();
			
			if (rs.next() && rs.getInt(1) == 0) {
				ps = conn.prepareStatement(UsuarioDaoImp.CREATE_USER_SQL);
				ps.setString(1, "admin@admin.com");
				ps.setString(2, "admin");
				ps.setString(3, "admin");
				ps.execute();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
