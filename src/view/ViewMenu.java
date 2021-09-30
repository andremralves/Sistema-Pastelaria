package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import controller.*;

public class ViewMenu implements ActionListener {
		private static JFrame frame = new JFrame("Menu Pastelaria");
		private static JLabel title = new JLabel("Pastelaria da Rodoviária");
		private static JButton cliente = new JButton("Cliente");
		private static JButton pedidos = new JButton("Pedidos");
		private static JButton produtos = new JButton("Produtos");
		private static DadosController dados = new DadosController();
		
		public ViewMenu(){
	    title.setFont(new Font("Arial Black", Font.BOLD, 16));
		title.setBounds(100, 10, 300, 30);
		cliente.setBounds(50, 50, 100, 30);
		pedidos.setBounds(160, 50, 100, 30);
		produtos.setBounds(270, 50, 100, 30);
		
		frame.setLayout(null);
		
		frame.add(title);
		frame.add(cliente);
		frame.add(pedidos);
		frame.add(produtos);
		
		frame.setSize(400, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
		
		public static void main(String[] args) {
			
			ViewMenu menu = new ViewMenu();
			
			cliente.addActionListener(menu);
			pedidos.addActionListener(menu);
			produtos.addActionListener(menu);
	   }
	   
	   public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == cliente)
			new ViewCliente(dados);
		
		if(src == pedidos)
			new ViewPedido(dados);
		
		if(src == produtos)
			new ViewProduto(dados);
		
	}
}
