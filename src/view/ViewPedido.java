package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet.ColorAttribute;
import controller.*;

/**
 * Essa classe possibilitará a intereção do programa com o usuário na View do Pedido.
 * @author Daniel Rocha Oliveira e André Macedo Rodrigues Alves
 * @version 1.0 (Out 2021)
 */

public class ViewPedido implements ActionListener {
	
		private static JFrame frame;
		private static JLabel title = new JLabel("Pedido");
		private static JTable pedidosTable;
		private static DefaultTableModel model;
		private static Object[] columns = {"Nº Pedido", "Cliente", "Pasteis", "Bebidas", "Total"};
		private static JScrollPane pane;
		private static JPanel centerPanel;
		private static JPanel pasteisPanel;
		private static JPanel bebidasPanel;
		private static JPanel btnsPanel;
		private static JScrollPane scrollPastel;
		private static JScrollPane scrollBebida;
		private static JButton btnCadastrar;
		private static JButton btnEditar;
		private static JButton btnDeletar;
		private static JComboBox<String> clientesBox;
		private static JCheckBox[] chkPasteis = new JCheckBox[30];
		private static JCheckBox[] chkBebidas = new JCheckBox[30];
		private static JPanel southPanel;
		private int clienteSelecionado;
		
		private static DadosController dados;
		/**
		 * Este método é o responsável por configurar a interação com o usuário, mostrando
		 * tabelas e botões.
		 * @param d Objeto que chama os dados do controlador DadosController.
		 */
		public void ShowViewPedidos(DadosController d){
			
			dados = d;
			
			//Janela
			frame = new JFrame("Janela de Pedidos");
			frame.setSize(680, 300);
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			
			//Modelo da tabela
			setModel();
			
			//Tabela dos pedidos
			pedidosTable = new JTable();
			pedidosTable.setModel(model);
			setJTable();
			addElementesToTable();
			
			//Scroll Table Pane
			pane = new JScrollPane(pedidosTable);
			pane.setForeground(Color.red);
			pane.setBackground(Color.white);
			pane.setBounds(10,10,10,10);
			
			//Box clientes
			clientesBox = new JComboBox<String>(new ClienteController(dados).getClientesNames());
			
			//Check Box
			pasteisPanel = new JPanel();
			bebidasPanel = new JPanel();
			pasteisPanel.setLayout(new BoxLayout(pasteisPanel, BoxLayout.Y_AXIS));
			bebidasPanel.setLayout(new BoxLayout(bebidasPanel, BoxLayout.Y_AXIS));
			for(int i = 0; i < new PastelController(dados).getPasteis().size(); i++) {
				chkPasteis[i] = new JCheckBox(new PastelController(dados).getPastel(i).getNome());
				pasteisPanel.add(chkPasteis[i]);
			}
			
			for(int i = 0; i < new BebidaController(dados).getBebidas().size(); i++) {
				chkBebidas[i] = new JCheckBox(new BebidaController(dados).getBebida(i).getNome());
				bebidasPanel.add(chkBebidas[i]);
			}
			scrollPastel = new JScrollPane(pasteisPanel);
			scrollPastel.setPreferredSize(new Dimension(100, 100));
			scrollBebida = new JScrollPane(bebidasPanel);
			scrollBebida.setPreferredSize(new Dimension(100, 100));
			
			//Titulo
		    title.setFont(new Font("Arial Black", Font.BOLD, 20));
		    
		    //Botões
		    btnCadastrar = new JButton("Cadastrar");
		    btnEditar = new JButton("Editar");
		    btnDeletar = new JButton("Deletar");
		    btnCadastrar.setPreferredSize(new Dimension(100,30));
		    btnEditar.setPreferredSize(new Dimension(100,30));
		    btnDeletar.setPreferredSize(new Dimension(100,30));
		    
		    //Painel dos botões
		    btnsPanel = new JPanel();
		    btnsPanel.add(btnCadastrar);
			btnsPanel.add(btnDeletar);
			btnsPanel.add(btnEditar);
			
			//Painel do Centro
			centerPanel = new JPanel();
			centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
			centerPanel.add(pane);
			centerPanel.add(btnsPanel);
			
			//Painel de baixo
			southPanel = new JPanel();
			southPanel.setPreferredSize(new Dimension(150, 100));
			southPanel.add(clientesBox);
			southPanel.add(scrollPastel);
			southPanel.add(scrollBebida);
			
			
			frame.add(centerPanel, BorderLayout.CENTER);
			frame.add(southPanel, BorderLayout.WEST);

			
			frame.setVisible(true);
			
			btnCadastrar.addActionListener(this);
			btnDeletar.addActionListener(this);
			btnEditar.addActionListener(this);
			
		}
		
		public void setModel() {
			model = new DefaultTableModel() {
			    /**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
			};
			model.setColumnIdentifiers(columns);
		}
		
		public void setJTable() {
			pedidosTable.setAutoCreateRowSorter(true);
			pedidosTable.setGridColor(Color.black);
			pedidosTable.getColumnModel().getColumn(0).setPreferredWidth(10);
			pedidosTable.getColumnModel().getColumn(1).setPreferredWidth(10);
			pedidosTable.getColumnModel().getColumn(4).setPreferredWidth(8);
		}
		
		/**
		*Esse método adiciona os elementos cadastrados a tabela.
		*/
		public void addElementesToTable() {
			Object[][] tableData = new Object[dados.getPedidos().size()][5];
			for(int i = 0; i < dados.getPedidos().size(); i++) {
				tableData[i][0] = dados.getPedidos().get(i).getNumeroPedido();
				tableData[i][1] = dados.getPedidos().get(i).getClienteSelecionado().getNome();
				tableData[i][2] = dados.getPedidos().get(i).getPasteisNames();
				tableData[i][3] = dados.getPedidos().get(i).getBebidasNames();
				tableData[i][4] = dados.getPedidos().get(i).getValorTotal();
				model.addRow(tableData[i]);
			}
		}
		/**
		 * Esse método capta as ações nos botões de cadastrar um pedido
		 * ou atualizar a página.
		 */
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();
			int[] pasteisSelecionados = new int[dados.getPasteis().size()];
			int[] bebidasSelecionadas = new int[dados.getPasteis().size()];
			boolean res;
			int size = dados.getPedidos().size();
			int row = pedidosTable.getSelectedRow();
			
			clienteSelecionado = clientesBox.getSelectedIndex();
			for(int i = 0; i < dados.getPasteis().size(); i++) {
				if(chkPasteis[i].isSelected())
					pasteisSelecionados[i] = i;
				else
					pasteisSelecionados[i] = -1;
			}
			
			for(int i = 0; i < dados.getBebidas().size(); i++) {
				if(chkBebidas[i].isSelected()) 
					bebidasSelecionadas[i] = i;
				else
					bebidasSelecionadas[i] = -1;

			}
			
			if(src == btnCadastrar) {
				
				clienteSelecionado = clientesBox.getSelectedIndex();
				res = dados.editAddPedido(size, new ClienteController(dados).getCliente(clienteSelecionado),
						new PastelController(dados).getSelectedPasteis(pasteisSelecionados),
						new BebidaController(dados).getSelectedBebidas(bebidasSelecionadas));
				setModel();
				pedidosTable.setModel(model);
				setJTable();
				addElementesToTable();
				if(res) mensagemSucessoCadastro();
				else mensagemErroCadastro();
			}
			
			if(src == btnDeletar) {
				res = dados.deletePedido(row);
				setModel();
				pedidosTable.setModel(model);
				setJTable();
				addElementesToTable();
				if(res) mensagemSucessoExclusao();
				else mensagemErroExclusaoPedido();
			}
			
			if(src == btnEditar) {
				
				res = dados.editAddPedido(row, new ClienteController(dados).getCliente(clienteSelecionado),
						new PastelController(dados).getSelectedPasteis(pasteisSelecionados),
						new BebidaController(dados).getSelectedBebidas(bebidasSelecionadas));
				setModel();
				pedidosTable.setModel(model);
				setJTable();
				addElementesToTable();
			}
			
			
		}
		/**
		 * Método que faz aparecer uma menssagem de sucesso ao excuir.
		 */
		public void mensagemSucessoExclusao() {
			JOptionPane.showMessageDialog(null, "O Pedido foi excluido com sucesso! :)", null, 
					JOptionPane.INFORMATION_MESSAGE);
		}
		/**
		 * Método que faz aparecer uma menssagem de sucesso ao cadastrar.
		 */
		public void mensagemSucessoCadastro() {
			JOptionPane.showMessageDialog(null, "O Pedido foi salvo com sucesso! :)", null, 
					JOptionPane.INFORMATION_MESSAGE);
		}
		/**
		 * Método que faz aparecer uma menssagem de erro ao cadastrar.
		 */
		public void mensagemErroCadastro() {
			JOptionPane.showMessageDialog(null,"Erro ao salvar Pedido! :(\n "
					+ "Pode ter acontecido o erro a seguir:  \n"
					+ "Nao houve selecao de cliente e/ou\n"
					+ "produtos da pastelaria ", null, 
					JOptionPane.ERROR_MESSAGE);
		}
		/**
		 * Método que faz aparecer uma menssagem de erro ao excuir.
		 */
		public void mensagemErroExclusaoPedido() {
			JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o Pedido!\n " +
			"Verifique se você selecionou algum pedido da lista.", null, 
			JOptionPane.ERROR_MESSAGE);
		}
		
}
