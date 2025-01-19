package br.edu.ifsp.dsw.model.entity;

public class Pedido {
	private int idPedido;
	private String enderecoEntrega;
	private String nomeCliente;
	private double price;
	private String descricao;
	private Usuario usuario;
	
	public Pedido() {}

	public Pedido(String enderecoEntrega, double price, String descricao, Usuario usuario, String nomeCliente) {
		super();
		this.enderecoEntrega = enderecoEntrega;
		this.price = price;
		this.descricao = descricao;
		this.usuario = usuario;
		this.nomeCliente = nomeCliente;
	}

	public Pedido(int idPedido, String enderecoEntrega, double price, String descricao, Usuario usuario, String nomeCliente) {
		this(enderecoEntrega, price, descricao, usuario, nomeCliente);
		this.idPedido = idPedido;
	}

	public int getIdPedido() {
		return idPedido;
	}
	
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}
	
	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
}
