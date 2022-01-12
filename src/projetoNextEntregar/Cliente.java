	package projetoNextEntregar;
		
	import java.util.*;
	
		public class Cliente {
	   
		private String cpf;
		private String nome;
		private TipoCliente tipocliente;
		
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
	
}
