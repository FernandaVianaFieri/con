package br.com.projetonextentregar.bean;

import java.util.UUID;

public class Cartao {

	private static String numero;
	private String bandeira;
	private String senha;
	private boolean ativo;
	
	public Cartao( String bandeira, String senha) {
		this.numero = UUID.randomUUID().toString();
		this.bandeira = bandeira;
		this.senha = senha;
		this.ativo = true;
	}

	public    String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
	
	
}
