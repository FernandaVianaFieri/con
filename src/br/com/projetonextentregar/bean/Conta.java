	package br.com.projetonextentregar.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Conta {
	
	protected String numConta = "1573-9";
	protected double saldo;
	protected Cliente  cliente = new Cliente();
	private TipoConta tipoConta;
	private Pix pix;
	private CartaoDebito cartaoDebito ;
	private String data;
	private CartaoCredito cartaoCredito;
			

	public Conta(String numConta, double saldo, Cliente cliente, TipoConta tipoConta) {
		this.numConta = numConta;
		this.saldo = saldo;
		this.cliente = cliente;
		this.tipoConta = tipoConta;
		this.data = dataAtual();
	}

	public String getNumConta() {
		return numConta;
	}

	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Pix getPix() {
		return pix;
	}

	public void setPix(Pix pix) {
		this.pix = pix;
	}


	public CartaoDebito getCartaoDebito() {
		return cartaoDebito;
	}

	public void setCartaoDebito(CartaoDebito cartaoDebito) {
		this.cartaoDebito = cartaoDebito;
	}

	public CartaoCredito getCartaoCredito() {
		return cartaoCredito;
			
	}
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setCartaoCredito(CartaoCredito cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}
	

	public static String dataAtual() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(Calendar.getInstance().getTime());
		}
}
