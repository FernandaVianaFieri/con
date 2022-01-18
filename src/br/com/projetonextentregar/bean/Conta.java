	package br.com.projetonextentregar.bean;
	
	public class Conta {
	
	protected String numConta = "1573-9";
	protected double saldo;
	protected Cliente  cliente = new Cliente();
	private TipoConta tipoConta;
	private Pix pix;
	private Cartao cartao ;
	private CartaoCredito cartaoCredito;
			

	public Conta(String numConta, double saldo, Cliente cliente, TipoConta tipoConta) {
		this.numConta = numConta;
		this.saldo = saldo;
		this.cliente = cliente;
		this.tipoConta = tipoConta;
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

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public CartaoCredito getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(CartaoCredito cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}
	


}
