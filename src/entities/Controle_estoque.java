package entities;

import enum_classes.Disponibilidade;

public class Controle_estoque {
	
	private String id;
	private String nome;
	private int quantidade;
	private double Preco;
	Disponibilidade disponibilidade;
	
	public Controle_estoque(String id, String nome, int quantidade, double preco) {
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.Preco = preco;
		if(quantidade == 0) {
			disponibilidade = Disponibilidade.ESGOTADO;
		}else {
			disponibilidade = Disponibilidade.DISPONIVEL;
		}
	}
	
	public Controle_estoque(String id) {
		this.id = id;
		this.nome = null;
		this.quantidade = 0;
		this.Preco = 0;
		disponibilidade = Disponibilidade.ESGOTADO;
	}
	
	public Controle_estoque(String id, String nome) {
		this.id = id;
		this.nome = nome;
		this.quantidade = 0;
		this.Preco = 0;
		disponibilidade = Disponibilidade.ESGOTADO;
	}
	
	public Controle_estoque(String id, String nome, int quantidade) {
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.Preco = 0;
		if(quantidade == 0) {
			disponibilidade = Disponibilidade.ESGOTADO;
		}else {
			disponibilidade = Disponibilidade.DISPONIVEL;
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return Preco;
	}

	public void setPreco(double preco) {
		Preco = preco;
	}
	
	public Disponibilidade getDisponibilidade() {
		return this.disponibilidade;
	}
	
	public void adciona_prod(int quantidade) {
		if(this.quantidade == 0) {
			disponibilidade = Disponibilidade.DISPONIVEL;
		}
		this.quantidade += quantidade;
		System.out.println("Quantidade atualizada: " + this.quantidade);
	}
	
	public void remove_prod(int quantidade) {
			if(quantidade > this.quantidade) {
				System.out.println("Quantidade invalida! nada foi removido.");
			}else {
				this.quantidade -= quantidade;
				if(this.quantidade == 0) {
					disponibilidade = Disponibilidade.ESGOTADO;
				}
			}
			System.out.println("Quantidade atualizada: " + this.quantidade);
	}
	
	public double valor_total() {
		return this.Preco * this.quantidade;
	}
	
	@Override
	public String toString() {
		return 	"Id: " + this.id + ";\n" +
				"Nome " + this.nome + ";\n" +
				"Quantidade em estoque " + this.quantidade + ";\n" +
				"Valor unitario: R$ " + this.Preco + ";\n" +
				"Valor total em estoque: R$ " + this.valor_total() + ".";
				
	}
	
	
	

}
