package io.projetoApiDeLojaDeCarroVirtual.dto;

public class CarroDTO {
	
	
	private String nome;
	
	private String modelo;
	
	private String cor;
	
	private Double preco;
	
//	private Integer id;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}
