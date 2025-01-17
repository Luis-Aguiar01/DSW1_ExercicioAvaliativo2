package br.edu.ifsp.dsw.model.dao.user;

public class UsuarioDaoFactory {
	
	private UsuarioDaoType type;
	
	public UsuarioDaoFactory() {
		this.type = UsuarioDaoType.DATABASE;
	}
	
	public UsuarioDaoFactory(UsuarioDaoType type) {
		this.type = type;
	}
	
	public UsuarioDao factory() {
		switch (type) {
			case DATABASE:
				return new UsuarioDaoImp();
			default:
				throw new IllegalArgumentException("Valor inválido.");
		}
	}
	
	public enum UsuarioDaoType {
		DATABASE
	}
}
