package br.com.projetonextentregar.bo;

import java.util.Date;

import br.com.projetonextentregar.bean.Cliente;
import br.com.projetonextentregar.bean.Conta;
import br.com.projetonextentregar.bean.Endereco;
import br.com.projetonextentregar.bean.TipoCliente;

public class ContaBo {

	public Conta cadastrarConta(String numConta, Cliente cliente) {
		Conta conta = new Conta();
		conta.setCliente(cliente);
		conta.setNumConta(numConta);
		conta.setSaldo(0);
		return conta;

	}

	public void transferir(double valor, Conta conta, Conta contaDestino) {
		if (conta.getSaldo() >= valor) {
			conta.setSaldo(conta.getSaldo() - valor);
			atualizarTipo(conta);
			contaDestino.setSaldo(contaDestino.getSaldo()+ valor);

		}

		else {
			System.out.println("Saldo Insuficiente");
		}
	}

	public void deposito(double valor, Conta conta) {
		conta.setSaldo(conta.getSaldo() + valor);

		atualizarTipo(conta);

	}

	public double consultaSaldo(Conta conta) {

		return conta.getSaldo();
	}

	public void atualizarTipo(Conta conta) {
		if (conta.getSaldo() < 5000) {
			conta.getCliente().setTipocliente(TipoCliente.COMUM);
		} else if (conta.getSaldo() >= 15000) {
			conta.getCliente().setTipocliente(TipoCliente.PREMIUM);
		} else {
			conta.getCliente().setTipocliente(TipoCliente.SUPER);
		}

	}

	public static Conta criarContaEstatica() {
		// String logradouro, String numero, String cep, String bairro, String cidade, String estado
		Endereco endereco = new Endereco ("Rua um", "23", "03641000", "Penha", "São paulo", "SP");
		Cliente cliente = new Cliente();
		cliente.setNome("Fernanda");
		cliente.setCpf("35957435985");
		cliente.setDataNascimento(new Date());
		cliente.setTipocliente(TipoCliente.PREMIUM);
		cliente.setEndereco(endereco);
		Conta conta = new Conta ();
		conta.setNumConta("1");
		conta.setSaldo(5000.0);
		conta.setCliente(cliente);
		return conta;
	}
}
