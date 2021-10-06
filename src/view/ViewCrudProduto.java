package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controller.*;

public class ViewCrudProduto implements ActionListener {
		
		private JFrame frame;	
		private JLabel labelNome = new JLabel("Nome ");
		private JTextField inserirNome;
		private JLabel labelNumCard = new JLabel("Numero no Cardapio");
		private JTextField inserirNumCard;
		private JLabel labelPreco = new JLabel("Preco ");
		private JTextField inserirPreco;
		private JLabel labelIng = new JLabel("Ingredientes");
		private JTextField inserirIng;
		private JLabel labelBorda = new JLabel("Deseja adcionar borda?");
		private JCheckBox borda = new JCheckBox("Adicionar");
		private JLabel labelAlc = new JLabel("A bebida eh alcoolica?");
		private JCheckBox alcool = new JCheckBox("Sim");
		private JButton botaoDeletar = new JButton("Deletar");
		private JButton botaoSalvar = new JButton("Salvar");
		private String[] novoDado = new String[9];
		private static DadosController dados;
		private int posicao;
		private int opcao;
		private String janelaTitulo;
		
		public void crudProduto(int es, DadosController d, ViewProduto p, int pos ){
			
			  	posicao = pos;
				opcao = es;
				dados = d;
					
				if (es == 1) janelaTitulo = "Cadastro Pastel";
				if (es == 2) janelaTitulo = "Cadastro Bebida";
				if (es == 3) janelaTitulo = "Detalhe Pastel";
				if (es == 4) janelaTitulo = "Detalhe Bebida";
	
				frame = new JFrame(janelaTitulo);
				
				if (es == 3) { // Mostra Dados do Patel Clicado
				inserirNome = new JTextField(dados.getPasteis().get(pos).getNome(), 200);
				inserirNumCard = new JTextField(Integer.toString(
						dados.getPasteis().get(pos).getNumeroCardapio()),200);
				inserirPreco = new JTextField(String.valueOf(
						dados.getPasteis().get(pos).getPreco()),200);
				inserirIng =  new JTextField(dados.getPasteis().get(pos).getIngredientes(), 200);
				if(dados.getPasteis().get(pos).getBorda() == true)
					borda.setSelected(true);
					
				
				
							
	
			} else if (es == 4) { //Mostra Dados da Bebida Clicada
				inserirNome = new JTextField(dados.getBebidas().get(pos).getNome(), 200);
				inserirNumCard = new JTextField(Integer.toString(
					dados.getBebidas().get(pos).getNumeroCardapio()),200);
				inserirPreco = new JTextField(String.valueOf(
						dados.getBebidas().get(pos).getPreco()),200);
				if(dados.getBebidas().get(pos).getAlcoolics() == true)
					alcool.setSelected(true);
			
							
	
			} else if (es == 1){ //Cadastro Pastel
	
				inserirNome = new JTextField(200);
				inserirNumCard = new JTextField(200);
				inserirPreco = new JTextField(200);
			    inserirIng = new JTextField(200);
				
				
				botaoSalvar.setBounds(245, 175, 115, 30);
				
			} else if (es == 2){ //Cadastro Bebida
	
				inserirNome = new JTextField(200);
				inserirNumCard = new JTextField(200);
				inserirPreco = new JTextField(200);
				
				
				botaoSalvar.setBounds(245, 175, 115, 30);
		 	}
		 	
		 	labelNome.setBounds(30, 50, 100, 25);
			inserirNome.setBounds(130, 50, 200, 25);
			labelNumCard.setBounds(30, 20, 200, 25);
			inserirNumCard.setBounds(230, 20, 100, 25);
			labelPreco.setBounds(30, 80, 100, 25);
			inserirPreco.setBounds(130, 80, 200, 25);
			
			if(opcao == 1 || opcao == 3) {
				labelIng.setBounds(30, 110, 200, 25);
				inserirIng.setBounds(130, 110, 200, 25);
				borda.setBounds(255, 140, 120, 25);
				labelBorda.setBounds(30, 140, 200, 25);
			} else {
				labelAlc.setBounds(30, 140, 200, 25);
				alcool.setBounds(230, 140, 80, 25);
			}
			
			botaoSalvar.setBounds(180, 200, 100, 25);

			
			  
			if (es == 1 || es == 3 ) {
				this.frame.add(labelIng);
				this.frame.add(inserirIng);
				this.frame.add(labelBorda);
				this.frame.add(borda);


			}
	
		
			if (es == 2 || es == 4) {
				this.frame.add(labelAlc);
				this.frame.add(alcool);

			}
	
		
			if (es == 3 || es == 4) {
				botaoSalvar.setBounds(100, 170, 100, 25);
				botaoDeletar.setBounds(210, 170, 100, 25);
				this.frame.add(botaoDeletar);
			}
			
			this.frame.add(labelNome);
			this.frame.add(inserirNome);
			this.frame.add(labelNumCard);
			this.frame.add(inserirNumCard);
			this.frame.add(labelPreco);
			this.frame.add(inserirPreco);
			this.frame.add(botaoSalvar);
			
			
			this.frame.setLayout(null);
			this.frame.setSize(400, 300);
			this.frame.setVisible(true);
	
			botaoSalvar.addActionListener(this);
			botaoDeletar.addActionListener(this);
			borda.addActionListener(this);
			alcool.addActionListener(this);

			
			//System.out.print(borda.isSelected());
			
		}
		
		public void actionPerformed(ActionEvent e) {
			
			Object src = e.getSource();
			
			if(src == botaoSalvar) {
				try {
					boolean res;
					if(opcao == 1) //cadastro de Pastel
						novoDado[0] = Integer.toString(dados.getPasteis().size());
					else if (opcao == 2) // cadastro de bebida
						novoDado[0] = Integer.toString(dados.getBebidas().size());
					else // edicao de dado existente
						novoDado[0] = Integer.toString(posicao);
	
					novoDado[1] =  inserirNumCard.getText();
					novoDado[2] =  inserirNome.getText();
					novoDado[3] =  inserirPreco.getText();
	
					if (opcao == 1 || opcao == 3) {
						novoDado[4] =  inserirIng.getText();
						novoDado[5] =  Boolean.toString(borda.isSelected());
						res = dados.editAddPastel(novoDado);
					} else {
						novoDado[4] =  Boolean.toString(alcool.isSelected());
						res = dados.editAddBebida(novoDado);
					}
						
	
					if(res) {
						mensagemSucessoCadastro();
					}
					else mensagemErroCadastro();
	
				} catch (NullPointerException exc1) {
					mensagemErroCadastro();
				} catch (NumberFormatException exc2) {
					mensagemErroCadastro();
				}
			}
	
			if(src == botaoDeletar) {
				boolean res = false;
	
				if (opcao == 3) {//exclui Pastel
					res = dados.deletePastel(posicao);
					if (res) mensagemSucessoExclusao(); 
					else mensagemErroExclusaoPastel(); 
				}
					
				if (opcao == 4){ //exclui Bebida
					res = dados.deleteBebida(posicao);
					if (res) mensagemSucessoExclusao(); 
					else mensagemErroExclusaoBebida(); 
				}
	
	
				
			}
	}
		
		public void mensagemSucessoExclusao() {
			JOptionPane.showMessageDialog(null, "Os produtos foram excluidos com sucesso! =)", null, 
					JOptionPane.INFORMATION_MESSAGE);
			frame.dispose();
		}

		public void mensagemSucessoCadastro() {
			JOptionPane.showMessageDialog(null, "Os produtos foram cadastrados com sucesso! =)", null, 
					JOptionPane.INFORMATION_MESSAGE);
			frame.dispose();
		}

		public void mensagemErroCadastro() {
			JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS Produtos! =( \n "
					+ "Pode ter ocorrido o erro a seguir:  \n"
					+ "1. Nem todos os campos foram preenchidos!! \n", null, 
					JOptionPane.ERROR_MESSAGE);
		}

		public void mensagemErroExclusaoPastel() {
			JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o Pastel!! :(\n "
					+ "Veja se o pastel est� cadastrado\n"
					+ "na loja. Caso esteja, exclua\n "
					+ "o pastel e tente novamente.", null, 
					JOptionPane.ERROR_MESSAGE);
		}
		
		public void mensagemErroExclusaoBebida() {
			JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir a bebida!! :(\n "
					+ "Verifique se a bebida est� cadastrada\n"
					+ "na loja. Caso esteja , exclua\n "
					+ "a ba eebida e tente novamente.", null, 
					JOptionPane.ERROR_MESSAGE);
		}
		
}

