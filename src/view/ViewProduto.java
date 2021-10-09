package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.DimensionUIResource;
import controller.*;

/**
 * Essa classe possibilitará a intereção do programa com o usuário na View do Produto.
 * @author Daniel Rocha Oliveira e André Macedo Rodrigues Alves
 * @version 1.0 (Out 2021)
 */

public class ViewProduto implements ActionListener, ListSelectionListener{
		
		private static JFrame frame = new JFrame("Janela de Produtos");
		private static JLabel title1 = new JLabel("Pasteis");
		private static JLabel title2 = new JLabel("Bebidas");
		private static JButton cadastraPastel = new JButton("Cadastrar");
		private static JButton cadastraBebida = new JButton("Cadastrar");
		private static JButton refresh1 = new JButton("Refresh");
		private static JButton refresh2 = new JButton("Refresh");
		private static String[] lista = new String[100];
		private static JList<String> listaPastel = new JList<String>(lista);
		private static JList<String> listaBebida = new JList<String>(lista);
		private static JScrollPane scrollPastel = new JScrollPane(listaPastel);
		private static JScrollPane scrollBebida = new JScrollPane(listaBebida);
		private static DadosController dados;
		
		/**
		 * Este método será responsável pela interação do usuários com as informações
		 * dos Produtos, beibida e pastel.
		 * @param d Objeto que chama os dados do controlador DadosController.
		 */
		public void ShowViewProduto(DadosController d){
			
			dados = d;
		
		    title1.setFont(new Font("Arial Black", Font.BOLD, 20));
			title2.setFont(new Font("Arial Black", Font.BOLD, 20));
			cadastraPastel.setPreferredSize(new Dimension(150, 30));
			refresh1.setPreferredSize(new Dimension(150, 30));
			cadastraBebida.setPreferredSize(new Dimension(150, 30));
			refresh2.setPreferredSize(new Dimension(150, 30));
			
			listaPastel.setListData(new PastelController(dados).getAllPasteis());
			listaPastel.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			scrollPastel.setPreferredSize(new Dimension(350, 120));
			
			listaBebida.setListData(new BebidaController(dados).getAllBebidas());
			listaBebida.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			scrollBebida.setPreferredSize(new DimensionUIResource(350, 120));
			
			frame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
			
			frame.add(title1);
			frame.add(scrollPastel);
			frame.add(cadastraPastel);
			frame.add(refresh1);
			frame.add(title2);
			frame.add(scrollBebida);
			frame.add(cadastraBebida);
			frame.add(refresh2);
			
			
			frame.setSize(400, 550);
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frame.setVisible(true);
			
			cadastraPastel.addActionListener(this);
			cadastraBebida.addActionListener(this);
			refresh1.addActionListener(this);
			refresh2.addActionListener(this);
			listaPastel.addListSelectionListener(this);
			listaBebida.addListSelectionListener(this);
		}
			
	/**
	 * Método que capta as ações nos botões, para cadastrar bebida ou pastel, abrindo
	 * uma página de CRUD do produto em questão, ou atualizar a página.
	 */
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
	/**
	 * Método que capta ações nas listas de Pastel ou Bebida, abrindo a pegina de edição
	 * do produto em questão.
	 */
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
