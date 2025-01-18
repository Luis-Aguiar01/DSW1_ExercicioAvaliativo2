package br.edu.ifsp.dsw.model.dao.pedidos;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dsw.model.dao.connection.DatabaseConnectionFactory;
import br.edu.ifsp.dsw.model.dao.user.UsuarioDao;
import br.edu.ifsp.dsw.model.entity.Pedido;

class PedidoDaoImp implements PedidoDao {
	
	private static final String CREATE_PEDIDO_SQL = "INSERT INTO pedido (endereco_entrega, valor, descricao, email_usuario) VALUES (?, ?, ?, ?)";
	private static final String DELETE_PEDIDO_SQL = "DELETE FROM pedido WHERE id_pedido = ?";
	private static final String UPDATE_PEDIDO_SQL =  "UPDATE pedido SET endereco_entrega = ?, valor = ?, descricao = ? WHERE id_pedido = ?";
	private static final String GET_ALL_PEDIDO_SQL = "SELECT id_pedido, endereco_entrega, valor, descricao, email_usuario FROM pedido";
	private static final String GET_ALL_PEDIDO_BY_EMAIL = "SELECT id_pedido, endereco_entrega, valor, descricao, email_usuario FROM pedido WHERE email_usuario = ?";
	private static final String FIND_PEDIDO_BY_ID = "SELECT id_pedido, endereco_entrega, valor, descricao, email_usuario FROM pedido WHERE id_pedido = ?";
	
	private UsuarioDao usuarioDao;
	
	public PedidoDaoImp(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
	@Override
	public boolean create(Pedido pedido) {
		int result = 0;
		
		if (pedido != null) {
			try (var conn = new DatabaseConnectionFactory().factory()) {
				var ps = conn.prepareStatement(CREATE_PEDIDO_SQL);
				ps.setString(1, pedido.getEnderecoEntrega());
				ps.setDouble(2, pedido.getPrice());
				ps.setString(3, pedido.getDescricao());
				ps.setString(4, pedido.getUsuario().getEmail());
				
				result = ps.executeUpdate();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result > 0;
	}

	@Override
	public boolean delete(int idPedido) {
		int result = 0;
		
		try (var conn = new DatabaseConnectionFactory().factory()) {
			var ps = conn.prepareStatement(DELETE_PEDIDO_SQL);
			ps.setInt(1, idPedido);
			
			result = ps.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return result > 0;
	}

	@Override
	public boolean update(int idPedido, Pedido newPedidoData) {
		int result = 0;
		
		if (newPedidoData != null) {
			try (var conn = new DatabaseConnectionFactory().factory()) {
				var ps = conn.prepareStatement(UPDATE_PEDIDO_SQL);
				ps.setString(1, newPedidoData.getEnderecoEntrega());
				ps.setDouble(2, newPedidoData.getPrice());
				ps.setString(3, newPedidoData.getDescricao());
				ps.setInt(4, idPedido);
				
				result = ps.executeUpdate();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return result > 0;
	}

	@Override
	public List<Pedido> getAll() {
		var pedidos = new ArrayList<Pedido>();
		
		try (var conn = new DatabaseConnectionFactory().factory()) {
			var ps = conn.prepareStatement(GET_ALL_PEDIDO_SQL);
			var rs = ps.executeQuery();
			
			while (rs.next()) {
				var pedido = new Pedido();
				pedido.setDescricao(rs.getString("descricao"));
				pedido.setEnderecoEntrega(rs.getString("endereco_entrega"));
				pedido.setIdPedido(rs.getInt("id_pedido"));
				pedido.setPrice(rs.getDouble("valor"));
				
				var user = usuarioDao.findByEmail(rs.getString("email_usuario"));
				pedido.setUsuario(user);
				
				pedidos.add(pedido);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return pedidos;
	}

	@Override
	public List<Pedido> getAllByEmail(String email) {
var pedidos = new ArrayList<Pedido>();
		
		try (var conn = new DatabaseConnectionFactory().factory()) {
			var ps = conn.prepareStatement(GET_ALL_PEDIDO_BY_EMAIL);
			ps.setString(1, email);
			var rs = ps.executeQuery();
			
			while (rs.next()) {
				var pedido = new Pedido();
				pedido.setDescricao(rs.getString("descricao"));
				pedido.setEnderecoEntrega(rs.getString("endereco_entrega"));
				pedido.setIdPedido(rs.getInt("id_pedido"));
				pedido.setPrice(rs.getDouble("valor"));
				
				var user = usuarioDao.findByEmail(rs.getString("email"));
				pedido.setUsuario(user);
				
				pedidos.add(pedido);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return pedidos;
	}

	@Override
	public Pedido findById(int id) {
		Pedido pedido = null;
		
		try (var conn = new DatabaseConnectionFactory().factory()) {
			var ps = conn.prepareStatement(FIND_PEDIDO_BY_ID);
			ps.setInt(1, id);
			
			var rs = ps.executeQuery();
			
			if (rs.next()) {
				pedido = new Pedido();
				pedido.setDescricao(rs.getString("descricao"));
				pedido.setEnderecoEntrega(rs.getString("endereco_entrega"));
				pedido.setIdPedido(rs.getInt("id_pedido"));
				pedido.setPrice(rs.getDouble("valor"));
				
				var user = usuarioDao.findByEmail(rs.getString("email_usuario"));
				pedido.setUsuario(user);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return pedido;
	}
}
