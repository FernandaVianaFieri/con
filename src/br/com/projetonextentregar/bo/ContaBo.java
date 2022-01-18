package br.com.projetonextentregar.bo;

import java.util.Date;
import java.util.UUID;

import br.com.projetonextentregar.bean.Cliente;
import br.com.projetonextentregar.bean.Conta;
import br.com.projetonextentregar.bean.Endereco;
import br.com.projetonextentregar.bean.Pix;
import br.com.projetonextentregar.bean.TipoChavePix;
import br.com.projetonextentregar.bean.TipoCliente;
import br.com.projetonextentregar.bean.TipoConta;

public class ContaBo {

	private static int contasCriadas = 1;

	// auto incremento, gera um novo número
	private String novaConta() {
		return String.valueOf(contasCriadas++);
	}

	public Conta cadastrarConta(Cliente cliente, TipoConta tipoConta) {

		// String numConta, double saldo, Cliente cliente, TipoConta tipoConta
		Conta conta = new Conta(novaConta(), 0.0, cliente, tipoConta);

		return conta;

	}

	public void transferir(double valor, Conta conta, Conta contaDestino) {
		if (conta.getSaldo() >= valor) {
			conta.setSaldo(conta.getSaldo() - valor);
			atualizarTipo(conta);
			contaDestino.setSaldo(contaDestino.getSaldo() + valor);

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
		// String logradouro, String numero, String cep, String bairro, String cidade,
		// String estado
		Pix pix = new Pix();
		pix.ativarChave(TipoChavePix.CPF, "35874584789", true);
		Endereco endereco = new Endereco("Rua um", "23", "03641000", "Penha", "São paulo", "SP");
		Cliente cliente = new Cliente();
		cliente.setNome("Fernanda");
		cliente.setCpf("35957435985");
		cliente.setDataNascimento( "12/02/1989");
		cliente.setTipocliente(TipoCliente.PREMIUM);
		cliente.setEndereco(endereco);
		Conta conta = new Conta("1573-9", 0.0, cliente, TipoConta.CORRENTE);
		conta.setPix(pix);
		conta.setNumConta("1");
		conta.setSaldo(5000.0);
		conta.setCliente(cliente);
		return conta;
	}
	
	public void cadastraPix(TipoChavePix tipoChavePix, Conta conta) {
		conta.getPix().setTipoChave(tipoChavePix);
		
		String dado = null;
		
		if (tipoChavePix.equals(TipoChavePix.CPF)) {
			 dado = conta.getCliente().getCpf();
			
		}
		else  if (tipoChavePix.equals(TipoChavePix.EMAIL)) {
			 dado = conta.getCliente().getEmail();
			
		}
		else if (tipoChavePix.equals(TipoChavePix.TELEFONE)) {
			 dado = conta.getCliente().getTelefone();
			
		}
		else if (tipoChavePix.equals(TipoChavePix.ALEATORIO)) {
			 dado = UUID.randomUUID().toString();
								
			
		}
		
	}
		
}

 