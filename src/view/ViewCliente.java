package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewCliente {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Menu Cliente");
		frame.setSize(350, 250);


		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}
	private static void placeComponents(JPanel panel) {

		panel.setLayout(null);

		JLabel nomeLabel = new JLabel("Nome do Cliente");
		nomeLabel.setBounds(10, 10, 180, 25);
		panel.add(nomeLabel);

		JTextField nomeText = new JTextField(20);
		nomeText.setBounds(110, 10, 170, 25);
		panel.add(nomeText);

		JLabel cpfLabel = new JLabel("CPF do Cliente");
		cpfLabel.setBounds(10, 40, 160, 25);
		panel.add(cpfLabel);
		
		JTextField cpfText = new JTextField(20);
		cpfText.setBounds(100, 40, 180, 25);
		panel.add(cpfText);
		
		JLabel endLabel = new JLabel("Endereço");
		endLabel.setBounds(10, 70, 160, 25);
		panel.add(endLabel);

		JTextField endText = new JTextField(20);
		endText.setBounds(100, 70, 180, 25);
		panel.add(endText);

		JLabel telLabel = new JLabel("Telefone");
		telLabel.setBounds(10, 100, 160, 25);
		panel.add(telLabel);
			
		JTextField telText = new JTextField(20);
		telText.setBounds(100, 100, 180, 25);
		panel.add(telText);
		
		JButton cadastroButton = new JButton("Cadastrar");
		cadastroButton.setBounds(180, 140, 100, 25);
		panel.add(cadastroButton);
	}
}


