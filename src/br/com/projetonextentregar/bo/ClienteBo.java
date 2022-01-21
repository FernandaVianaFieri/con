package br.com.projetonextentregar.bo;

import java.util.Date;

import br.com.projetonextentregar.bean.Cliente;
import br.com.projetonextentregar.bean.Endereco;
import br.com.projetonextentregar.bean.TipoChavePix;
import br.com.projetonextentregar.bean.TipoCliente;
import br.com.projetonextentregar.bean.TipoConta;



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
	
	

