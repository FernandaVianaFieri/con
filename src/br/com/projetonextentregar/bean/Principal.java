package br.com.projetonextentregar.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import br.com.projetonextentregar.bo.ClienteBo;
import br.com.projetonextentregar.bo.ContaBo;

public class Principal {
	static Scanner sc= new Scanner(System.in);
	
	static Cliente cliente = new Cliente();
	static ClienteBo clienteBo = new ClienteBo();
	static ContaBo contaBo = new ContaBo();
	static TipoConta tipoConta = null;		
	static String tipoChavePix = null;
	
	static Conta conta = null;
	static Conta conta1 = null;
	static String nome = null;
	static String cpf = null;
	static double valor;
	static double deposito;
	static double saldo = 0;
	static int escolha  = 0;
	

	public static void main(String[] args) {
		while(true) {
			System.out.println("Escolha a opção desejada\n1-cadastrar dados\n2-Tranferir\n3-Depósito\n4-consultar saldo\n5-Cadastrar pix");
			escolha = sc.nextInt();
			 sc.nextLine();
			 if(escolha == 1) {//cadastra
				 cadastrar();
				 continue;
			 }else if(escolha == 2) {//transferir
				 transferir();
				 continue;
			 }else if(escolha == 3) {//deposito
				 depositar();
				 continue;
			 }else if(escolha == 4) {//saldo
				 consultaSaldo();
				 continue;
			 }else if(escolha == 5) {//pix
				 exibePix();
				 continue;
			 }
			 
			 else if (escolha == 0) {
				 break;
				 
			 }
		}
					
	}
	public static void operacaoPrincipal() {
		 
			
		
	}
	private static void exibePix() {
		System.out.println("1-Cadastrar chave\n2-Transferir via Pix");
		System.out.print("Escolha a opção: ");					
		String op = sc.nextLine();
		if (op.equals("1")) {//cadastra chave pix
			System.out.println("Escolha o tipo de chave ");
			 
			 System.out.println("1- Aleatória\n 2-CPF\n 3-telefone \n 4-e-mail ");
				 
			Pix pix = new Pix();				 
			 int opcaoPix = sc.nextInt();
				sc.nextLine();
			 
			// CPF, EMAIL, TELEFONE, ALEATORIO;	
				 if (opcaoPix == 1) {
					String conteudoChavePix = UUID.randomUUID().toString();
					 pix.ativarChave(TipoChavePix.ALEATORIO, conteudoChavePix, true);
					 conta.setPix(pix);
				 }
				
							 
				 else if (opcaoPix == 2 ) {
				pix.ativarChave(TipoChavePix.CPF, cliente.getCpf(), true);
				conta.setPix(pix);
				 }
				 
				 else if (opcaoPix == 3) {
					 pix.ativarChave(TipoChavePix.TELEFONE, cliente.getTelefone(), true);
					 conta.setPix(pix);
					 
				 }
				 
				 else if(opcaoPix == 4) {
					 pix.ativarChave(TipoChavePix.EMAIL,cliente.getEmail(), true);
					 conta.setPix(pix);
				 }
				 else {
					 System.out.println("Escolha inválida");	
					 
				 }									
		}
		
		else if (op.equals("2")) {// trasnfere via pix
			System.out.println("qual o valor a transferir: ");
			Double valorTransf = sc.nextDouble();
			if (conta.getSaldo() >= valorTransf) {
				System.out.print("Digite a chave do destinatário: ");
				String chave = sc.nextLine();
				if (conta1.getPix().getConteudoChave().equals(chave)) {
					conta.setSaldo(conta.getSaldo() - valorTransf);
					conta1.setSaldo(conta1.getSaldo() + valorTransf);

			}
			else {
				System.out.println("Chave pix não encontrada ");
			}
		}else {
			System.out.println("Você não possui saldo");
		}
		

	}
	}
	
	private static void consultaSaldo() {
		System.out.println("Seu saldo é : " + contaBo.consultaSaldo(conta));
		System.out.println("\n ");		
	}
	private static void depositar() {
		System.out.println("Qual valor de deposito ?  ");	
		deposito = sc.nextDouble();
		contaBo.deposito(deposito,conta);
		System.out.println("\n depósito feito com sucesso\n");
		
	}
	private static void transferir() {
		System.out.println("Qual valor a transferir?  ");
		 valor = sc.nextDouble();
		 contaBo.transferir (valor,conta,conta1);
		 System.out.println("\nTransferência feita com sucesso\n");
		
	}
	//CADASTRAR
	public static void cadastrar() {
		System.out.println("Digite seu nome para cadastro: ");
		nome =  sc.nextLine();
		
	
	System.out.println("Digite sua data de nascimento: ");
	String dataNascimento = sc.nextLine();
				 
	
	System.out.println("Digite seu e-mail:  ");
	String email = sc.nextLine();
	
	System.out.println("seu o numero de telefone : ");
	String telefone = sc.nextLine();
	while (( telefone).length() != 9) {
		 System.out.println("Número de telefone inválido\n Digite novamente");
		 telefone = sc.nextLine();
	}
							
	System.out.println("Digite seu cpf com 11 digitos, somente números: ");
	 cpf = sc.nextLine();
	 while (cpf.length() != 11) {
		 System.out.println("Número inválido\n Digite novamente");
		 cpf = sc.nextLine();
		 
	 }
	 // String logradouro, String numero, String cep, String bairro, String cidade, String estado
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
	 
	 System.out.println("Digite oestado: ");
	 String estado = sc.nextLine();
	 
	 System.out.println("Digite o tipo da conta: ");
	 int escolhaConta= sc.nextInt();
	 
	 if(escolhaConta == 1){

		 tipoConta = TipoConta.CORRENTE;
		 }else{
			 tipoConta = TipoConta.POUPANCA;
		 }
	 
	 Endereco endereco = new Endereco(logradouro, numero, cep,bairro, cidade, estado);
	 
	  cliente = clienteBo.cadastrarDados(cpf, nome, endereco, tipoConta, dataNascimento, telefone, email);
	  conta = contaBo.cadastrarConta(cliente, tipoConta);
	  conta1 = ContaBo.criarContaEstatica();
//	  
	 System.out.println("Cliente cadastrado com sucesso ");
	}
}
