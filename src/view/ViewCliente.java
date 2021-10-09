package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controller.*;

/**
 * Essa classe possibilitará a intereção do programa com o usuário no quesito Cliente.
 * @author Daniel Rocha Oliveira e André Macedo Rodrigues Alves
 * @version 1.0 (Out 2021)
 */

public class ViewCliente implements ActionListener, ListSelectionListener {
	
		private static JFrame frame = new JFrame("Janela de Cliente");
		private static JLabel title = new JLabel("Clientes");
		private static JButton cadastraCliente = new JButton("Cadastrar");		
		private static JButton refresh = new JButton("Refresh");
		private static JTable clientesTable = new JTable();
		private static String[] listaNomeCliente = new String[100];
		private static JList<String> listaCliente = new JList<String>(listaNomeCliente);
		private static JScrollPane scrollCliente = new JScrollPane(listaCliente);
		private static DadosController dados;
		
		/**
		 * Esse método é responsável por configurar tudo que interagir com o usuário,
		 * tela, botões, áreas de texto, etc.
		 * @param d Objeto que recebe os dados do controlador DadosController.
		 */
		public void ShowViewCliente(DadosController d){
			
			dados = d;
		
		    title.setFont(new Font("Arial Black", Font.BOLD, 20));
			cadastraCliente.setPreferredSize(new Dimension(150, 30));
			refresh.setPreferredSize(new Dimension(150, 30));
		    
			listaNomeCliente = new ClienteController(dados).getAllClientes();
			listaCliente.setListData(listaNomeCliente);
			listaCliente.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			scrollCliente.setPreferredSize(new Dimension(350, 200));
			
			frame.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
			
			frame.add(title);
			frame.add(scrollCliente);
			frame.add(cadastraCliente);
			frame.add(refresh);
			
			
			
			frame.setSize(400, 380);
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frame.setVisible(true);
			
			cadastraCliente.addActionListener(this);
			refresh.addActionListener(this);
			listaCliente.addListSelectionListener(this);
			
		}
		/**
		 * Esse método, importando uma swing, visa as ações de clique em botões, tendo um caso para cada clique, cada caso 
		 * irá executar uma ação diferente. Para o cadastro, irá abrir uma outra tela, com o cadastro do cliente.
		 * Para o refresh, irá atulizar as informações que se modificaram.
		 */
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();
			
			if(src == cadastraCliente)
				new ViewCrudCliente().crudCliente(5, dados, this, 0);
			
			
			if(src == refresh)
				listaCliente.setListData(new ClienteController(dados).getAllClientes());			
				listaCliente.updateUI();
			
			
		}
		/**
		 * Esse método captura ações provienientes de cliques na Lista de clientes.~
		 * O clique resultará na aba de edição de cliente.
		 */
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaCliente) {
			new ViewCrudCliente().crudCliente(7, dados, this,
					listaCliente.getSelectedIndex());
		}

	}
}


