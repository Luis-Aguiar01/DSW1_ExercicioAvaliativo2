package br.edu.ifsp.dsw.model.dao.pedidos;

import java.util.List;

import br.edu.ifsp.dsw.model.entity.Pedido;

public interface PedidoDao {
	
	boolean create(Pedido pedido);
	
	boolean delete(int idPedido);
	
	boolean update(int idPedido, Pedido newPedidoData);
	
	List<Pedido> getAll();
	
	List<Pedido> getAllByEmail(String email);
	
}
