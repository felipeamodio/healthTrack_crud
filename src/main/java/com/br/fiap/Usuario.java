package com.br.fiap;

public class Usuario {
	
	private String codUsuario;
	
	private int idUsuario;
	
	private String nomeUsuario;
	
	private String peso;
	
	private String altura;
	
	private String tipoAtividade;
	
	private int qtdDiasSemana;
	
	private int calorias;
	
	public Usuario() {
		super();
	}
	
	public Usuario(String codUsuario, int idUsuario, String nomeUsuario, String peso, String altura, String tipoAtividade, int qtdDiasSemana, int calorias) {
		super();
		this.codUsuario = codUsuario;
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.peso = peso;
		this.altura = altura;
		this.tipoAtividade = tipoAtividade;
		this.qtdDiasSemana = qtdDiasSemana;
		this.calorias = calorias;
	}
	
	public String getCodUsuario() {
		return codUsuario;
	}
	
	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	
	public String getPeso() {
		return peso;
	}
	
	public void setPeso(String peso) {
		this.peso = peso;
	}
	
	public String getAltura() {
		return altura;
	}
	
	public void setAltura(String altura) {
		this.altura = altura;
	}
	
	public String getTipoAtividade() {
		return tipoAtividade;
	}
	
	public void setTipoAtividade(String tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}
	
	public int getQtdDiasSemana() {
		return qtdDiasSemana;
	}
	
	public void setQtdDiasSemana(int qtdDiasSemana) {
		this.qtdDiasSemana = qtdDiasSemana;
	}
	
	public int getCalorias() {
		return calorias;
	}
	
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	
	
}
