package br.com.projetonextentregar.bean;

public class CartaoCredito {

	String id;
	double limite;
	double valorFatura;
	
	
	public CartaoCredito(String id, double limite, double valorFatura) {
    	this.id = id;
		this.limite = limite;
		this.valorFatura = valorFatura;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public double getLimite() {
		return limite;
	}


	public void setLimite(double limite) {
		this.limite = limite;
	}


	public double getValorFatura() {
		return valorFatura;
	}


	public void setValorFatura(double valorFatura) {
		this.valorFatura = valorFatura;
	}
	
	
}
