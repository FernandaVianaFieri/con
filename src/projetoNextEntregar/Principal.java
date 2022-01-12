package projetoNextEntregar;

import java.util.*;

import projetoNextEntregar.bo.ClienteBo;

public class Principal {

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		
		Cliente cliente = new Cliente();
		ClienteBo clienteBo = new ClienteBo();
		
		
		
		Conta conta = new Conta();
		String nome = null;
		String cpf = null;
		double valor;
		double deposito;
		double saldo = 0;
		int escolha;
		
		
		
		do {
			
			System.out.println("Escola uma op��o:\n ");			
			
			System.out.println("1- Fazer seu cadastro\n2-Transferir\n3-Dep�sito\n4-Conultar saldo\n5-Sair ");
			
		 escolha = sc.nextInt();
			
			
		switch (escolha){
		
			case 1: 				
								
			if (escolha == 1) {
				System.out.println("Digite seu nome para cadastro: ");
				nome =  sc.nextLine();
				
			System.out.println("Digite seu cpf com 11 digitos, somente n�meros: ");
			 cpf = sc.nextLine();
			 while (cpf.length() != 11) {
				 System.out.println("N�mero inv�lido\n Digite novamente");
				 cpf = sc.nextLine();
			 }
				 
			 cliente = clienteBo.cadastrarDados(cpf, nome);
			 System.out.println("Cliente cadastrado com sucesso ");
			 break;
			}
				
			case 2: 
				
				System.out.println("Qual valor a transferir?  ");
				 valor = sc.nextDouble();
				 conta.transferir (valor);
				 
				 System.out.println("\nTransfer�ncia feita com sucesso\n");
				break;
				
				
				case 3:
				System.out.println("Qual valor de deposito ?  ");	
				deposito = sc.nextDouble();
				conta.deposito(deposito);
				System.out.println("\n dep�sito feito com sucesso\n");
				break;
				
				
				case 4: 
				System.out.println("Seu saldo � : " + conta.consultaSaldo());
				System.out.println("\n ");
				break;
									
							
			default:
			System.out.println("Sess�o encerrada ");
		
		}
				
	} while (escolha !=5);
	
			

	}}

	
		
	
		
	
		
	
