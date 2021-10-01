package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.DimensionUIResource;
import controller.*;

public class ViewPedido implements ActionListener, ListSelectionListener {
	
		private static JFrame frame = new JFrame("Janela de Pedidos");
		private static JLabel title = new JLabel("Pedido:");
		private static JButton cadastraPedido = new JButton("Cadastrar");		
		private static JButton refresh = new JButton("Refresh");
		private JList<String> listaPedido;
		private JScrollPane scrollPedido;
		private String[] listaNomePedido = new String[100];
		private static DadosController dados;
		
		public void ShowViewCliente(DadosController d){
			
			dados = d;
		
		    title.setFont(new Font("Arial Black", Font.BOLD, 20));
			listaNomePedido = new ClienteController(dados).getAllClientes();
			listaPedido = new JList<String>(listaNomePedido);
			listaPedido.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			scrollPedido = new JScrollPane(listaPedido);
			scrollPedido.setPreferredSize(new Dimension(350, 120));
			
			frame.setLayout(new FlowLayout(FlowLayout.CENTER,50,20));
			
			frame.add(title);
			frame.add(scrollPedido);
			frame.add(cadastraPedido);
			frame.add(refresh);
			
			
			
			frame.setSize(400, 550);
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frame.setVisible(true);
			
			cadastraPedido.addActionListener(this);
			refresh.addActionListener(this);
			listaPedido.addListSelectionListener(this);
			
		}
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();
			
			if(src == cadastraPedido)
				new ViewCrudPedido().crudPedido(6, dados, this, 0);
			
			
			if(src == refresh)
				listaPedido.setListData(new PedidoController(dados).getAllPedidos());			
				listaPedido.updateUI();
			
			
		}
		public void valueChanged(ListSelectionEvent e) {
			Object src = e.getSource();
	
			if(e.getValueIsAdjusting() && src == listaPedido) {
				new ViewCrudPedido().crudPedido(8, dados, this, 
						listaPedido.getSelectedIndex());
			}
	
		}
		
}
