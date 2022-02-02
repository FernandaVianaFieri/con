package br.com.next.bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import br.com.next.bean.Cliente;
import br.com.next.bean.Conta;
import br.com.next.bean.Endereco;
import br.com.next.bean.Pix;
import br.com.next.bean.TipoChavePix;
import br.com.next.bean.TipoCliente;
import br.com.next.bean.TipoConta;

public class ContaBo {

	private static int contasCriadas = 1;
	static Date data = new Date();
	

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
		taxaRendimento(conta);// taxando conta corrente e/ou rendendo conta poupança
		

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
		
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {
					
		data = formato.parse("12/02/1989");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		cliente.setDataNascimento(data);
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

		} else if (tipoChavePix.equals(TipoChavePix.EMAIL)) {
			dado = conta.getCliente().getEmail();

		} else if (tipoChavePix.equals(TipoChavePix.TELEFONE)) {
			dado = conta.getCliente().getTelefone();

		} else if (tipoChavePix.equals(TipoChavePix.ALEATORIO)) {
			dado = UUID.randomUUID().toString();

		}

	}

	public void taxaRendimento(Conta conta) {
		if (conta.getData().equals(Conta.dataAtual())) {
			if (conta.getTipoConta().name().equals("CORRENTE")) {
				
				double valor = conta.getSaldo();
				double taxa = valor * (0.45 / 100);
				valor -= taxa;
				System.out.println("Taxando: " + (taxa));
				conta.setSaldo(valor);
				conta.setData(getDateAdd1Month());
				System.out.println("Próximo mês de cobrança: " + conta.getData());
				
			} else {
				double valor = conta.getSaldo();
				double taxa = valor * (0.03 / 100);
				valor += taxa;
				System.out.println("Rendendo: " + (taxa));
				conta.setSaldo(valor);
				conta.setData(getDateAdd1Month());
				System.out.println("Próximo mês de cobrança: " + conta.getData());
			}
		}
		

	}

	public static String getDateAdd1Month() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		return sdf.format(calendar.getTime());
	}

	
}
