package projetoNextEntregar.bo;

import projetoNextEntregar.Cliente;
import projetoNextEntregar.TipoCliente;

public class ClienteBo {

	public Cliente cadastrarDados(String cpf, String nome) {
		Cliente cliente = new Cliente();
		 
			cliente.setCpf(cpf);
			cliente.setNome(nome); 
		    cliente.setTipocliente(TipoCliente.COMUM);
		
		 
			
		
		    return cliente;
	}
	
	
}
