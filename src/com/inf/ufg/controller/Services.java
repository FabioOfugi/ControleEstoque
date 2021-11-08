package com.inf.ufg.controller;

import com.inf.ufg.Operacoes;
import com.inf.ufg.Principal;
import com.inf.ufg.model.Cliente;
import com.inf.ufg.model.Fornecedor;
import com.inf.ufg.model.Produto;

public class Services implements Operacoes<Object> {

	@Override
	public void inserir(Object object) {
		String name = object.getClass().getSimpleName();
		System.out.println(name);
		if (name.contains("Fornecedor")) {
			Principal.fornecedores.add((Fornecedor) object);
		} else if (name.contains("Produto")) {
			Principal.produtos.add((Produto) object);
		} else if (name.contains("Cliente")){
			Principal.clientes.add((Cliente) object);
		}
	}

	@Override
	public void alterar(Object object, int index) {
		String name = object.getClass().getSimpleName();
		System.out.println(name);
		if (name.contains("Fornecedor")) {
			Principal.fornecedores.set(index, (Fornecedor) object);
		} else if (name.contains("Produto")) {
			Principal.produtos.set(index, (Produto) object);
		} else if (name.contains("Cliente")){
			Principal.clientes.set(index, (Cliente) object);
		}		
	}

	@Override
	public void excluir(Object object) {
		String name = object.getClass().getSimpleName();
		System.out.println(name);
		if (name.contains("Fornecedor")) {
			Principal.fornecedores.remove(object);
		} else if (name.contains("Produto")) {
			Principal.produtos.remove(object);
		} else if (name.contains("Cliente")){
			Principal.clientes.remove(object);
		}
	}

}
