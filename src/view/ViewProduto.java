package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.DimensionUIResource;
import controller.*;

public class ViewProduto implements ActionListener, ListSelectionListener{
		
		private static JFrame frame = new JFrame("Janela de Produtos");
		private static JLabel title1 = new JLabel("Pasteis:");
		private static JLabel title2 = new JLabel("Bebidas:");
		private static JButton cadastraPastel = new JButton("Cadastrar");
		private static JButton cadastraBebida = new JButton("Cadastrar");
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
		
		    title1.setFont(new Font("Arial Black", Font.BOLD, 20));
			title2.setFont(new Font("Arial Black", Font.BOLD, 20));
			
			listaNomePastel = new PastelController(dados).getAllPasteis();
			listaPastel = new JList<String>(listaNomePastel);
			listaPastel.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			scrollPastel = new JScrollPane(listaPastel);
			scrollPastel.setPreferredSize(new Dimension(350, 120));
			
			listaNomeBebida = new BebidaController(dados).getAllBebidas();
			listaBebida = new JList<String>(listaNomeBebida);
			listaBebida.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			scrollBebida = new JScrollPane(listaBebida);
			scrollBebida.setPreferredSize(new DimensionUIResource(350, 120));
			
			frame.setLayout(new FlowLayout(FlowLayout.CENTER,50,20));
			
			frame.add(title1);
			frame.add(scrollPastel);
			frame.add(cadastraPastel);
			frame.add(refresh1);
			frame.add(title2);
			frame.add(scrollBebida);
			frame.add(cadastraBebida);
			frame.add(refresh2);
			
			
			frame.setSize(400, 300);
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frame.setVisible(true);
			
			cadastraPastel.addActionListener(this);
			cadastraBebida.addActionListener(this);
			refresh1.addActionListener(this);
			refresh2.addActionListener(this);
			listaPastel.addListSelectionListener(this);
			listaBebida.addListSelectionListener(this);
		}
			
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == cadastraPastel)
			new ViewCrudProduto().crudProduto(1, dados, this, 0);
		
		if(src == cadastraBebida)
			new ViewCrudProduto().crudProduto(2, dados, this, 0);
		
		
		if(src == refresh1)
			listaPastel.setListData(new PastelController(dados).getAllPasteis());			
			listaPastel.updateUI();
		
		if(src == refresh2)
			listaBebida.setListData(new BebidaController(dados).getAllBebidas());			
			listaBebida.updateUI();
		
	}
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaPastel) {
			new ViewCrudProduto().crudProduto(3, dados, this, 
					listaPastel.getSelectedIndex());
		}

		if(e.getValueIsAdjusting() && src == listaBebida) {
			new ViewCrudProduto().crudProduto(4, dados, this, 
					listaBebida.getSelectedIndex());
		}
	}
}
