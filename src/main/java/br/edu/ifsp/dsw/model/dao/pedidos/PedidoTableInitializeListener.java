package br.edu.ifsp.dsw.model.dao.pedidos;

import br.edu.ifsp.dsw.model.dao.connection.DatabaseConnectionFactory;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

// Esse listener serve para executar um código sempre que a aplicação é inicializada ou finalizada.
// No caso, usei o método "contextInitialized" para criar a tabela assim que a aplicação se inicia.
// Não pude usar o auto_increment por conta das diferenças de fazer isso entre o MySQL e o Postgres.
// Também não encontrei uma forma prática de criar o schema do banco de dados, então ainda é preciso criá-lo.
// Além disso, tentei usar uma anotação chamada Priority, para definir que o litener da tabela de usuário fosse
// executado primeiro que o listener da tabela de pedidos, porém, não funcionou, então tive que configurar a
// ordem no XML.

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
		try (var conn = new DatabaseConnectionFactory().factory();
				 var ps = conn.prepareStatement(CREATE_TABLE_PEDIDO)) {
				ps.execute();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
}
