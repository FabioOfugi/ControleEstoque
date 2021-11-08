package com.inf.ufg.controller;

import java.util.UUID;

import javax.swing.JOptionPane;

import com.inf.ufg.Principal;
import com.inf.ufg.model.Cliente;
import com.inf.ufg.utils.Menus;

public class PainelCliente {

	static Services services;

	public static void iniciar() {
		int opcao_int = -1;

		do {
			opcao_int = -1;
			String opcao = Menus.menuCliente();

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
				createCliente();
				break;

			case 2:
				updateCliente();
				break;
				
			case 3:
				removeCliente();
				break;

			case 4:
				buscaCliente();
				break;

			case 5:
				listaClientes();
				break;

			case 0:
				break;

			default:
				JOptionPane.showMessageDialog(null, "Resposta inválida! Tente novamente");
				break;
			}
		} while(opcao_int != 0);
	}


	private static void createCliente() {
		
		//Gera codigo aleatório
		int codigo = Math.abs(UUID.randomUUID().hashCode());

		String nome = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Clientes/Cadastrar>\n"
				+ "\nInforme o nome do cliente: ");

		String email = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Clientes/Cadastrar>\n"
				+ "\nInforme o email do cliente: ");

		String endereco = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Clientes/Cadastrar>\n"
				+ "\nInforme o endereço do cliente: ");

		String telefone = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Clientes/Cadastrar>\n"
				+ "\nInforme o telefone do cliente: ");

		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setEndereco(endereco);
		cliente.setTelefone(telefone);
		cliente.setCodigo(codigo);
		cliente.setEmail(email);

		services.inserir(cliente);

		JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
	}
	

	private static void updateCliente() {

		String codigo_str = JOptionPane.showInputDialog("Qual cliente deseja alterar?");
		int codigo = -1;
		try {
			codigo = Integer.parseInt(codigo_str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		int index = buscaPosicao(codigo);

		if (index>0) {
			String nome = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
					+ "<Clientes/Alterar>\n"
					+ "\nInforme o novo nome do cliente: ");

			String email = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
					+ "<Clientes/Alterar>\n"
					+ "\nInforme o novo email do cliente: ");

			String endereco = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
					+ "<Clientes/Alterar>\n"
					+ "\nInforme o novo endereço do cliente: ");

			String telefone = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
					+ "<Clientes/Alterar>\n"
					+ "\nInforme o novo telefone do cliente: ");

			Cliente cliente = new Cliente();
			cliente.setNome(nome);
			cliente.setEndereco(endereco);
			cliente.setTelefone(telefone);
			cliente.setCodigo(codigo);
			cliente.setEmail(email);
			
			services.alterar(cliente, index);
			
			JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Cliente não localizado");
		}
	}

	private static void removeCliente() {
		String codigo_str = JOptionPane.showInputDialog("Qual cliente deseja remover?");
		int codigo = Integer.parseInt(codigo_str);

		int index = buscaPosicao(codigo);
		Cliente cliente = Principal.clientes.get(index);

		if (index>0) {
			services.excluir(cliente);
			JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
			
		} else {
			JOptionPane.showMessageDialog(null, "Cliente não localizado");
		}

	}

	private static int buscaPosicao(int id) {
		int index = 0;

		for (Cliente cliente: Principal.clientes) {
			if (cliente.getCodigo() == id) {
				return index;
			}
			index++;
		}
		return -1;
	}

	private static void buscaCliente() {
		String codigo_str = JOptionPane.showInputDialog("Qual cliente deseja consultar?");
		int codigo = -1;
		try {
			codigo = Integer.parseInt(codigo_str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		int index = buscaPosicao(codigo);

		if (index>0) {
			Cliente cliente = Principal.clientes.get(index);
			String dados = "ID: " + cliente.getCodigo() + "\n"
					+ "Nome: " + cliente.getNome() + "\n"
					+ "Email: " + cliente.getEmail() + "\n"
					+ "Tel: " + cliente.getTelefone() + "\n"
					+ "Endereco: " + cliente.getEndereco() + "\n";

			JOptionPane.showMessageDialog(null, dados);
		} else {
			JOptionPane.showMessageDialog(null, "Cliente não localizado");
		}
	}

	private static void listaClientes() {
		String dados = "";
		for (Cliente cliente: Principal.clientes) {
			String cliente_dados = "ID: " + cliente.getCodigo() + "\n"
					+ "Nome: " + cliente.getNome() + "\n"
					+ "Email: " + cliente.getEmail() + "\n"
					+ "Telefone: " + cliente.getTelefone() + "\n"
					+ "Endereco: " + cliente.getEndereco() + "\n\n";
			dados = dados + cliente_dados;
		}

		JOptionPane.showMessageDialog(null, dados);
	}

}

