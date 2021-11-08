package com.inf.ufg.model;

public class Fornecedor extends Pessoa{
	
	private String CNPJ;
	private int codigo;
	
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	

}
