package br.com.projetonextentregar.bean;

import java.util.*;

public class Compra {

	private String id;
	 private double valorCompra;
		Date dataCompra;
	
		
	
	public Compra (double valorCompra, Date dataCompra) {
		this.valorCompra = valorCompra;
		this.id = UUID.randomUUID().toString();
		this.dataCompra = dataCompra;
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getCompra() {
		return valorCompra;
	}
	public void setCompra(double compra) {
		this.valorCompra = compra;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}
	
	
}
