package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.DimensionUIResource;

import controller.*;
import java.util.ArrayList;

public class ViewProduto implements ActionListener, ListSelectionListener{
		
		private static JFrame frame = new JFrame("Janela de Produtos");
		private static JPanel panel = new JPanel();
		private static JLabel title1 = new JLabel("Pasteis:");
		private static JLabel title2 = new JLabel("Bebidas:");
		private static JButton cadastraPastel = new JButton("Cadastrar");
		private static JButton cadastraBebida = new JButton("Cadastrar");
		private static JButton deleta1 = new JButton("Deletar");
		private static JButton deleta2 = new JButton("Deletar");
		private static JButton refresh1 = new JButton("Refresh");
		private static JButton refresh2 = new JButton("Refresh");
		private JList<String> listaPastel;
		private JList<String> listaBebida;
		private JScrollPane scrollPastel;
		private JScrollPane scrollBebida;
		private String[] listaNomePastel = new String[100];
		private String[] listaNomeBebida = new String[100];
		private static DadosController dados;
		
		
		public void ShowViewProduto(DadosController d){
			
			dados = d;
		
		    title1.setFont(new Font("Arial Black", Font.BOLD, 18));
			title2.setFont(new Font("Arial Black", Font.BOLD, 18));
			
			listaNomePastel = new PastelController(dados).getAllPasteis();
			listaPastel = new JList<String>(listaNomePastel);
			listaPastel.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			scrollPastel = new JScrollPane(listaPastel);
			scrollPastel.setPreferredSize(new Dimension(350, 120));
			
			listaNomeBebida = new BebidaController(dados).getAllBebidas();
			listaBebida = new JList<String>(listaNomeBebida);
			listaBebida.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			scrollBebida = new JScrollPane(listaBebida);
			scrollBebida.setPreferredSize(new Dimension(350, 120));
			
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			
			panel.add(title1);
			panel.add(scrollPastel);
			panel.add(cadastraPastel);
			frame.add(deleta1);
			frame.add(refresh1);
			frame.add(title2);
			frame.add(scrollBebida);
			frame.add(cadastraBebida);
			frame.add(deleta2);
			frame.add(refresh2);
			
			
			frame.setSize(400, 400);
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frame.setVisible(true);
			
			cadastraPastel.addActionListener(this);
			cadastraBebida.addActionListener(this);
			deleta1.addActionListener(this);
			deleta2.addActionListener(this);
			refresh1.addActionListener(this);
			refresh2.addActionListener(this);
		}
			
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == cadastraPastel)
			//new ViewCadastro().cadastraGeral(1, dados, this, 0);
		
		if(src == cadastraBebida)
			//new ViewCadastro().cadastraGeral(2, dados, this, 0);
		
		
		if(src == refresh1)
			//listaPastel.setListData(new PastelController(dados).getPastel());			
			//listaPastel.updateUI();
		
		if(src == refresh2)
			//listaBebida.setListData(new BebidaController(dados).getBebida());			
			listaBebida.updateUI();
		
	}
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaPastel) {
			//new ViewCadastro().cadastraGeral(3, dados, this, 
					//listaPastel.getSelectedIndex());
		}

		if(e.getValueIsAdjusting() && src == listaBebida) {
			//new ViewCadastro().cadastraGeral(4, dados, this, 
					//listaBebida.getSelectedIndex());
		}
	}
}
