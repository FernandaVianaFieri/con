	package br.com.next.bean;
		
	import java.util.*;
	
		public class Cliente {
	   
		private String cpf;
		private String nome;
		private String telefone;
		private String email;
		private TipoCliente tipocliente;
		private TipoConta tipoConta;		
		private Date dataNascimento;		
		private Endereco endereco;
		

		public TipoCliente getTipocliente() {
			return tipocliente;
		}


		public void setTipocliente(TipoCliente tipocliente) {
			this.tipocliente = tipocliente;
		}


		public String getNome() {
			return nome;
		}


		public void setNome(String nome) {
			this.nome = nome;
		}


		public String getCpf() {
			return cpf;
		}


		public void setCpf(String cpf) {
			this.cpf = cpf;
		}


		public Date getDataNascimento() {
			return dataNascimento;
		}


		public void setDataNascimento(Date dataNascimento) {
			this.dataNascimento = dataNascimento;
		}


		public Endereco getEndereco() {
			return endereco;
		}


		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}


		public TipoConta getTipoConta() {
			return tipoConta;
		}


		public void setTipoConta(TipoConta tipoConta) {
			this.tipoConta = tipoConta;
		}


		public String getTelefone() {
			return telefone;
		}


		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}
	
		
	
}
