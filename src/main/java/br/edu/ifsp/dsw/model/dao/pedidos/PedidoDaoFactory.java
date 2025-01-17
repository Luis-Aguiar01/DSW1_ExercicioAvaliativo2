package br.edu.ifsp.dsw.model.dao.pedidos;

import br.edu.ifsp.dsw.model.dao.user.UsuarioDaoFactory;

public class PedidoDaoFactory {
	
	private PedidoDaoType type;
	
	public PedidoDaoFactory() {
		this.type = PedidoDaoType.DATABASE;
	}
	
	public PedidoDaoFactory(PedidoDaoType type) {
		this.type = type;
	}
	
	public PedidoDao factory() {
		switch (type) {
			case DATABASE:
				return new PedidoDaoImp(new UsuarioDaoFactory().factory());
			default:
				throw new IllegalArgumentException("Tipo de dado inválido");
		}
	}
	
	public enum PedidoDaoType {
		DATABASE
	}
}
