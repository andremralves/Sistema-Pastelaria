package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewBebida {
		public static void main(String[] args) {
		JFrame frame = new JFrame("Cadastro Bebida");
		frame.setSize(400, 250);


		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}
	
	private static void placeComponents(JPanel panel) {

		panel.setLayout(null);

		JLabel numLabel = new JLabel("Número no cardápio");
		numLabel.setBounds(10, 10, 160, 25);
		panel.add(numLabel);

		JTextField numText = new JTextField(20);
		numText.setBounds(180, 10, 160, 25);
		panel.add(numText);

		JLabel nomeLabel = new JLabel("Nome do produto");
		nomeLabel.setBounds(10, 40, 160, 25);
		panel.add(nomeLabel);
		
		JTextField nomeText = new JTextField(20);
		nomeText.setBounds(180, 40, 160, 25);
		panel.add(nomeText);
		
		JLabel priceLabel = new JLabel("Preço");
		priceLabel.setBounds(10, 70, 160, 25);
		panel.add(priceLabel);

		JTextField priceText = new JTextField(20);
		priceText.setBounds(180, 70, 160, 25);
		panel.add(priceText);

		JLabel alLabel = new JLabel("A bebida é alcoólica? Sim ou Não");
		alLabel.setBounds(10, 100, 200, 25);
		panel.add(alLabel);
			
		JButton simButton = new JButton("sim");
		simButton.setBounds(220, 100, 60, 25);
		panel.add(simButton);
		
		JButton naoButton = new JButton("não");
		naoButton.setBounds(285, 100, 60, 25);
		panel.add(naoButton);
		
		JButton cadastroButton = new JButton("Cadastrar");
		cadastroButton.setBounds(180, 140, 100, 25);
		panel.add(cadastroButton);
	}
}
