package projetoNextEntregar.bo;

import projetoNextEntregar.Cliente;
import projetoNextEntregar.Conta;
import projetoNextEntregar.TipoCliente;

public class ContaBo {

	public Conta cadastrarConta(String numConta,  Cliente cliente ) {
		Conta conta = new Conta();
		conta.setCliente(cliente);
		conta.setNumConta(numConta);
		conta.setSaldo(0);
		 return conta;
		 
		 
	}	
	public void transferir(double valor, Conta conta) {
		if (conta.getSaldo() >= valor) {
			conta.setSaldo(conta.getSaldo() - valor); 
			atualizarTipo(conta);
			
		}
		
		else {
			System.out.println("Saldo Insuficiente");
		}	
	}
	
	public void deposito (double valor, Conta conta ) {
		conta.setSaldo(conta.getSaldo() +valor); 
		
		atualizarTipo(conta);
		
	}
	
	public double consultaSaldo(Conta conta) {
		
		return conta.getSaldo();
	}
	
	public void atualizarTipo (Conta conta) {
		if (conta.getSaldo() < 5000) {
			conta.getCliente().setTipocliente(null);
		}
		else if (conta.getSaldo() >= 15000) {
			conta.setCliente(TipoCliente.PREMIUM);
		}
		else {
			conta.setCliente(TipoCliente.SUPER);
		}
			
		
		
	}
}
