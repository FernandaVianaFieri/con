package br.com.next.bean;

import java.util.*;

import br.com.next.bo.ApoliceBo;
import br.com.next.bo.CartaoBo;
import br.com.next.bo.CartaoCredBo;
import br.com.next.bo.ClienteBo;
import br.com.next.bo.ContaBo;
import br.com.next.bo.SeguroBo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Principal {
	static Scanner sc = new Scanner(System.in);

	static Cliente cliente = new Cliente();
	static ClienteBo clienteBo = new ClienteBo();
	static ContaBo contaBo = new ContaBo();
	static TipoConta tipoConta = null;
	static String tipoChavePix = null;
	static CartaoBo cartaoBo = new CartaoBo();
	static Date data = new Date();
	static SeguroBo seguroBo = new SeguroBo();
	static ApoliceBo apoliceBo = new ApoliceBo();
	static Apolice apolice = new Apolice();
	static CartaoCredBo cartaoCredBo = new CartaoCredBo();
	static CartaoCredito cartaoCredito;
	static CartaoDebito cartaoDebito;

	static Conta conta = null;
	static Conta conta1 = null;
	static String nome = null;
	static String cpf = null;
	static double valor;
	static double deposito;
	static double saldo = 0;
	static int escolha = 0;

	public static void main(String[] args) {
		while (true) {
			System.out.println("...................... ");
			System.out.println("\nMenu Principal:\n ");
			System.out.println("...................... ");
			System.out.println(
					"Escolha a opção desejada\n1-cadastrar dados\n2-Tranferir\n3-Depositar\n4- Consultar saldo\n5-PIX\n6-Cartão");
			System.out.println("...................... ");
			escolha = sc.nextInt();
			sc.nextLine();
			if (escolha == 1) {// cadastra
				cadastrar();
				continue;
			} else if (escolha == 2) {// transferir
				transferir();
				continue;
			} else if (escolha == 3) {// deposito
				depositar();
				continue;
			} else if (escolha == 4) {// saldo
				consultaSaldo();
				continue;
			} else if (escolha == 5) {// pix
				exibePix();
				continue;
			}

			else if (escolha == 6) {// cartão
				exibeCartao();
			}

			else if (escolha == 0) {
				break;

			}
		}

	}

	// menu bandeiras do cartão
	private static void exibeCartao() {
		System.out.print("Selecione a opção  1- Cadastrar Cartão  2-Consultar Cartão ");
		String resposta = sc.nextLine();
		if (resposta.equals("1")) {
			System.out.print("Selecione a bandeira do cartão \n1- Master  \n2-Visa  \n3-Cielo");
			String opcao = sc.nextLine();
			String bandeira = null;

			if (opcao.equals("1")) {
				bandeira = "Master";

			} else if (opcao.equals("2")) {
				bandeira = "Vista";
			} else {
				bandeira = "Cielo";

			}
			// Senha
			System.out.println("...................... ");
			System.out.print("Cadastre seua senha com 4 digitos\n");
			System.out.println("...................... ");
			String senha = sc.nextLine();

			// Escolher cartão
			System.out.println("...................... ");
			System.out.println("1-Cartão de Crédito\n2-Cartão de Débito\n");
			System.out.println("...................... ");
			System.out.print("Digite o tipo de cartão :\n ");
			String escolhaCartao = sc.nextLine();
			String tipoCartao = null;

			if (escolhaCartao.equals("1")) {
				System.out.println("Cartão de Crédito");

				// String bandeira, String senha, double limite

				cartaoCredito = new CartaoCredito(bandeira, senha, cartaoBo.retornaLimite(conta.getCliente()));
				conta.setCartaoCredito(cartaoCredito);

			} else {

				System.out.println("Cartão de Débito");
				System.out.print("Digite o limite por transação ");
				Double limite = sc.nextDouble();

				// String bandeira, String senha, double limiteS
				cartaoDebito = new CartaoDebito(bandeira, senha, limite);
				conta.setCartaoDebito(cartaoDebito);
				System.out.println("...................... ");
				System.out
						.println("Número do Cartão: " + cartaoDebito.getNumero() + "\nTipo de cartão: " + escolhaCartao
								+ "\nBandeira: " + bandeira + "\nLimite: " + cartaoDebito.getLimiteTransacao() + "\n");
				System.out.println("...................... ");
			}

		} else {
			menuCartao();
		}

	}

	public static void operacaoPrincipal() {

	}

	// menu pix
	private static void exibePix() {
		System.out.println("...................... ");
		System.out.println("1-Cadastrar chave\n2-Transferir via Pix");
		System.out.println("...................... ");
		System.out.print("Escolha a opção: ");
		String op = sc.nextLine();
		if (op.equals("1")) {// cadastra chave pix

			System.out.println("1- Aleatória\n 2-CPF\n 3-telefone \n 4-e-mail ");

			Pix pix = new Pix();
			System.out.print("Escolha o tipo de chave: ");
			int opcaoPix = sc.nextInt();
			sc.nextLine();

			// CPF, EMAIL, TELEFONE, ALEATORIO;
			if (opcaoPix == 1) {
				pix.ativarChave(TipoChavePix.ALEATORIO, "", true);
				conta.setPix(pix);

			}

			else if (opcaoPix == 2) {
				pix.ativarChave(TipoChavePix.CPF, cliente.getCpf(), true);
				conta.setPix(pix);
			}

			else if (opcaoPix == 3) {
				pix.ativarChave(TipoChavePix.TELEFONE, cliente.getTelefone(), true);
				conta.setPix(pix);

			}

			else if (opcaoPix == 4) {
				pix.ativarChave(TipoChavePix.EMAIL, cliente.getEmail(), true);
				conta.setPix(pix);
			} else {
				System.out.println("Escolha inválida");

			}

			System.out.println("Chave cadastrada com sucesso\n Tipo de chave: " + pix.getTipoChave()
					+ " Conteudo chave: " + pix.getConteudoChave());

		}

		else if (op.equals("2")) {// trasnfere via pix
			System.out.println("qual o valor a transferir: ");
			Double valorTransf = Double.parseDouble(sc.nextLine());
			if (conta.getSaldo() >= valorTransf) {
				System.out.print("Digite a chave do destinatário: ");
				String chave = sc.nextLine();

				if (conta1.getPix().getConteudoChave().equals(chave)) {
					conta.setSaldo(conta.getSaldo() - valorTransf);
					conta1.setSaldo(conta1.getSaldo() + valorTransf);
					System.out.println("\nTranferênvia via pix para " + conta1.getCliente().getNome()
							+ " realizada com sucesso\n  ");
				} else {
					System.out.println("Chave pix não encontrada ");
				}
			} else {
				System.out.println("Você não possui saldo");
			}

		}
	}

	private static void consultaSaldo() {
		System.out.println("Seu saldo é : " + contaBo.consultaSaldo(conta));
		System.out.println("Tipo de cliente: " + conta1.getCliente().getTipocliente());
		System.out.println("\n ");
	}

	private static void depositar() {
		System.out.println("Qual valor de deposito ?  ");
		deposito = sc.nextDouble();
		contaBo.deposito(deposito, conta);
		System.out.println("\n depósito feito com sucesso\n");

	}

	private static void transferir() {
		System.out.println("Qual valor a transferir?  ");
		valor = sc.nextDouble();
		contaBo.transferir(valor, conta, conta1);
		System.out.println("\nTransferência feita com sucesso\n");

	}

	// CADASTRAR
	public static void cadastrar() {
		System.out.println("Digite seu nome para cadastro: ");
		nome = sc.nextLine();

		// converter data de String para data

		System.out.println("Digite sua data de nascimento: ");
		String dataNascimento = sc.nextLine();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {

			data = formato.parse(dataNascimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		System.out.println("Digite seu e-mail:  ");
		String email = sc.nextLine();

		System.out.println("seu o numero de telefone : ");
		String telefone = sc.nextLine();
		while ((telefone).length() != 9) {
			System.out.println("Número de telefone inválido\n Digite novamente");
			telefone = sc.nextLine();
		}

		System.out.println("Digite seu cpf com 11 digitos, somente números: ");
		cpf = sc.nextLine();
		while (cpf.length() != 11) {
			System.out.println("Número inválido\n Digite novamente");
			cpf = sc.nextLine();

		}
		// String logradouro, String numero, String cep, String bairro, String cidade,
		// String estado
		System.out.println("Digite o nome da rua: ");
		String logradouro = sc.nextLine();

		System.out.println("Digite o numero da casa: ");
		String numero = sc.nextLine();

		System.out.println("Digite o cep da rua: ");
		String cep = sc.nextLine();

		System.out.println("Digite o bairro: ");
		String bairro = sc.nextLine();

		System.out.println("Digite a cidade: ");
		String cidade = sc.nextLine();

		System.out.println("Digite o estado: ");
		String estado = sc.nextLine();

		// tipo de conta a escolher
		System.out.println("...................... ");
		System.out.println("1-Conta Corrente\n2-Conta Poupança\n");
		System.out.println("...................... ");
		System.out.print("Digite o tipo da conta : ");
		int escolhaConta = sc.nextInt();

		if (escolhaConta == 1) {

			tipoConta = TipoConta.CORRENTE;
		} else {
			tipoConta = TipoConta.POUPANCA;
		}

		Endereco endereco = new Endereco(logradouro, numero, cep, bairro, cidade, estado);

		cliente = clienteBo.cadastrarDados(cpf, nome, endereco, tipoConta, data, telefone, email);
		conta = contaBo.cadastrarConta(cliente, tipoConta);
		conta1 = ContaBo.criarContaEstatica();
		System.out.println("...................... ");
		System.out.println(
				"\nCliente cadastrado com sucesso!!!!!!\n" + "Nome do cliente:  " + conta.getCliente().getNome() + "\n"
						+ "Número conta: " + conta.getNumConta() + "\n" + "Tipo de conta: " + conta.getTipoConta());
		System.out.println("...................... ");

	}

	public static void menuCartao() {

		int opCompra;
		System.out.println("...................... ");
		System.out.println("1-Seguro\n2-Compras\n3-Informações do cartão\n4-Exibir fatura");
		System.out.println("...................... ");
		opCompra = sc.nextInt();

		if (opCompra == 1) {
			System.out.println("...................... ");
			System.out.println(	"Deseja contratar um seguro?\n 1- Seguro de Morte\n2- Seguro Invalidez\n3- Seguro Desemprego\n4 - Não desejo contratar seguro");
			System.out.println("...................... ");
			sc.nextLine();
			String contratarSeguro = sc.nextLine();
			HashMap<TipoSeguro, Seguro> seguros = new HashMap();
			seguros = seguroBo.popularSeguros();
			Seguro seguro = new Seguro();

			if (contratarSeguro.equals("1")) {
				seguro = seguros.get(TipoSeguro.MORTE);
				
			}

			else if (contratarSeguro.equals("2")) {
				seguro = seguros.get(TipoSeguro.INVALIDEZ);
				
			}

			else if (contratarSeguro.equals("3")) {
				seguro = seguros.get(TipoSeguro.DESEMPREGO);
				
			}

			System.out.println("Detalhes do seguro: ");
			System.out.println("Valor: R$ " + seguro.getValor());
			System.out.println("Regras:  " + seguro.getRegras());

			// opção de fechar o seguro
			System.out.println("...................... ");
			System.out.println("Deseja realmente contratar o seguro?\n 1-Sim \n2-Não");
			String fecharSeguro = sc.nextLine();
			System.out.println("...................... ");

			if (fecharSeguro.equals("1")) {
				apolice = apoliceBo.salvarApolice(seguro);
				conta.getCartaoCredito().setApolice(apolice);
				System.out.println("Datas final da carência:  " + apolice.getDataCarencia() +" Data da assinatura " + apolice.getDataAssinatura());
				System.out.println("Seguro contratado com seucesso!!!!!");

			}
		} else if (opCompra == 2) {
			System.out.println("Digite o valor da compra: ");
			double valor = sc.nextDouble();
			boolean retorno = cartaoCredBo.compraCredito(valor, conta);

			if (retorno) {
				System.out.println("Compra efetuada com sucesso");
			} else {
				System.out.println("Limite do cartão atingido ");
			}

		} else if (opCompra == 3) {
			System.out.println("Número do Cartão: " + conta.getCartaoCredito().getNumero() + "Bandeira: "
					+ conta.getCartaoCredito().getBandeira() + "\nLimite: " + conta.getCartaoCredito().getLimite());
		}

		else if (opCompra == 4) {
			SimpleDateFormat sdfComHora = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
			List<Compra> listaCompra = conta.getCartaoCredito().getListCompra();
			for (Compra compras : listaCompra) {
				String dataCompra = sdfComHora.format(compras.getDataCompra());
				double valorCompra = compras.getValorCompra();
				System.out.println("Compra realizada no dia: " + dataCompra + "No valor de : " + valorCompra);
			}

		}
	}
}
