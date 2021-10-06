package view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.*;
import controller.*;

public class ViewCrudPedido implements ActionListener {
		
		private JFrame frame;
		
		private JLabel labelClientes = new JLabel("Cliente ");
		private List<JCheckBox> clientes = new ArrayList<JCheckBox>();
		private String[] listaNomeClientes = new String[100];
		private JList<String> listaClientes = new JList<String>(listaNomeClientes);
		
		private String[] listaNomePasteis = new String[100];
		private JLabel labelProdutos = new JLabel("Produtos ");
		private JList<String> listaPasteis = new JList<String>(listaNomePasteis);
		
		private String[] listaNomeBebidas = new String[100];
		private JList<String> listaBebidas = new JList<String>(listaNomeBebidas);
		private JButton botaoDeletar = new JButton("Deletar");
		private JButton botaoSalvar = new JButton("Salvar");
		private JScrollPane scrollClientes = new JScrollPane(listaClientes);
		private JScrollPane scrollPasteis = new JScrollPane(listaPasteis);
		private JScrollPane scrollBebidas = new JScrollPane(listaBebidas);
		private String janelaTitulo;
		private int[] novoDado = new int[5];
		private int[] pasteisSelecionados = new int[15];
		private int[] bebidasSelecionadas = new int[15];
		private static DadosController dados;
		private int posicao;
		private int opcao;
		private int numPedido = 0;
		
		public void crudPedido(int es, DadosController d, ViewPedido p, int pos){
			
			int numOfClientes = new ClienteController(dados).getClientes().size();
			posicao = pos;
			opcao = es;
			dados = d;
			
			if (es == 6) janelaTitulo = "Cadastro de Pedido";
			if (es == 8) janelaTitulo = "Edicao de Pedido";
			
			frame = new JFrame(janelaTitulo);
			
			if (es == 6){ //Cadastro de Pedido
				
				labelClientes.setFont(new Font("Arial Black", Font.BOLD, 20));
				for(int i = 0; i < numOfClientes; i++) {
					clientes.add(new JCheckBox(new ClienteController(dados).getNomeCliente(i)));
				}
				listaClientes.setListData(new ClienteController(dados).getAllClientes());
				listaClientes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
				scrollClientes.setPreferredSize(new Dimension(350, 120));
				
				labelProdutos.setFont(new Font("Arial Black", Font.BOLD, 20));
				
				listaPasteis.setListData(new PastelController(dados).getAllPasteis());
				listaPasteis.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				scrollPasteis.setPreferredSize(new Dimension(350, 120));
				
				listaBebidas.setListData(new BebidaController(dados).getAllBebidas());
				listaBebidas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				scrollBebidas.setPreferredSize(new Dimension(350, 120));
				
				
			
			}else if (es == 8) { //Vizualizacao de Pedido
				
				labelProdutos.setFont(new Font("Arial Black", Font.BOLD, 20));
				
				listaPasteis.setListData(new PastelController(dados).getAllPasteis());
				listaPasteis.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
				scrollPasteis.setPreferredSize(new Dimension(350, 120));
				
				listaBebidas.setListData(new BebidaController(dados).getAllBebidas());
				listaBebidas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
				scrollBebidas.setPreferredSize(new Dimension(350, 120));
				
			}
			
			frame.setLayout(new FlowLayout(FlowLayout.CENTER,50,20));
			frame.setSize(400, 600);
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frame.setVisible(true);
			
			frame.add(clientes.get(0));
			frame.add(labelClientes);
			frame.add(labelProdutos);
			frame.add(scrollClientes);
			frame.add(scrollPasteis);
			frame.add(scrollBebidas);
			frame.add(botaoSalvar);
			if(es == 8)
				frame.add(botaoDeletar);
			
			
			botaoSalvar.addActionListener(this);
			botaoDeletar.addActionListener(this);
			
		}
		
		public void actionPerformed(ActionEvent e) {
			
			Object src = e.getSource();
			
			if(src == botaoSalvar) {
				try {
					boolean res;
					
					if(opcao == 6) //cadastro de Pedido
						novoDado[0] = dados.getPasteis().size();
					else // edicao de dado existente
						novoDado[0] = posicao;
					
					novoDado[1] = listaClientes.getSelectedIndex();
					pasteisSelecionados = listaPasteis.getSelectedIndices();
					bebidasSelecionadas = listaBebidas.getSelectedIndices();
					System.out.println(listaClientes.getSelectedIndex());
					System.out.println(pasteisSelecionados);
					System.out.println(bebidasSelecionadas);
					res = dados.editAddPedido(novoDado[0], new ClienteController(dados).getCliente(novoDado[1]),
							new PastelController(dados).getSelectedPasteis(pasteisSelecionados),
							new BebidaController(dados).getSelectedBebidas(bebidasSelecionadas));
					System.out.println(res);
	
					if(res) {
						mensagemSucessoCadastro();
					}
					else mensagemErroCadastro();
	
				} catch (NullPointerException exc1) {
					mensagemErroCadastro();
				} 
			}
	
			if(src == botaoDeletar) {
				boolean res = false;
	
				if (opcao == 8) {//exclui Pedido
					//res = dados.removerPedido(posicao);
					if (res) mensagemSucessoExclusao(); 
					else mensagemErroExclusaoPedido(); 
				}
			}
					
	
		}
		
		
		public void mensagemSucessoExclusao() {
			JOptionPane.showMessageDialog(null, "O Pedido foi excluido com sucesso! :)", null, 
					JOptionPane.INFORMATION_MESSAGE);
			frame.dispose();
		}
	
		public void mensagemSucessoCadastro() {
			JOptionPane.showMessageDialog(null, "O Pedido foi salvo com sucesso! :)", null, 
					JOptionPane.INFORMATION_MESSAGE);
			frame.dispose();
		}
	
		public void mensagemErroCadastro() {
			JOptionPane.showMessageDialog(null,"Erro ao salvar Pedido! :(\n "
					+ "Pode ter acontecido o erro a seguir:  \n"
					+ "N�o houve sele��o de cliente e/ou\n"
					+ "produtos da pastelaria ", null, 
					JOptionPane.ERROR_MESSAGE);
		}
	
		public void mensagemErroExclusaoPedido() {
			JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o Pedido! :(\n " +
			"tente novamente!!", null, 
			JOptionPane.ERROR_MESSAGE);
		}
		

}
 
	