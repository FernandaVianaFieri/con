	package br.com.projetonextentregar.bean;
	
	public class Conta {
	
	protected String numConta = "1573-9";
	protected double saldo;
	protected Cliente  cliente = new Cliente();
	
		

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
	
}
