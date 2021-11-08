package com.inf.ufg.model;
import java.util.Calendar;

public class Produto {
	private int codigo, quantidade;
	private String nome, fabricante, descricao, unidade_medida;
	private double valor_atual;
	private Calendar data_validade;
	private Fornecedor fornecedor;
	
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

	public double getValor_atual() {
		return valor_atual;
	}

	public void setValor_atual(double valor_atual) {
		this.valor_atual = valor_atual;
	}

	public Calendar getData_validade() {
		return data_validade;
	}

	public void setData_validade(Calendar data_validade) {
		this.data_validade = data_validade;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
}
