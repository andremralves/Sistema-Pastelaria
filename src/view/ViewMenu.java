package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import controller.*;

/**
 * Essa classe possibilitar� a intere��o do programa com o usu�rio no Menu Principal.
 * @author Daniel Rocha Oliveira e Andr� Macedo Rodrigues Alves
 * @version 1.0 (Out 2021)
 */

public class ViewMenu implements ActionListener {
		private static JFrame frame = new JFrame("Menu Pastelaria");
		private static JLabel title = new JLabel("Pastelaria");
		private static JButton cliente = new JButton("Cliente");
		private static JButton pedidos = new JButton("Pedidos");
		private static JButton produtos = new JButton("Produtos");
		private static DadosController dados = new DadosController();
		/**
		 * Esse m�todo construtor � respons�vel por conigurar toda
		 * a intera��o com o usu�rio no campo do Menu Principal.
		 */
		public ViewMenu(){
	    title.setFont(new Font("Arial Black", Font.BOLD, 16));
		title.setBounds(60, 10, 100, 30);
		
		cliente.setBounds(50, 50, 100, 30);
		pedidos.setBounds(50, 100, 100, 30);
		produtos.setBounds(50, 150, 100, 30);
		
		frame.setLayout(null);
		
		frame.add(title);
		frame.add(cliente);
		frame.add(pedidos);
		frame.add(produtos);
		
		frame.setSize(200, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
		/**
		 * M�todo main do C�digo, respons�vel pelo in�cio da execu��o desse.
		 * @param args args.
		 */
		public static void main(String[] args) {
			
			ViewMenu menu = new ViewMenu();
			
			cliente.addActionListener(menu);
			pedidos.addActionListener(menu);
			produtos.addActionListener(menu);
	   }
	   /**
		 * M�todo que detecta as a��es nos bot�es para vizualizar as Views, do cliente, pedido
		 * ou produto.
		 */
	   public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == cliente)
			new ViewCliente().ShowViewCliente(dados);;
		
		if(src == pedidos)
			new ViewPedido().ShowViewPedidos(dados);
		
		if(src == produtos)
			new ViewProduto().ShowViewProduto(dados);
		
	}
}
