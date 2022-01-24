package br.com.projetonextentregar.bean;

import java.util.Date;

public class Apolice {

	private String id;
	private double valorApolice;
	private String condicoes;
	private Seguro seguro;
	private Date dataAssinatura;
	private Date dataCarencia;
	
	
	
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
	public Date getDataAssinatura() {
		return dataAssinatura;
	}
	public void setDataAssinatura(Date dataAssinatura) {
		this.dataAssinatura = dataAssinatura;
	}
	public Date getDataCarencia() {
		return dataCarencia;
	}
	public void setDataCarencia(Date dataCarencia) {
		this.dataCarencia = dataCarencia;
	}
	
	
}
