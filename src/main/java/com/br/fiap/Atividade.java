package com.br.fiap;

public class Atividade {
	private int codigoAtividade;
	
	private String tipoAtividade;
	
	private int quantidadeSemana;
	
	private String calorias;
	
	public Atividade() {
		super();
	}
	
	public Atividade(int codigoAtividade, String tipoAtividade, int quantidadeSemana, String calorias) {
		super();
		this.codigoAtividade = codigoAtividade;
		this.tipoAtividade = tipoAtividade;
		this.quantidadeSemana = quantidadeSemana;
		this.calorias = calorias;
	}
	
	public int getCodigoAtividade() {
		return codigoAtividade;
	}
	
	public void setCodigoAtividade(int codigoAtividade) {
		this.codigoAtividade = codigoAtividade;
	}
	
	public String getTipoAtividade() {
		return tipoAtividade;
	}
	
	public void setTipoAtividade(String tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}
	
	public int getQuantidadeSemana() {
		return quantidadeSemana;
	}
	
	public void setQuantidadeSemana(int quantidadeSemana) {
		this.quantidadeSemana = quantidadeSemana;
	}
	
	public String getCalorias() {
		return calorias;
	}
	
	public void setCalorias(String calorias) {
		this.calorias = calorias;
	}
}
