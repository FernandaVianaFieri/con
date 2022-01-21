package br.com.projetonextentregar.bean;

public class Apolice {

	private String id;
	private double valorApolice;
	private String condicoes;
	private Seguro seguro;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getValorApolice() {
		return valorApolice;
	}
	public void setValorApolice(double valorApolice) {
		this.valorApolice = valorApolice;
	}
	public String getCondicoes() {
		return condicoes;
	}
	public void setCondicoes(String condicoes) {
		this.condicoes = condicoes;
	}
	public Seguro getSeguro() {
		return seguro;
	}
	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}
	
	
}
