/*package com.inf.ufg.model;
import javax.swing.*;

import com.inf.ufg.Operacoes;

import java.util.*;

public class FornecedorRefactor extends Pessoa implements Operacoes{
	private String CNPJ;
	private int codigo;
	private static int count = -1;
	private ArrayList<FornecedorRefactor> fornecedores = new ArrayList();
	
	Fornecedor(){
		count++;
	}
	
	Fornecedor(String nome, String telefone, String CNPJ, String endereco) {
		super(nome, telefone, endereco);
		this.CNPJ = CNPJ;
		count++;
	}
	
	public int getCount() {
		return count;
	}
	
	@Override
	public String menu() {
		
		String opcao = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Fornecedores>\n"
				+ "Cadastrados: " + count + "\n"
				+ "\n\nInforme a opção que deseja realizar: \n\n"
				+ "1 - Cadastrar Fornecedor \n"
				+ "2 - Alterar informações do Fornecedor\n"
				+ "3 - Excluir Fornecedor\n"
				+ "4 - Consultar informações de um fornecedor\n"
				+ "5 - Listar fornecedores\n\n");
		
		return opcao;
	}
	
	@Override
	public void inserir() {
		
		codigo = count;
		
		nome = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Fornecedores/Cadastrar>\n"
				+ "\nInforme a razão social da empresa: ");
			
		
		CNPJ = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Fornecedores/Cadastrar\n"
				+ "\nInforme o CNPJ da empresa: ");
		
		endereco = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Fornecedores/Cadastrar>\n"
				+ "\nInforme o endereço: ");
		
		telefone = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Fornecedores/Cadastrar>\n"
				+ "\nInforme o telefone da empresa: ");
		
		JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!");
		
		Fornecedor f1 = new Fornecedor(nome, telefone, CNPJ, endereco);
		
		fornecedores.add(f1);
	}
	
	@Override
	public void alterar() {
		
		String pesquisa;
		int flag = 0;
		
		pesquisa = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Fornecedores/Alterar>\n"
				+ "\nInforme o codigo do fornecedor que deseja alterar: ");
	
		for(int i = 0; i < fornecedores.size(); i++) {
			
			if(Integer.parseInt(pesquisa) == fornecedores.get(i).codigo + 1) {
					
				flag = 1;
					
				Object[] options = { "Alterar", "Cancelar" };
				
				Object opcao = JOptionPane.showOptionDialog(null, "Deseja alterar esse fornecedor ?\n\n"
						+ "Código: "+ fornecedores.get(i).codigo + 1 + "\n"
						+ "Razão Social: " + fornecedores.get(i).nome + "\n"
						+ "Endereço: " + fornecedores.get(i).endereco + "\n"
						+ "Telefone: " + fornecedores.get(i).telefone + "\n"
								,"<Fornecedores/Alterar>", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
								null, options, options[0]);
						
				fornecedores.get(i).nome = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
						+ "<Fornecedores/Alterar>\n"
						+ "\nInforme a nova razão social da empresa: ");
							
						
				fornecedores.get(i).CNPJ = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
						+ "<Fornecedores/Alterar\n"
						+ "\nInforme o novo CNPJ da empresa: ");
						
				fornecedores.get(i).endereco = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
						+ "<Fornecedores/Alterar>\n"
						+ "\nInforme o novo endereço: ");
						
				fornecedores.get(i).telefone = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
						+ "<Fornecedores/Alterar>\n"
						+ "\nInforme o novo número de telefone da empresa: ");
						
				JOptionPane.showMessageDialog(null, "Informações do Fornecedor alterados com sucesso!");
					
				break;	
			}
		}
		
		if(flag != 1) {
			JOptionPane.showMessageDialog(null, "Não há fornecedor cadastrado com esse código");
		}
	}
	
	@Override
	public void excluir() {
		
		String pesquisa;
		int flag = 0;
		
		pesquisa = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Fornecedores/Excluir>\n"
				+ "\nInforme o codigo do fornecedor que deseja excluir: ");
	
		for(int i = 0; i < fornecedores.size(); i++) {
			
			if(Integer.parseInt(pesquisa) == fornecedores.get(i).codigo + 1) {
					
				flag = 1;
					
				Object[] options = { "Excluir", "Cancelar" };
				
				Object opcao = JOptionPane.showOptionDialog(null, "Deseja excluir esse fornecedor?\n\n"
						+ "Código: "+ fornecedores.get(i).codigo + 1 + "\n"
						+ "Razão Social: " + fornecedores.get(i).nome + "\n"
						+ "Endereço: " + fornecedores.get(i).endereco + "\n"
						+ "Telefone: " + fornecedores.get(i).telefone + "\n"
								,"<Fornecedores/Alterar>", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
								null, options, options[0]);
				
				fornecedores.remove(i);
				
				JOptionPane.showMessageDialog(null, "Fornecedor removido com sucesso!");
				
				break;
			}
		}
		
		if(flag != 1) {
			JOptionPane.showMessageDialog(null, "Não há fornecedor cadastrado com esse código");
		}
		
	}
	
	@Override
	public void consultar() {
		
		String pesquisa = JOptionPane.showInputDialog("\n------ Estoque ------\n\n"
				+ "<Fornecedores/Consultar>\n"
				+ "\nInforme o codigo do fornecedor: ");
		
		int flag = 0;
		
		for(int i = 0; i < fornecedores.size(); i++) {
			
			if(Integer.parseInt(pesquisa) == fornecedores.get(i).codigo + 1) {
				JOptionPane.showMessageDialog(null, "Código: "+ fornecedores.get(i).codigo + 1 + "\n"
						+ "Razão Social: " + fornecedores.get(i).nome + "\n"
						+ "Endereço: " + fornecedores.get(i).endereco + "\n"
						+ "Telefone: " + fornecedores.get(i).telefone + "\n"
								,"<Fornecedores/Consultar>", JOptionPane.INFORMATION_MESSAGE);
				flag = 1;
				break;	
			}
		}
		if(flag != 1) {
			JOptionPane.showMessageDialog(null, "Não há fornecedor cadastrado com esse código");
		}	
	}
	
	@Override
	public void listar() {
		
		String nome = "";
		
		for (int i = 0; i < fornecedores.size(); i++) {
			
			nome = "Fornecedor " + (i + 1) + "\n" 
					+ "Código: "+ fornecedores.get(i).codigo + 1 + "\n"
					+ "Razão Social: " + fornecedores.get(i).nome + "\n"
					+ "Endereço: " + fornecedores.get(i).endereco + "\n"
					+ "Telefone: " + fornecedores.get(i).telefone + "\n\n";
			
			nome += nome;
		}
		
		JOptionPane.showMessageDialog(null, nome);
	}
}*/
