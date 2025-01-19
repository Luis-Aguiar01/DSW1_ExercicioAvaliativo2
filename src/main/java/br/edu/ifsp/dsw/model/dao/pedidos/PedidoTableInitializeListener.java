package br.edu.ifsp.dsw.model.dao.pedidos;

import br.edu.ifsp.dsw.model.dao.connection.DatabaseConnectionFactory;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class PedidoTableInitializeListener implements ServletContextListener {
	
	private static final String CREATE_TABLE_PEDIDO = "CREATE TABLE IF NOT EXISTS pedido (\r\n"
			+ "	   id_pedido INT PRIMARY KEY,\r\n"
			+ "	   nome_cliente VARCHAR(100) NOT NULL,\r\n"
			+ "    endereco_entrega VARCHAR(200) NOT NULL,\r\n"
			+ "    valor DECIMAL(10, 2) NOT NULL,\r\n"
			+ "    descricao VARCHAR(300),\r\n"
			+ "    email_usuario VARCHAR(50) NOT NULL,\r\n"
			+ "    FOREIGN KEY (email_usuario) REFERENCES usuario(email) \r\n"
			+ "    ON UPDATE CASCADE ON DELETE CASCADE\r\n"
			+ ");";
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		initializePedidosTable();
	}
	
	private static void initializePedidosTable() { 
		try (var conn = new DatabaseConnectionFactory().factory()) {
			var ps = conn.prepareStatement(CREATE_TABLE_PEDIDO);
			ps.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
