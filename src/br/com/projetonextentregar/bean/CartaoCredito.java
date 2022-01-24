package br.com.projetonextentregar.bean;

import java.util.ArrayList;
import java.util.List;

public class CartaoCredito extends Cartao {

	private double limite;
	private Apolice apolice;
	private double valorFatura;

	private List<Compra> listCompra;

	public CartaoCredito(String bandeira, String senha, double limite) {
		super(bandeira, senha);
		this.limite = limite;
		this.valorFatura = 0;
		this.listCompra = new ArrayList<Compra>();
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public List<Compra> getListCompra() {
		return listCompra;
	}

	public void setListCompra(List<Compra> listCompra) {
		this.listCompra = listCompra;
	}

	public Apolice getApolice() {
		return apolice;
	}

	public void setApolice(Apolice apolice) {
		this.apolice = apolice;
	}

	public double getValorFatura() {
		return valorFatura;
	}

	public void setValorFatura(double valorFatura) {
		this.valorFatura = valorFatura;
	}

	
	
}
