package com.inf.ufg.controller;

import java.util.UUID;

import javax.swing.JOptionPane;

import com.inf.ufg.Principal;
import com.inf.ufg.exceptions.ElementoNaoEncontradoException;
import com.inf.ufg.model.Produto;
import com.inf.ufg.utils.Menus;

public class PainelProduto {

	static Services services;

	public static void iniciar() {
		int opcao_int = -1;

		do {
			opcao_int = -1;
			String opcao = Menus.menuProduto();

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
				createProduto();
				break;

			case 2:
				updateProduto();
				break;

			case 3:
				removeProduto();
				break;

			case 4:
				buscaProduto();
				break;

			case 5:
				listaProdutos();
				break;

			case 0:
				break;

			default:
				JOptionPane.showMessageDialog(null, "Resposta inválida! Tente novamente");
				break;
			}
		} while(opcao_int != 0);
	}

	private static void createProduto() {

		//Gera codigo aleatório
		int codigo = Math.abs(UUID.randomUUID().hashCode());

		String nome = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Produtos/Cadastrar>\n"
				+ "\nInforme o nome do produto: ");

		String fabricante = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Produtos/Cadastrar>\n"
				+ "\nInforme o fabricante do produto: ");

		String descricao = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Produtos/Cadastrar\n"
				+ "\nColoque uma descrição para o produto: ");

		String data_validade = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Produtos/Cadastrar>\n"
				+ "\nInforme a data de validade do produto: ");

		String valor_atual = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Produtos/Cadastrar>\n"
				+ "\nInforme o preço de venda do produto: ");

		String quantidade = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Produtos/Cadastrar>\n"
				+ "\nInforme a quantidade do produto: ");

		String[] itens = { "Metro", "Peca", "Litro", "Quilo" };
		String unidade_medida = (String) JOptionPane.showInputDialog(null,
				"Informe a unidade de medida do produto: ", "<Produtos/Cadastrar>\n",
				JOptionPane.INFORMATION_MESSAGE, null,
				itens, itens [0]);

		int index_fornecedor = -1;
		int tentativas = 0;
		do {
			String nome_fornecedor = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
					+ "<Produtos/Cadastrar>\n"
					+ "\nInforme o nome do fornecedor: ");

			index_fornecedor = buscaNomeFornecedor(nome_fornecedor);

			if(tentativas < 3 && index_fornecedor < 0) {
				JOptionPane.showMessageDialog(null, "Fornecedor inválido, tente novamente");
				tentativas++;
			} else if(tentativas == 3) {
				JOptionPane.showMessageDialog(null, "3 Tentativas incorretas, cadastre ou verifique o fornecedor correto");
				tentativas = 0; //zerando tentativas
				break;
			}
		} while(index_fornecedor < 0);

		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setFabricante(fabricante);
		produto.setDescricao(descricao);
		produto.setData_validade(data_validade);
		produto.setCodigo(codigo);

		try {
			produto.setValor_atual(Double.parseDouble(valor_atual));
			produto.setQuantidade(Integer.parseInt(quantidade));
		} catch (NumberFormatException e) {
			produto.setValor_atual(0.0);
			produto.setQuantidade(0);
		}
		produto.setUnidade_medida(unidade_medida);

		if(index_fornecedor >= 0) {
			produto.setFornecedor(Principal.fornecedores.get(index_fornecedor).getNome());
		}

		services.inserir(produto);

		JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
	}


	private static void updateProduto() {

		String codigo_str = JOptionPane.showInputDialog("Qual produto deseja alterar?");
		int codigo = -1;
		try {
			codigo = Integer.parseInt(codigo_str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		int index = buscaPosicao(codigo);

		if (index>0) {
			String nome = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
					+ "<Produtos/Cadastrar>\n"
					+ "\nInforme o nome do produto: ");

			String fabricante = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
					+ "<Produtos/Cadastrar>\n"
					+ "\nInforme o fabricante do produto: ");

			String descricao = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
					+ "<Produtos/Cadastrar\n"
					+ "\nColoque uma descrição para o produto: ");

			String data_validade = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
					+ "<Produtos/Cadastrar>\n"
					+ "\nInforme a data de validade do produto: ");

			String valor_atual = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
					+ "<Produtos/Cadastrar>\n"
					+ "\nInforme o preço de venda do produto: ");

			String quantidade = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
					+ "<Produtos/Cadastrar>\n"
					+ "\nInforme a quantidade do produto: ");

			String[] itens = { "Metro", "Peca", "Litro", "Quilo" };
			String unidade_medida = (String) JOptionPane.showInputDialog(null,
					"Informe a unidade de medida do produto: ", "<Produtos/Cadastrar>\n",
					JOptionPane.INFORMATION_MESSAGE, null,
					itens, itens [0]);

			int index_fornecedor = -1;

			int tentativas = 0;
			do {
				String nome_fornecedor = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
						+ "<Produtos/Cadastrar>\n"
						+ "\nInforme o nome do fornecedor: ");

				index_fornecedor = buscaNomeFornecedor(nome_fornecedor);

				if(tentativas < 3 && index_fornecedor < 0) {
					JOptionPane.showMessageDialog(null, "Fornecedor inválido, tente novamente");
					tentativas++;
				} else if(tentativas == 3 && index_fornecedor < 0) {
					JOptionPane.showMessageDialog(null, "3 Tentativas incorretas, cadastre ou verifique o fornecedor correto");
					tentativas = 0; //zerando tentativas
					break;
				}
			} while(index_fornecedor < 0);

			Produto produto = new Produto();
			produto.setNome(nome);
			produto.setFabricante(fabricante);
			produto.setDescricao(descricao);
			produto.setData_validade(data_validade);
			produto.setCodigo(codigo);
			
			
			
			try {
				produto.setValor_atual(Double.parseDouble(valor_atual));
				produto.setQuantidade(Integer.parseInt(quantidade));
			} catch (NumberFormatException e) {
				produto.setValor_atual(0.0);
				produto.setQuantidade(0);
			}
			
			produto.setUnidade_medida(unidade_medida);

			if(index_fornecedor >= 0) {
				produto.setFornecedor(Principal.fornecedores.get(index_fornecedor).getNome());
			}

			services.alterar(produto, index);

			JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Produto não localizado");
			throw new ElementoNaoEncontradoException("Produto não localizado");
		}
	}

	private static void removeProduto() {
		String codigo_str = JOptionPane.showInputDialog("Qual produto deseja remover?");
		int codigo = -1;
		try {
			codigo = Integer.parseInt(codigo_str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		int index = buscaPosicao(codigo);
		Produto produto = Principal.produtos.get(index);

		if (index>0) {
			services.excluir(produto);
			JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");

		} else {
			JOptionPane.showMessageDialog(null, "Produto não localizado");
			throw new ElementoNaoEncontradoException("Produto não localizado");
		}

	}

	private static int buscaNomeFornecedor(String nome) {
		for (int i = 0; i < Principal.fornecedores.size();i++ ) {
			if (Principal.fornecedores.get(i).getNome().equals(nome)) {
				return i;
			}
		}
		return -1;
	}

	private static int buscaPosicao(int id) {
		int index = 0;

		for (Produto fornecedor: Principal.produtos) {
			if (fornecedor.getCodigo() == id) {
				return index;
			}
			index++;
		}
		return -1;
	}

	private static void buscaProduto() {
		String codigo_str = JOptionPane.showInputDialog("Qual fornecedor deseja consultar?");
		int codigo = Integer.parseInt(codigo_str);

		int index = buscaPosicao(codigo);

		if (index>0) {
			Produto produto = Principal.produtos.get(index);
			String dados = "ID: " + produto.getCodigo() + "\n"
					+ "Nome: " + produto.getNome() + "\n"
					+ "Quantidade: " + produto.getQuantidade() + "\n"
					+ "Fabricante: " + produto.getFabricante() + "\n"
					+ "Fornecedor: " + produto.getFornecedor() + "\n"
					+ "Descricao: " + produto.getDescricao()+ "\n"
					+ "Unidade: " + produto.getUnidade_medida()+ "\n"
					+ "Validade: " + produto.getData_validade()+ "\n"
					+ "Preço atual: " + produto.getValor_atual() + "/n/n";

			JOptionPane.showMessageDialog(null, dados);
		} else {
			JOptionPane.showMessageDialog(null, "Produto não localizado");
			throw new ElementoNaoEncontradoException("Produto não localizado");
		}
	}

	private static void listaProdutos() {
		String dados = "";
		for (Produto produto: Principal.produtos) {
			String produto_dados = "ID: " + produto.getCodigo() + "\n"
					+ "Nome: " + produto.getNome() + "\n"
					+ "Quantidade: " + produto.getQuantidade() + "\n"
					+ "Fabricante: " + produto.getFabricante() + "\n"
					+ "Fornecedor: " + produto.getFornecedor() + "\n"
					+ "Descricao: " + produto.getDescricao()+ "\n"
					+ "Unidade: " + produto.getUnidade_medida()+ "\n"
					+ "Validade: " + produto.getData_validade()+ "\n"
					+ "Preço atual: " + produto.getValor_atual() + "/n/n";
			dados = dados + produto_dados;
		}

		JOptionPane.showMessageDialog(null, dados);
	}

}
