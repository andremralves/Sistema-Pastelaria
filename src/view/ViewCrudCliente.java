package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controller.*;

public class ViewCrudCliente implements ActionListener{
		
		private JFrame frame;
		private JLabel labelNome = new JLabel("Nome ");
		private JTextField inserirNome;
		private JLabel labelCPF = new JLabel("CPF");
		private JTextField inserirCPF;
		private JLabel labelTelefone = new JLabel("Telefone");
		private JTextField inserirDDD;
		private JTextField inserirTelefone;
		private JLabel labelEnd = new JLabel("Endereço \n (estado, cidade, bairro, cep, num ap/casa, nessa ordem): ");
		private JTextField inserirEstado;
		private JTextField inserirCidade;
		private JTextField inserirBairro;
		private JTextField inserirCEP;
		private JTextField inserirNumCsAp;
		private JButton botaoDeletar = new JButton("Deletar");
		private JButton botaoSalvar = new JButton("Salvar");
		private String[] novoDado = new String[9];
		private String janelaTitulo;
		private static DadosController dados;
		private int posicao;
		private int opcao;
		
		public void crudCliente (int es, DadosController d, ViewCliente c, int pos) {
			
			posicao = pos;
			opcao = es;
			dados = d;
			
			if (es == 5) janelaTitulo = "Cadastro de Cliente";
			if (es == 7) janelaTitulo = "Edição de Cliente";
			
			frame = new JFrame(janelaTitulo);
			
			if (es == 7) {//Vizualização de Cliente
				inserirNome = new JTextField(dados.getClientes().get(pos).getnome(), 200);
				inserirCPF = new JTextField(dados.getClientes().get(pos).getCPF(),11);
				inserirDDD = new JTextField(String.valueOf(dados.getClientes().get(pos).getNumTel().getDDD()), 3);
				inserirTelefone = new JTextField(String.valueOf(dados.getClientes().get(pos).getNumTel().getNumero()), 10);
				inserirEstado = new JTextField( String.valueOf(dados.getClientes().get(pos).getEnd().getEstado()), 100);;
				inserirCidade = new JTextField(String.valueOf(dados.getClientes().get(pos).getEnd().getCidade()), 100);;
				inserirBairro = new JTextField(String.valueOf(dados.getClientes().get(pos).getEnd().getBairro()), 100);;
				inserirCEP = new JTextField(String.valueOf(dados.getClientes().get(pos).getEnd().getCEP()), 8);;
				inserirNumCsAp = new JTextField(String.valueOf(dados.getClientes().get(pos).getEnd().getNumCasaAp()), 100);
					
				this.frame.add(botaoSalvar);
				
			}else if (es == 5){ //Cadastro de Cliente

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
			}
			
			labelNome.setBounds(30, 50, 100, 25);
			inserirNome.setBounds(130, 50, 200, 25);
			labelCPF.setBounds(30, 50, 100, 25);
			inserirCPF.setBounds(30, 50, 100, 25);
			labelTelefone.setBounds(30, 50, 100, 25);
			inserirDDD.setBounds(30, 50, 100, 25);
			inserirTelefone.setBounds(30, 50, 100, 25);
			labelEnd.setBounds(30, 50, 100, 25);
		    inserirEstado.setBounds(30, 50, 100, 25);
		    inserirCidade.setBounds(30, 50, 100, 25);
		    inserirBairro.setBounds(30, 50, 100, 25);
            inserirCEP.setBounds(30, 50, 100, 25);
		    inserirNumCsAp.setBounds(30, 50, 100, 25);
		    
		    this.frame.add(labelNome);
		    this.frame.add(inserirNome);
		    this.frame.add(labelCPF);
			this.frame.add(inserirCPF);
			this.frame.add(labelTelefone); 
			this.frame.add(inserirDDD); 
			this.frame.add(inserirTelefone);
			this.frame.add(labelEnd); 
			this.frame.add(inserirEstado);  
			this.frame.add(inserirCidade); 
			this.frame.add(inserirBairro);
            this.frame.add(inserirCEP); 
			this.frame.add(inserirNumCsAp);
			this.frame.add(botaoSalvar);
			
			botaoSalvar.addActionListener(this);
			botaoDeletar.addActionListener(this); 
		}
		
		public void actionPerformed(ActionEvent e) {
			
			Object src = e.getSource();
			
			if(src == botaoSalvar) {
				try {
					boolean res;
					if(opcao == 5) //cadastro de Cliente
						novoDado[0] = Integer.toString(dados.getPasteis().size());
					else if (opcao == 7) { // edicao de dado existente
						novoDado[0] = Integer.toString(posicao);
	
					novoDado[1] =  inserirNome.getText();
					novoDado[2] =  inserirCPF.getText();
					novoDado[3] =  inserirDDD.getText();
					novoDado[3] =  inserirTelefone.getText();
					novoDado[4] =  inserirEstado.getText();
					novoDado[5] =  inserirCidade.getText();
					novoDado[6] =  inserirBairro.getText();
					novoDado[7] =  inserirCEP.getText();
					novoDado[8] =  inserirNumCsAp.getText();
					res = dados.editAddCliente(novoDado);
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
	
				if (opcao == 7) {//exclui aluno
					res = dados.deleteCliente(posicao);
					if (res) mensagemSucessoExclusao(); 
					else mensagemErroExclusaoCliente(); 
				}		
			}
	
		}
		
		public void mensagemSucessoExclusao() {
			JOptionPane.showMessageDialog(null, "O Cliente foi excluido com sucesso! :)", null, 
					JOptionPane.INFORMATION_MESSAGE);
			frame.dispose();
		}
	
		public void mensagemSucessoCadastro() {
			JOptionPane.showMessageDialog(null, "O Cliente foi cadastrado com sucesso! :)", null, 
					JOptionPane.INFORMATION_MESSAGE);
			frame.dispose();
		}
	
		public void mensagemErroCadastro() {
			JOptionPane.showMessageDialog(null,"ERRO AO SALVAR O CLIENTE! :( \n "
					+ "Pode ter ocorrido o erro a seguir:  \n"
					+ "Nem todos os campos foram preenchidos \n", null, 
					JOptionPane.ERROR_MESSAGE);
		}
	
		public void mensagemErroExclusaoCliente() {
			JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o Cliente.\n "
					+ "Verifique se o Cliente está cadastrado\n"
					+ "em nossa loja. Se sim, exclua\n "
					+ "Cadastro e tente novamente.", null, 
					JOptionPane.ERROR_MESSAGE);
		}
		
}
	