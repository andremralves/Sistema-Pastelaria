package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controller.*;

public class ViewCrudProduto implements ActionListener {
		
		private JFrame frame;
		private JLabel labelNumPed = new JLabel("Número do Pedido ");
		private JTextField inserirNumPed;
		private JLabel labelNome = new JLabel("Nome ");
		private JTextField inserirNome;
		private JLabel labelCPF = new JLabel("CPF");
		private JTextField insrirCPF;
		private JLabel labelTelefone = new JLabel("Telefone");
		private JTextField inserirDDD;
		private JTextField inserirTelefone;
		private JLabel labelEnd = new JLabel("Endereço \n (estado, cidade, bairro, cep, num ap/casa, nessa ordem): ");
		private JTextField inserirEstado;
		private JTextField inserirCidade;
		private JTextField inserirBairro;
		private JTextField inserirCEP;
		private JTextField inserirnNumCsAp;
		private JLabel labelNumCard = new JLabel("Numero no Cardapio");
		private JTextField inserirNumCard;
		private JLabel labelPreco = new JLabel("Preco ");
		private JTextField inserirPreco;
		private JLabel labelIng = new JLabel("Ingredientes");
		private JTextField inserirIng;
		private JLabel labelBorda = new JLabel("Deseja adcionar borda?");
		private JButton bordaSim = new JButton("Sim");
		private JButton bordaNao = new JButton("Não");
		private JLabel labelAlc = new JLabel("A bebida é alcoólica?");
		private JButton alcoolSim = new JButton("Sim");
		private JButton alcoolNao = new JButton("Não");
		private JButton botaoDeletar = new JButton("Deletar");
		private JButton botaoSalvar = new JButton("Salvar");
		private String[] novoDado = new String[9];
		private static DadosController dados;
		private int posicao;
		private int opcao;
		private String janelaTitulo;
		
		private void cadastraGeral(int es, DadosController d, ViewProduto p, int pos ){
			
				posicao = pos;
				opcao = es;
				dados = d;
				
			if (es == 1) janelaTitulo = "Cadastro Pastel";
			if (es == 2) janelaTitulo = "Cadastro Bebida";
			if (es == 3) janelaTitulo = "Detalhe Pastel";
			if (es == 4) janelaTitulo = "Detalhe Bebida";
			if (es == 5) janelaTitulo = "Cadastro Cliente";
			if (es == 6) janelaTitulo = "Cadastro de Pedido";
			if (es == 7) janelaTitulo = "Detalhe Cliente";
			if (es == 8) janelaTitulo = "Detalhe do Pedido";

			frame = new JFrame(janelaTitulo);
			
			if (es == 3) {
			inserirNome = new JTextField(dados.getPastel()[pos].getNomePastel(), 200);
			inserirNumCard = new JTextField(dados.getPastel()[pos].getNumeroCardapio(),200);
			inserirPreco = new JTextField(String.valueOf(
					dados.getPastel()[pos].getPreco()),200);
			inserirIng =  new JTextField(dados.getPastel()[pos].getIngredientes(), 200);
						

		} else if (es == 4) { //Preenche dados com dados do professor clicado 
			inserirNome = new JTextField(dados.getBebida()[pos].getNomeBebida(), 200);
			inserirNumCard = new JTextField(dados.getBebida()[pos].getNumeroCardapio(),200);
			inserirPreco = new JTextField(String.valueOf(
					dados.getBebida()[pos].getPreco()),200);
					
		if (es == 7) {
			inserirNome = new JTextField(dados.getCliente()[pos].getNome(), 200);
			inserirCPF = new JTextField(dados.getCliente()[pos].getCPF(),11);
			inserirDDD = new JTextField(
					String.valueOf(dados.getCliente()[pos].getNumTel().getDDD()), 3);
			inserirTelefone = new JTextField(
					String.valueOf(dados.getCliente()[pos].getNumTel().getNumero()), 10);
			inserirEstado = new JTextField(
					String.valueOf(dados.getCliente()[pos].getEndereco().getEstado()), 100);;
			inserirCidade = new JTextField(
					String.valueOf(dados.getCliente()[pos].getEndereco().getCidade()), 100);;
			inserirBairro = new JTextField(
					String.valueOf(dados.getCliente()[pos].getEndereco().getBairro()), 100);;
			inserirCEP = new JTextField(
					String.valueOf(dados.getCliente()[pos].getEndereco().getCEP()), 8);;
			inserirnNumCsAp = new JTextField(
					String.valueOf(dados.getCliente()[pos].getEndereco().getNumeroCasaAp()), 100);;
						

		} else if (es == 8) { //Preenche dados com dados do professor clicado 
			inserirNome = new JTextField(dados.getCliente()[pos].getNome(), 200);
			inserirNumPed = new JTextField(dados.getPedidos()[pos].getNumeroCardapio(),200);
			
		} else if (es == 1){ //Não preenche com dados

			inserirNome = new JTextField(200);
			inserirNumCard = new JTextField(200);
			inserirPreco = new JTextField(200);
		    inserirIng = new JTextField(200);
			
			botaoSalvar.setBounds(245, 175, 115, 30);
		} else if (es == 2){ //Não preenche com dados

			inserirNome = new JTextField(200);
			inserirNumCard = new JTextField(200);
			inserirPreco = new JTextField(200);
			
			botaoSalvar.setBounds(245, 175, 115, 30);
		} else if (es == 5){ //Não preenche com dados

			inserirNome = new JTextField(200);
			inserirCPF = new JTextField(200);
			inserirDDD = new JTextField(3);
		    inserirTelefone = new JTextField(10);
		    inserirEstado = new JTextField(200);
			inserirCidade = new JTextField(200);
			inserirBairro = new JTextField(200);
		    inserirCEP = new JTextField(8);
		    inserirNumCsAp = new JTextField(200);
			
			botaoSalvar.setBounds(245, 175, 115, 30);
		} else if (es == 6){ //Não preenche com dados

			inserirNome = new JTextField(200);
			inserirNumPed = new JTextField(200);
			
			botaoSalvar.setBounds(245, 175, 115, 30);
			
			}
		}
}
}
