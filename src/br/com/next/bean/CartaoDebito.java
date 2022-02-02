package br.com.next.bean;

import java.util.ArrayList;
import java.util.List;

public class CartaoDebito extends Cartao {

	private double limiteTransacao;

	private List<Compra> listCompra;

	public CartaoDebito(String bandeira, String senha, double limite) {
		super(bandeira, senha);
		this.limiteTransacao = limite;
		this.listCompra = new ArrayList<Compra>();
	}

	public double getLimiteTransacao() {
		return limiteTransacao;
	}

	public void setLimiteTransacao(double limiteTransacao) {
		this.limiteTransacao = limiteTransacao;
	}

	public List<Compra> getListCompra() {
		return listCompra;
	}

	public void setListCompra(List<Compra> listCompra) {
		this.listCompra = listCompra;
	}

}
