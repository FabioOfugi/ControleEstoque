package com.inf.ufg.utils;

import javax.swing.JOptionPane;

public class Menus {
	
	public static String menuPrincipal(int qtd_produto, int qtd_fornecedor, int qtd_cliente) {
		
		String opcao = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Visão Geral>\n"
				+ "Produtos: " + qtd_produto + "   Fornecedores: " + qtd_fornecedor + "\n"
				+ "Clientes: " + qtd_cliente + "\n"
				+ "\n\nInforme a opção que deseja realizar: \n\n"
				+ "1 - Acessar painel Fornecedores \n"
				+ "2 - Acessar painel Clientes\n"
				+ "3 - Acessar painel Estoque\n\n"
				+ "0 - Fechar\n\n");
		
		return opcao;
	}
	
	public static String menuFornecedor() {
		
		String opcao = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Fornecedores>\n"
				+ "\n\nInforme a opção que deseja realizar: \n\n"
				+ "1 - Cadastrar Fornecedor \n"
				+ "2 - Alterar informações de um fornecedor\n"
				+ "3 - Excluir Fornecedor\n"
				+ "4 - Consultar informações de um fornecedor\n"
				+ "5 - Listar fornecedores\n\n"
				+ "0 - Voltar\n\n");
		
		return opcao;
	}
	
	public static String menuCliente() {
		
		String opcao = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Clientes>\n"
				+ "\n\nInforme a opção que deseja realizar: \n\n"
				+ "1 - Cadastrar Cliente \n"
				+ "2 - Alterar informações de um cliente\n"
				+ "3 - Excluir Cliente\n"
				+ "4 - Consultar informações de um cliente\n"
				+ "5 - Listar clientes\n\n"
				+ "0 - Voltar\n\n");
		
		return opcao;
	}
	
	public static String menuProduto() {
		
		String opcao = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Estoque>\n"
				+ "\n\nInforme a opção que deseja realizar: \n\n"
				+ "1 - Cadastrar um Produto \n"
				+ "2 - Alterar informações de um produto\n"
				+ "3 - Excluir Produto\n"
				+ "4 - Consultar informações de um produto\n"
				+ "5 - Listar produtos\n\n"
				+ "0 - Voltar\n\n");
		
		return opcao;
	}
	
	

}
