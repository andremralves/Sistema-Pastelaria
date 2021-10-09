package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controller.*;

/**
 * Essa classe possibilitará a intereção do programa com o usuário no quesito CRUD do Cliente.
 * @author Daniel Rocha Oliveira e André Macedo Rodrigues Alves
 * @version 1.0 (Out 2021)
 */

public class ViewCrudCliente implements ActionListener{
		
		private JFrame frame;
		private JLabel labelNome = new JLabel("Nome ");
		private JTextField inserirNome;
		private JLabel labelCPF = new JLabel("CPF");
		private JTextField inserirCPF;
		private JLabel labelTelefone = new JLabel("Telefone");
		private JTextField inserirDDD;
		private JTextField inserirTelefone;
		private JLabel labelEnd = new JLabel("Endereco \n (estado, cidade, bairro, cep, num ap/casa, nessa ordem): ");
		private JTextField inserirEstado;
		private JTextField inserirCidade;
		private JTextField inserirBairro;
		private JTextField inserirCEP;
		private JTextField inserirNumCsAp;
		private JButton botaoDeletar = new JButton("Deletar");
		private JButton botaoSalvar = new JButton("Salvar");
		private String[] novoDado = new String[10];
		private String janelaTitulo;
		private static DadosController dados;
		private int posicao;
		private int opcao;
		
		/**
		 * Esse método é responsável pelo Cadastro, Edição e Exclusão do Cliente.
		 * Possui casos de escolha, para cada caso, uma tela diferente, seja cadastro ou edição.
		 * No campo de cadastro, estarão disponíveis aréas para cadastrar um novo cliente, 
		 * ja para edição, os dados cadastrados ja virão escritos, porém será possível alterá-los
		 * livremente.
		 * @param es inteiro referente a escplha ( cadastro ou edição).
		 * @param d Objeto vindo do controlador DadosController.
		 * @param c Objeto que chama a ViewCliente
		 * @param pos inteiro relacionado a posição do dado em sua ArrayList
		 */
		
		public void crudCliente (int es, DadosController d, ViewCliente c, int pos) {
			
			posicao = pos;
			opcao = es;
			dados = d;
			
			if (es == 5) janelaTitulo = "Cadastro de Cliente";
			if (es == 7) janelaTitulo = "Edicao de Cliente";
			
			frame = new JFrame(janelaTitulo);
			
			if (es == 7) {//Vizualizaï¿½ï¿½o de Cliente
				inserirNome = new JTextField(dados.getClientes().get(pos).getNome(), 200);
				inserirCPF = new JTextField(dados.getClientes().get(pos).getCPF(),11);
				inserirDDD = new JTextField(String.valueOf(dados.getClientes().get(pos).getNumTel().getDDD()), 3);
				inserirTelefone = new JTextField(String.valueOf(dados.getClientes().get(pos).getNumTel().getNumero()), 10);
				inserirEstado = new JTextField( String.valueOf(dados.getClientes().get(pos).getEnd().getEstado()), 100);;
				inserirCidade = new JTextField(String.valueOf(dados.getClientes().get(pos).getEnd().getCidade()), 100);;
				inserirBairro = new JTextField(String.valueOf(dados.getClientes().get(pos).getEnd().getBairro()), 100);;
				inserirCEP = new JTextField(String.valueOf(dados.getClientes().get(pos).getEnd().getCEP()), 8);;
				inserirNumCsAp = new JTextField(String.valueOf(dados.getClientes().get(pos).getEnd().getNumCasaAp()), 100);
				
				botaoSalvar.setBounds(30, 240, 100, 30);
				botaoDeletar.setBounds(140, 240, 100, 30);	
				this.frame.add(botaoDeletar);
				
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
						
				botaoSalvar.setBounds(30, 240, 100, 30);
			}
			
			labelNome.setBounds(30, 50, 100, 25);
			inserirNome.setBounds(130, 50, 100, 25);
			labelCPF.setBounds(30, 80, 100, 25);
			inserirCPF.setBounds(130, 80, 100, 25);
			labelTelefone.setBounds(30, 110, 100, 25);
			inserirDDD.setBounds(130, 110, 30, 25);
			inserirTelefone.setBounds(160, 110, 70, 25);
			labelEnd.setBounds(30, 140, 400, 25);
		    inserirEstado.setBounds(30, 170, 100, 25);
		    inserirCidade.setBounds(130, 170, 100, 25);
		    inserirBairro.setBounds(30, 200, 100, 25);
            inserirCEP.setBounds(130, 200, 100, 25);
		    inserirNumCsAp.setBounds(230, 200, 100, 25);
		    
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
			
			this.frame.setLayout(null);
			this.frame.setSize(500, 400);
			this.frame.setVisible(true);
			
			botaoSalvar.addActionListener(this);
			botaoDeletar.addActionListener(this); 
		}
		/**
		 * Método que captura a ação dos botões de cadastrar, quer seja para
		 * editar, quer seja para cadastrar um novo usuário. Também pode capturar
		 * a ação no botão deletar, excuindo o cliente selecionado.
		 */
		public void actionPerformed(ActionEvent e) {
			
			Object src = e.getSource();
			
			if(src == botaoSalvar) {
				try {
					boolean res;
					if(opcao == 5) //cadastro de Cliente
						novoDado[0] = Integer.toString(dados.getPasteis().size());
					else if (opcao == 7) // edicao de dado existente
						novoDado[0] = Integer.toString(posicao);
					
					novoDado[1] =  inserirNome.getText();
					novoDado[2] =  inserirCPF.getText();
					novoDado[3] =  inserirDDD.getText();
					novoDado[4] =  inserirTelefone.getText();
					novoDado[5] =  inserirEstado.getText();
					novoDado[6] =  inserirCidade.getText();
					novoDado[7] =  inserirBairro.getText();
					novoDado[8] =  inserirCEP.getText();
					novoDado[9] =  inserirNumCsAp.getText();
					res = dados.editAddCliente(novoDado);
	
					if(res) {
						mensagemSucessoCadastro();
					}
					else mensagemErroCadastro();
	
				} catch (NullPointerException exc1) {
					mensagemErroCadastro();
				}
			}
	
			if(src == botaoDeletar) {
				boolean res = false;
	
				if (opcao == 7) {//exclui Cliente
					res = dados.deleteCliente(posicao);
					if (res) mensagemSucessoExclusao(); 
					else mensagemErroExclusaoCliente(); 
				}		
			}
	
		}
		/**
		 * Método que faz aparecer uma menssagem de sucesso ao excuir.
		 */
		public void mensagemSucessoExclusao() {
			JOptionPane.showMessageDialog(null, "O Cliente foi excluido com sucesso! :)", null, 
					JOptionPane.INFORMATION_MESSAGE);
			frame.dispose();
		}
		/**
		 * Método que faz aparecer uma menssagem de sucesso ao cadastrar.
		 */
		public void mensagemSucessoCadastro() {
			JOptionPane.showMessageDialog(null, "O Cliente foi cadastrado com sucesso! :)", null, 
					JOptionPane.INFORMATION_MESSAGE);
			frame.dispose();
		}
		/**
		 * Método que faz aparecer uma menssagem de erro ao cadastrar.
		 */
		public void mensagemErroCadastro() {
			JOptionPane.showMessageDialog(null,"ERRO AO SALVAR O CLIENTE! :( \n "
					+ "Pode ter ocorrido o erro a seguir:  \n"
					+ "Nem todos os campos foram preenchidos \n", null, 
					JOptionPane.ERROR_MESSAGE);
		}
		/**
		 * Método que faz aparecer uma menssagem de erro ao excuir.
		 */
		public void mensagemErroExclusaoCliente() {
			JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o Cliente.\n "
					+ "Verifique se o Cliente estï¿½ cadastrado\n"
					+ "em nossa loja. Se sim, exclua\n "
					+ "Cadastro e tente novamente.", null, 
					JOptionPane.ERROR_MESSAGE);
		}
		
}
	