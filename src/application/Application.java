package application;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

import entities.Controle_estoque;
import enum_classes.Disponibilidade;

public class Application {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		String id, nome;
		int quantidade;
		double preco;
		Pattern padrao_id = Pattern.compile("[a-z]([1-9]){5}");
		var produtos = new LinkedList<Controle_estoque>();
		Controle_estoque achadoProduto = null;
		boolean achou = false;
		
		System.out.println("Bem-vindo ao sistema de estoque da empresa 123!");
		System.out.println("O que podemos fazer por você?");
		System.out.println();
		
		do {
			System.out.println("1- Cadastar um produto;");
			System.out.println("2- Adicionar produtos;");
			System.out.println("3- Remover produtos;");
			System.out.println("4- Mostrar um produto especifico;");
			System.out.println("5- Mostrar todos os produtos;");
			System.out.println("6- Sair.");
			System.out.println();
			System.out.print("Selecione uma opção:");
			
			try {
				opcao = sc.nextInt();
				if(opcao < 0 || opcao > 7) {
					throw new InputMismatchException();
				}
			}catch(InputMismatchException e) {
				System.out.println("Opcao invalida!");
			}finally{
				sc.nextLine();
				System.out.println();
			}
			
			switch(opcao) {
			case 1:
				System.out.print("Digite o id do produto: ");
				try {
					id = sc.next(padrao_id);
				}catch(InputMismatchException e) {
					System.out.println("Id invalido!");
					break;
				}finally {
					sc.nextLine();
					System.out.println();
				}
				
				System.out.print("Digite o nome do produto: ");
				nome = sc.nextLine();
				System.out.println();
				
				System.out.print("Digite a quantidade atual em estoque: ");
				try {
					quantidade = sc.nextInt();
					if(quantidade < 0) {
						throw new InputMismatchException();
					}
				}catch(InputMismatchException e) {
					System.out.println("Quantidade invalida!");
					break;
				}finally {
					sc.nextLine();
					System.out.println();
				}
				
				System.out.print("Digite o valor unitario do produto: R$ ");
				try {
					preco = sc.nextDouble();
					if(preco < 0) {
						throw new InputMismatchException();
					}
				}catch(InputMismatchException e) {
					System.out.println("Valor invalido!");
					break;
				}finally {
					sc.nextLine();
					System.out.println();
				}
				
				produtos.add(new Controle_estoque(id, nome, quantidade, preco));
				break;
			case 2:
				System.out.print("Digite o id do produto a ser adicionado: ");
				try {
					id = sc.next(padrao_id);
				}catch(InputMismatchException e) {
					System.out.println("Id invalido!");
					break;
				}finally {
					sc.nextLine();
					System.out.println();
				}
				
				for(Controle_estoque o: produtos) {
					if(o.getId().equals(id)) {
						System.out.println("Produto encontrado!");
						System.out.println();
						System.out.println("Produto: ");
						System.out.println(o);
						System.out.println();
						achadoProduto = o;
						achou = true;
						break;
					}
				}
				
				if(!achou) {
					System.out.println("Produto não encontrado!");
					System.out.println();
					break;
				}
				
				System.out.print("Quantos produtos serão adicionados?");
				try {
					quantidade = sc.nextInt();
					if(quantidade <= 0) {
						throw new InputMismatchException();
					}
				}catch(InputMismatchException e) {
					System.out.println("Quantidade invalida!");
					break;
				}finally {
					sc.nextLine();
					System.out.println();
				}
		
				achadoProduto.adciona_prod(quantidade);
				System.out.println();
				achou = false;
				break;
			case 3:
				System.out.print("Digite o id do produto a ser removido: ");
				try {
					id = sc.next(padrao_id);
				}catch(InputMismatchException e) {
					System.out.println("Id invalido!");
					break;
				}finally {
					sc.nextLine();
					System.out.println();
				}
				
				for(Controle_estoque o: produtos) {
					if(o.getId().equals(id)) {
						System.out.println("Produto encontrado!");
						System.out.println();
						System.out.println("Produto: ");
						System.out.println(o);
						System.out.println();
						achadoProduto = o;
						achou = true;
						break;
					}
				}
				
				if(!achou) {
					System.out.println("Produto não encontrado!");
					System.out.println();
					break;
				}
				
				System.out.print("Quantos produtos serão removidos?");
				try {
					quantidade = sc.nextInt();
					if(quantidade <= 0) {
						throw new InputMismatchException();
					}
				}catch(InputMismatchException e) {
					System.out.println("Quantidade invalida!");
					break;
				}finally {
					sc.nextLine();
					System.out.println();
				}
		
				achadoProduto.remove_prod(quantidade);
				System.out.println();
				achou = false;
				break;
			case 4:
				System.out.print("Digite o id do produto a ser exibido: ");
				try {
					id = sc.next(padrao_id);
				}catch(InputMismatchException e) {
					System.out.println("Id invalido!");
					break;
				}finally {
					sc.nextLine();
					System.out.println();
				}
				
				for(Controle_estoque o: produtos) {
					if(o.getId().equals(id)) {
						System.out.println("Produto encontrado!");
						System.out.println();
						System.out.println("Produto: ");
						System.out.println(o);
						System.out.println("Disponibilidade: " + o.getDisponibilidade());
						System.out.println();
						achou = true;
						break;
					}
				}
				
				if(!achou) {
					System.out.println("Produto não encontrado!");
					System.out.println();
					break;
				}
				
				achou = false;
				break;
			case 5:
				System.out.println("Lista de produtos: ");
				System.out.println();
				for(Controle_estoque o: produtos) {
					if(o.getDisponibilidade() == Disponibilidade.DISPONIVEL) {
						System.out.println(o);
						System.out.println();
					}
				}
				break;
			case 6:
				System.out.println("Saindo...");	
			}
			
		}while(opcao != 6);
		
		System.out.println("Obrigado por usar o nosso sistema!");

	}

}
