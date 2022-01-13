package br.com.projetonextentregar.bean;

import java.util.*;

import br.com.projetonextentregar.bo.ClienteBo;
import br.com.projetonextentregar.bo.ContaBo;

public class Principal {

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		
		Cliente cliente = new Cliente();
		ClienteBo clienteBo = new ClienteBo();
		ContaBo contaBo = new ContaBo();
				
		
		Conta conta = new Conta();
		Conta conta1 = ContaBo.criarContaEstatica();
		String nome = null;
		String cpf = null;
		double valor;
		double deposito;
		double saldo = 0;
		int escolha;
				
		
		do {
			
			System.out.println("Escola uma opção:\n ");			
			
			System.out.println("1- Fazer seu cadastro\n2-Transferir\n3-Depósito\n4-Conultar saldo\n5-Sair ");
			
		 escolha = sc.nextInt();
		sc.nextLine();
			
		switch (escolha){
		
			case 1: 				
								
			if (escolha == 1) {
				System.out.println("Digite seu nome para cadastro: ");
				nome =  sc.nextLine();
				
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
			 
			 
			 Endereco endereco = new Endereco(logradouro, numero, cep,bairro, cidade, estado);
			 cliente = clienteBo.cadastrarDados(cpf, nome,endereco);
			 System.out.println("Cliente cadastrado com sucesso ");
			 break;
			}
				
			case 2: 
				
				System.out.println("Qual valor a transferir?  ");
				 valor = sc.nextDouble();
				 contaBo.transferir (valor,conta,conta1);
				 
				 System.out.println("\nTransferência feita com sucesso\n");
				break;
				
				
				case 3:
				System.out.println("Qual valor de deposito ?  ");	
				deposito = sc.nextDouble();
				contaBo.deposito(deposito,conta);
				System.out.println("\n depósito feito com sucesso\n");
				break;
				
				
				case 4: 
				System.out.println("Seu saldo é : " + contaBo.consultaSaldo(conta));
				System.out.println("\n ");
				break;
					
				
				
							
			default:
			System.out.println("Sessão encerrada ");
		
		}
				
	} while (escolha !=5);
	
			

	}}

	
		
	
		
	
		
	
