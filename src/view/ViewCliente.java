package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.DimensionUIResource;
import controller.*;

public class ViewCliente implements ActionListener, ListSelectionListener {
	
		private static JFrame frame = new JFrame("Janela de Cliente");
		private static JLabel title = new JLabel("Clientes:");
		private static JButton cadastraNome = new JButton("Cadastrar");		
		private static JButton refresh = new JButton("Refresh");
		private JList<String> listaCliente;
		private JScrollPane scrollCliente;
		private String[] listaNomeCliente = new String[100];
		private static DadosController dados;
		
		
		public void ShowViewCliente(DadosController d){
			
			dados = d;
		
		    title.setFont(new Font("Arial Black", Font.BOLD, 20));
			listaNomeCliente = new ClienteController(dados).getAllClientes();
			listaCliente = new JList<String>(listaNomeCliente);
			listaCliente.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			scrollCliente = new JScrollPane(listaCliente);
			scrollCliente.setPreferredSize(new Dimension(350, 200));
			
			frame.setLayout(new FlowLayout(FlowLayout.CENTER,50,20));
			
			frame.add(title);
			frame.add(scrollCliente);
			frame.add(cadastraNome);
			frame.add(refresh);
			
			
			
			frame.setSize(400, 400);
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frame.setVisible(true);
			
			cadastraNome.addActionListener(this);
			refresh.addActionListener(this);
			listaCliente.addListSelectionListener(this);
			
		}
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();
			
			if(src == cadastraNome)
				new ViewCrudCliente().crudCliente(5, dados, this, 0);
			
			
			if(src == refresh)
				listaCliente.setListData(new ClienteController(dados).getAllClientes());			
				listaCliente.updateUI();
			
			
		}
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaCliente) {
			new ViewCrudCliente().crudCliente(7, dados, this, 
					listaCliente.getSelectedIndex());
		}

	}
}


