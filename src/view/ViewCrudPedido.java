package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controller.*;

public class ViewCrudPedido implements ActionListener {
		
		private JFrame frame;
		private JLabel labelClientes = new JLabel("Cliente ");
		private JList<String> listaClientes;
		private String[] listaNomeClientes = new String[100];
		private JLabel labelProdutos = new JLabel("Produtos ");
		private JList<String> listaPasteis;
		private String[] listaNomePasteis = new String[100];
		private JList<String> listaBebidas;
		private String[] listaNomeBebidas = new String[100];
		private JButton botaoDeletar = new JButton("Deletar");
		private JButton botaoSalvar = new JButton("Salvar");
		private JScrollPane scrollClientes;
		private JScrollPane scrollPasteis;
		private JScrollPane scrollBebidas;
		private String janelaTitulo;
		private int[] novoDado = new int[5];
		private int[] pasteisSelecionados = new int[15];
		private int[] bebidasSelecionadas = new int[15];
		private static DadosController dados;
		private int posicao;
		private int opcao;
		private int numPedido = 0;
		
		public void crudPedido(int es, DadosController d, ViewPedido p, int pos){
			
			posicao = pos;
			opcao = es;
			dados = d;
			
			if (es == 6) janelaTitulo = "Cadastro de Pedido";
			if (es == 8) janelaTitulo = "Edição de Pedido";
			
			frame = new JFrame(janelaTitulo);
			
			if (es == 6){ //Cadastro de Pedido
				
				labelClientes.setFont(new Font("Arial Black", Font.BOLD, 20));
				listaNomeClientes = new ClienteController(dados).getAllClientes();
				listaClientes = new JList<String>(listaNomeClientes);
				listaClientes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
				scrollClientes = new JScrollPane(listaClientes);
				scrollClientes.setPreferredSize(new Dimension(350, 120));
				
				labelProdutos.setFont(new Font("Arial Black", Font.BOLD, 20));
				
				listaNomePasteis = new PastelController(dados).getAllPasteis();
				listaPasteis = new JList<String>(listaNomePasteis);
				listaPasteis.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
				scrollPasteis = new JScrollPane(listaPasteis);
				scrollPasteis.setPreferredSize(new Dimension(350, 120));
				
				listaNomeBebidas = new BebidaController(dados).getAllBebidas();
				listaBebidas = new JList<String>(listaNomeBebidas);
				listaBebidas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
				scrollBebidas = new JScrollPane(listaBebidas);
				scrollBebidas.setPreferredSize(new Dimension(350, 120));
				
				
			
			}else if (es == 8) { //Vizualização de Pedido
				
				labelProdutos.setFont(new Font("Arial Black", Font.BOLD, 20));
				
				listaNomePasteis = new PedidoController(dados).getAllPedidos();
				listaPasteis = new JList<String>(listaNomePasteis);
				listaPasteis.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				scrollPasteis = new JScrollPane(listaPasteis);
				scrollPasteis.setPreferredSize(new Dimension(350, 120));
				
				listaNomeBebidas = new BebidaController(dados).getAllBebidas();
				listaBebidas = new JList<String>(listaNomeBebidas);
				listaBebidas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				scrollBebidas = new JScrollPane(listaBebidas);
				scrollBebidas.setPreferredSize(new Dimension(350, 120));
				
				frame.add(botaoDeletar);
				
			}
			
			frame.setLayout(new FlowLayout(FlowLayout.CENTER,50,20));
			frame.setSize(400, 600);
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frame.setVisible(true);
			
			
			frame.add(labelClientes);
			frame.add(labelProdutos);
			frame.add(scrollClientes);
			frame.add(scrollPasteis);
			frame.add(scrollBebidas);
			frame.add(botaoSalvar);
			frame.add(botaoDeletar);
			
			
			botaoSalvar.addActionListener(this);
			botaoDeletar.addActionListener(this);
			//listaPasteis.addListSelectionListener(this);
			//listaClientes.addListSelectionListener(this);
			//listaBebidas.addListSelectionListener(this);
			
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
					pasteisSelecionados[0] = listaPasteis.getSelectedIndex();
					bebidasSelecionadas[0] = listaBebidas.getSelectedIndex();
					System.out.println(listaClientes.getSelectedIndex());
					System.out.println(pasteisSelecionados[0]);
					System.out.println(bebidasSelecionadas[0]);
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
					+ "Não houve seleção de cliente e/ou\n"
					+ "produtos da pastelaria ", null, 
					JOptionPane.ERROR_MESSAGE);
		}
	
		public void mensagemErroExclusaoPedido() {
			JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o Pedido! :(\n " +
			"tente novamente!!", null, 
			JOptionPane.ERROR_MESSAGE);
		}
		

}
 
	