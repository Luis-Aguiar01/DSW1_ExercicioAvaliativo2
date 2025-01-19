package br.edu.ifsp.dsw.model.dao.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionFactory {
	
	private DatabaseType type;
	
	public DatabaseConnectionFactory() {
		this.type = DatabaseType.POSTGRE;
	}
	
	public DatabaseConnectionFactory(DatabaseType type) {
		this.type = type;
	}
	
	public DatabaseType getType() {
		return type;
	}
	
	public Connection factory() throws SQLException {
		switch (type) {
			case MYSQL:
				return MySqlDatabaseConnection.getConnection();
			case POSTGRE:
				return PostgreDatabaseConnection.getConnection();
			default:
				throw new IllegalArgumentException("Valor da conexão inválida.");
		}
	}
	
	public enum DatabaseType {
		MYSQL, POSTGRE
	}
}
