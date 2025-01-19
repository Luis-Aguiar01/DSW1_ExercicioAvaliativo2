package br.edu.ifsp.dsw.model.entity;

public class Usuario {
	private String email;
	private String nome;
	private String password;
	
	public Usuario() {
		super();
	}

	public Usuario(String email, String password, String nome) {
		super();
		this.email = email;
		this.password = password;
		this.nome = nome;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nome=" + nome + ", password=" + password + "]";
	}
}
