package com.inf.ufg.model;

public class Produto {
	private int codigo, quantidade;
	private String nome, fabricante, descricao, unidade_medida, data_validade;
	private Double valor_atual;
	private String nome_fornecedor;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUnidade_medida() {
		return unidade_medida;
	}

	public void setUnidade_medida(String unidade_medida) {
		this.unidade_medida = unidade_medida;
	}

	public Double getValor_atual() {
		return valor_atual;
	}

	public void setValor_atual(Double valor_atual) {
		this.valor_atual = valor_atual;
	}

	public String getData_validade() {
		return data_validade;
	}

	public void setData_validade(String data_validade) {
		this.data_validade = data_validade;
	}

	public String getFornecedor() {
		return nome_fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.nome_fornecedor = fornecedor;
	}
}
