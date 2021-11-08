package com.inf.ufg;
import java.util.ArrayList;

import javax.swing.*;

import com.inf.ufg.controller.PainelCliente;
import com.inf.ufg.controller.PainelFornecedor;
import com.inf.ufg.model.Cliente;
import com.inf.ufg.model.Fornecedor;
import com.inf.ufg.model.Produto;
import com.inf.ufg.utils.Menus;

public class Principal {

	public static ArrayList<Produto> produtos = new ArrayList<Produto>();
	public static ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	public static void main(String[] args) {

		int opcao_int = -1;
		
		do {
			opcao_int = -1;
			String opcao = Menus.menuPrincipal(produtos.size(), fornecedores.size(), clientes.size());
			
			if(!opcao.isEmpty()) {
				opcao_int = Integer.parseInt(opcao);
			}
			
			switch (opcao_int) {
			case 1:
				PainelFornecedor.iniciar();
				break;

			case 2:
				PainelCliente.iniciar();
				break;

			case 3:

				break;

			case 4:

				break;
				
			case 0:
				JOptionPane.showMessageDialog(null, "Fechando..");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Resposta inválida! Tente novamente");
				break;
			}
		} while(opcao_int != 0);
	
	}	

}

