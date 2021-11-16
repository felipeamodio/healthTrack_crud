package com.br.fiap;

public class Cadastro {
	private String codigoCadastro;
	
	private int idUsuario;
	
	private String dataNascimento;
	
	private String email;
	
	private String senha;
	
	public Cadastro() {
		super();
	}
	
	public Cadastro(String codigoCadastro, int idUsuario, String dataNascimento, String email, String senha) {
		super();
		this.codigoCadastro = codigoCadastro;
		this.idUsuario = idUsuario;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.senha = senha;
	}
	
	public String getCodigoCadastro() {
		return codigoCadastro;
	}
	
	public void setCodigoCadastro(String codigoCadastro) {
		this.codigoCadastro = codigoCadastro;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
