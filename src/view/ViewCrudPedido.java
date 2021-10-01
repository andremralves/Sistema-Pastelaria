package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controller.*;

public class ViewCrudPedido implements ActionListener {
		
		private JFrame frame;
		private JLabel labelNumPed = new JLabel("Número do Pedido ");
		private JTextField inserirNumPed;
		private JLabel labelNome = new JLabel("Nome ");
		private JTextField inserirNome;
		private JButton botaoDeletar = new JButton("Deletar");
		private JButton botaoSalvar = new JButton("Salvar");
		private String janelaTitulo;
		private String[] novoDado = new String[9];
		private static DadosController dados;
		private int posicao;
		private int opcao;
		
		public void crudPedido(int es, DadosController d, ViewPedido p, int pos){
			
			posicao = pos;
			opcao = es;
			dados = d;
			
			if (es == 6) janelaTitulo = "Cadastro de Pedido";
			if (es == 8) janelaTitulo = "Edição de Pedido";
			
			frame = new JFrame(janelaTitulo);
			
			if (es == 6){ //Cadastro de Pedido

				inserirNome = new JTextField(200);
				inserirNumPed = new JTextField(200);
				
				botaoSalvar.setBounds(245, 175, 115, 30);
			
			}else if (es == 8) { //Vizualização de Pedido
				inserirNome = new JTextField(dados.getCliente()[pos].getNome(), 200);
				inserirNumPed = new JTextField(dados.getPedidos()[pos].getNumeroCardapio(),200);
				
				botaoSalvar.setBounds(245, 175, 115, 30);
				botaoDeletar.setBounds(245, 175, 115, 30);			
			}
			
			labelNumPed.setBounds(30, 50, 100, 25);
			inserirNumPed.setBounds(130, 50, 200, 25);
			labelNome.setBounds(30, 50, 100, 25);
			inserirNome.setBounds(130, 50, 200, 25);
			
			this.frame.add(labelNumPed);
			this.frame.add(inserirNumPed);
			this.frame.add(labelNome);
			this.frame.add(inserirNome);
			
			botaoSalvar.addActionListener(this);
			botaoDeletar.addActionListener(this);
			
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
					novoDado[4] =  inserirIng.getText();
					novoDado[5] =  Boolean.toString(borda.isSelected());
	
					if (opcao == 1 || opcao == 3) {
						novoDado[4] =  inserirIng.getText();
						novoDado[5] =  Boolean.toString(borda.isSelected());
						res = dados.editAddPastel(novoDado);;
					} else {
						novoDado[2] =  inserir.getText();
						res = dados.inserirEditarProf(novoDado);
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
	
				if (opcao == 3) {//exclui aluno
					res = dados.removerAluno(posicao);
					if (res) mensagemSucessoExclusao(); 
					else mensagemErroExclusaoAluno(); 
				}
					
				if (opcao == 4){ //exclui professor
					res = dados.removerProfessor(posicao);
					if (res) mensagemSucessoExclusao(); 
					else mensagemErroExclusaoProf(); 
				}
					
			}
	
		}
		
		public void mensagemSucessoExclusao() {
			JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, 
					JOptionPane.INFORMATION_MESSAGE);
			frame.dispose();
		}
	
		public void mensagemSucessoCadastro() {
			JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
					JOptionPane.INFORMATION_MESSAGE);
			frame.dispose();
		}
	
		public void mensagemErroCadastro() {
			JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
					+ "Pode ter ocorrido um dos dois erros a seguir:  \n"
					+ "1. Nem todos os campos foram preenchidos \n"
					+ "2. CPF, identidade, DDD e telefone não contém apenas números", null, 
					JOptionPane.ERROR_MESSAGE);
		}
	
		public void mensagemErroExclusaoAluno() {
			JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n "
					+ "Verifique se o aluno está matriculado\n"
					+ "em alguma disciplina. Se sim, cancele\n "
					+ "a matricula e tente novamente.", null, 
					JOptionPane.ERROR_MESSAGE);
		}
		
		public void mensagemErroExclusaoProf() {
			JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n "
					+ "Verifique se o professor está responsável\n"
					+ "por alguma disciplina. Se sim, substitua\n "
					+ "o professor e tente novamente.", null, 
					JOptionPane.ERROR_MESSAGE);
		}
}
 
	