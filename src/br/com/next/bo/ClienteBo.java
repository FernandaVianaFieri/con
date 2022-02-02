package br.com.next.bo;

import java.util.Date;

import br.com.next.bean.Cliente;
import br.com.next.bean.Endereco;
import br.com.next.bean.TipoChavePix;
import br.com.next.bean.TipoCliente;
import br.com.next.bean.TipoConta;



public class ClienteBo {

	public Cliente cadastrarDados(String cpf, String nome,  Endereco enderco, TipoConta tipoConta,  Date dataNascimento, String telefone, String email) {
		Cliente cliente = new Cliente();
		 
			cliente.setCpf(cpf);
			cliente.setNome(nome); 
			cliente.setDataNascimento(dataNascimento);
			cliente.setTelefone(telefone);
			cliente.setEmail(email);
			cliente.setEndereco(enderco);
		    cliente.setTipocliente(TipoCliente.COMUM);
		    cliente.setTipoConta(tipoConta);
		    		    
				 		
		    return cliente;
		   }

	
	}
	
	

