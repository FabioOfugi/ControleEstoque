package com.inf.ufg.controller;

import java.util.UUID;

import javax.swing.JOptionPane;

import com.inf.ufg.Principal;
import com.inf.ufg.model.Fornecedor;
import com.inf.ufg.utils.Menus;

public class PainelFornecedor {

	static Services services;

	public static void iniciar() {
		int opcao_int = -1;

		do {
			opcao_int = -1;
			String opcao = Menus.menuFornecedor();

			if(!opcao.isEmpty()) {
				try {
					opcao_int = Integer.parseInt(opcao);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}

			services = new Services();

			switch (opcao_int) {
			case 1:
				createFornecedor();
				break;

			case 2:
				updateFornecedor();
				break;
				
			case 3:
				removeFornecedor();
				break;

			case 4:
				buscaFornecedor();
				break;

			case 5:
				listaFornecedores();
				break;

			case 0:
				break;

			default:
				JOptionPane.showMessageDialog(null, "Resposta inválida! Tente novamente");
				break;
			}
		} while(opcao_int != 0);
	}


	private static void createFornecedor() {
		
		//Gera codigo aleatório
		int codigo = Math.abs(UUID.randomUUID().hashCode());

		String nome = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Fornecedores/Cadastrar>\n"
				+ "\nInforme a razão social da empresa: ");

		String email = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Fornecedores/Cadastrar>\n"
				+ "\nInforme o email da empresa: ");

		String CNPJ = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Fornecedores/Cadastrar\n"
				+ "\nInforme o CNPJ da empresa: ");

		String endereco = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Fornecedores/Cadastrar>\n"
				+ "\nInforme o endereço: ");

		String telefone = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Fornecedores/Cadastrar>\n"
				+ "\nInforme o telefone da empresa: ");

		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome(nome);
		fornecedor.setCNPJ(CNPJ);
		fornecedor.setEndereco(endereco);
		fornecedor.setTelefone(telefone);
		fornecedor.setCodigo(codigo);
		fornecedor.setEmail(email);

		services.inserir(fornecedor);

		JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!");
	}
	

	private static void updateFornecedor() {

		String codigo_str = JOptionPane.showInputDialog("Qual fornecedor deseja alterar?");
		int codigo = Integer.parseInt(codigo_str);

		int index = buscaPosicao(codigo);

		if (index>0) {
			String nome = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
					+ "<Fornecedores/Alterar>\n"
					+ "\nInforme a razão social da empresa: ");

			String email = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
					+ "<Fornecedores/Alterar>\n"
					+ "\nInforme o email da empresa: ");

			String CNPJ = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
					+ "<Fornecedores/Alterar\n"
					+ "\nInforme o CNPJ da empresa: ");

			String endereco = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
					+ "<Fornecedores/Alterar>\n"
					+ "\nInforme o endereço da empresa: ");

			String telefone = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
					+ "<Fornecedores/Alterar>\n"
					+ "\nInforme o telefone da empresa: ");

			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setNome(nome);
			fornecedor.setCNPJ(CNPJ);
			fornecedor.setEndereco(endereco);
			fornecedor.setTelefone(telefone);
			fornecedor.setCodigo(codigo);
			fornecedor.setEmail(email);
			
			services.alterar(fornecedor, index);
			
			JOptionPane.showMessageDialog(null, "Fornecedor alterado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Fornecedor não localizado");
		}
	}

	private static void removeFornecedor() {
		String codigo_str = JOptionPane.showInputDialog("Qual fornecedor deseja remover?");
		int codigo = Integer.parseInt(codigo_str);

		int index = buscaPosicao(codigo);
		Fornecedor fornecedor = Principal.fornecedores.get(index);

		if (index>0) {
			services.excluir(fornecedor);
			JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso!");
			
		} else {
			JOptionPane.showMessageDialog(null, "Fornecedor não localizado");
		}

	}

	public static int buscaPosicao(int id) {
		int index = 0;

		for (Fornecedor fornecedor: Principal.fornecedores) {
			if (fornecedor.getCodigo() == id) {
				return index;
			}
			index++;
		}
		return -1;
	}

	private static void buscaFornecedor() {
		String codigo_str = JOptionPane.showInputDialog("Qual fornecedor deseja consultar?");
		int codigo = Integer.parseInt(codigo_str);

		int index = buscaPosicao(codigo);

		if (index>0) {
			Fornecedor fornecedor = Principal.fornecedores.get(index);
			String dados = "ID: " + fornecedor.getCodigo() + "\n"
					+ "Nome: " + fornecedor.getNome() + "\n"
					+ "CNPJ: " + fornecedor.getCNPJ() + "\n"
					+ "Email: " + fornecedor.getEmail() + "\n"
					+ "Telefone: " + fornecedor.getTelefone() + "\n"
					+ "Endereco: " + fornecedor.getEndereco() + "\n";

			JOptionPane.showMessageDialog(null, dados);
		} else {
			JOptionPane.showMessageDialog(null, "Fornecedor não localizado");
		}
	}

	private static void listaFornecedores() {
		String dados = "";
		for (Fornecedor fornecedor: Principal.fornecedores) {
			String fornecedor_dados = "ID: " + fornecedor.getCodigo() + "\n"
					+ "Nome: " + fornecedor.getNome() + "\n"
					+ "CNPJ: " + fornecedor.getCNPJ() + "\n"
					+ "Email: " + fornecedor.getEmail() + "\n"
					+ "Telefone: " + fornecedor.getTelefone() + "\n"
					+ "Endereco: " + fornecedor.getEndereco() + "\n\n";
			dados = dados + fornecedor_dados;
		}

		JOptionPane.showMessageDialog(null, dados);
	}

}
