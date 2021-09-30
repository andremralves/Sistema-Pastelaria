package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controller.*;
import java.util.ArrayList;

public class ViewProduto implements ActionListener, ListSelectionListener{
		
		private static JFrame frame = new JFrame("Janela de Produtos");
		private static JLabel title1 = new JLabel("Pastel");
		private static JLabel title2 = new JLabel("Bebida");
		private static JButton cadastra1 = new JButton("Cadastrar");
		private static JButton cadastra2 = new JButton("Cadastrar");
		private static JButton deleta1 = new JButton("Deletar");
		private static JButton deleta2 = new JButton("Deletar");
		private static JButton refresh1 = new JButton("Refresh");
		private static JButton refresh2 = new JButton("Refresh");
		private JList<String> listaPastel;
		private JList<String> listaBebida;
		private String[] listaNomePastel = new String[100];
		private String[] listaNomeBebida = new String[100];
		private static DadosController dados;
		
		
		public ViewProduto(DadosController d){
		
		dados = d;
		
	    title1.setFont(new Font("Arial Black", Font.BOLD, 12));
		title1.setBounds(50, 10, 300, 30);
		title2.setFont(new Font("Arial Black", Font.BOLD, 12));
		title2.setBounds(50, 220, 300, 30);
		cadastra1.setBounds(50, 180, 100, 30);
		cadastra2.setBounds(50, 350, 100, 30);
		deleta1.setBounds(160, 180, 100, 30);
		deleta2.setBounds(160, 350, 100, 30);
		refresh1.setBounds(270, 180, 100, 30);
		refresh2.setBounds(270, 350, 100, 30);
		
		listaPastel.setBounds(50, 50, 350, 120);
		listaPastel.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaPastel.setVisibleRowCount(10);
		listaNomePastel = new DadosController(dados).getNome();
		listaPastel = new JList<String>(listaNomePastel);
		
		
		listaBebida.setBounds(50, 50, 350, 120);
		listaBebida.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaBebida.setVisibleRowCount(10);
		listaNomeBebida = new DadosController(dados).getNome();
		listaBebida = new JList<String>(listaNomeBebida);
		
		frame.setLayout(null);
		
		frame.add(title1);
		frame.add(title2);
		frame.add(cadastra1);
		frame.add(cadastra2);
		frame.add(deleta1);
		frame.add(deleta2);
		frame.add(refresh1);
		frame.add(refresh2);
		frame.add(listaPastel);
		frame.add(listaBebida);
		
		
		frame.setSize(500, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		cadastra1.addActionListener(this);
		cadastra2.addActionListener(this);
		deleta1.addActionListener(this);
		deleta2.addActionListener(this);
		refresh1.addActionListener(this);
		refresh2.addActionListener(this);
		}
			
		public static void main(String[] args) {
				
			ViewProduto produto = new ViewProduto();
				
			cadastra1.addActionListener(produto);
			cadastra2.addActionListener(produto);
			deleta1.addActionListener(produto);
			deleta2.addActionListener(produto);
			refresh1.addActionListener(produto);
			refresh2.addActionListener(produto);
		}
		
		
	
		public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == cadastra1)
			new ViewCadastro();
		
		if(src == cadastra2)
			new ViewCadastro().cadrasta(2);
		
		if(src == deleta1)
			new ViewDeleta().DadosController((dados, 3);
			
		if(src == deleta2)
			new ViewDeleta().DadosController((dados, 1);
		
		if(src == refresh1)
			new ViewPedido().DadosController((dados, 2);
		
		if(src == refresh2)
			new ViewProduto().controlador3(dados, 3);
		
	}
}
