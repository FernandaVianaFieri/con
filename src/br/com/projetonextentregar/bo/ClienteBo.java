package br.com.projetonextentregar.bo;

import br.com.projetonextentregar.bean.Cliente;
import br.com.projetonextentregar.bean.Endereco;
import br.com.projetonextentregar.bean.TipoCliente;



public class ClienteBo {

	public Cliente cadastrarDados(String cpf, String nome, Endereco enderco) {
		Cliente cliente = new Cliente();
		 
			cliente.setCpf(cpf);
			cliente.setNome(nome); 
		    cliente.setTipocliente(TipoCliente.COMUM);
		    
				 		
		    return cliente;
		   }
	
	
}
