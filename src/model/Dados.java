package model;
import java.util.ArrayList;

/**
 * Classe responsável por armazenar todos os dados do programa, além de preencher as Arrays List com os dados aleatórios.
 * @author Daniel Rocha Oliveira e André Mcedo Rodrigues Alves
 * @version 1.0 (Out 2021)
 */

public class Dados {
	
	private ArrayList<Pastel> pasteis = new ArrayList<Pastel>();
	private ArrayList<Bebida> bebidas = new ArrayList<Bebida>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	private ArrayList<Telefone> telefones = new ArrayList<Telefone>();
	private ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
	
	/**
	 * Esse método fillAllData é responsável pelo preenchimento aleatório de dados para os pasteis, bebidas
	 * clientes, telefones, endereços e pedidos.
	 * Foi feito um for para preecher os dados de produtos e clientes e um outro para pedidos, indo de 1 a 5,
	 * pois são 5 dados aleatórios para cada objeto.
	 * No preenchimento de pedidos, está sendo copiados os dados de clientes e produtos.
	 */
	
	public void fillAllData() {
		int numeroCardapio = 1;
		for(int i = 0; i < 5; i++) {
			pasteis.add(new Pastel(numeroCardapio++, "Pastel-" + (i+1), 5.50, "ingredientes", (i+1)%2 == 0 ? true : false));
			bebidas.add(new Bebida(numeroCardapio + 8, "Bebida-" + (i+1), 2.50, (i+1)%2 == 0 ? true : false));
			telefones.add(new Telefone("061", "0000000" + (i+1)));
			enderecos.add(new Endereco("DF", "Brasilia", "bairro-" + (i+1), "00000-00" + (i+1), (i+1)));				
			clientes.add(new Cliente("Cliente-" + (i+1), "1231231230" + (i+1), telefones.get((i)), enderecos.get((i))));
			
		}
		//Preencher Pedidos
		ArrayList<Pastel> pedidoPasteis = new ArrayList<Pastel>();
		ArrayList<Bebida> pedidoBebidas = new ArrayList<Bebida>();
		for(int i = 0; i < 3; i++) {
			pedidoPasteis.add(pasteis.get(i));
			pedidoBebidas.add(bebidas.get(i));
		}
		for(int i = 0; i < 5; i++)
			pedidos.add(new Pedido(clientes.get(i), pedidoPasteis, pedidoBebidas));
		
	}
	
	public ArrayList<Pastel> getPasteis() {
		return pasteis;
	}
	
	public void setPasteis( ArrayList<Pastel> pasteis) {
		this.pasteis = pasteis;
	}
	
	public ArrayList<Bebida> getBebidas() {
		return bebidas;
	}
	
	public void setBebidas( ArrayList<Bebida> bebidas) {
		this.bebidas = bebidas;
	}
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	public void setClientes( ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}
	
	public void setPedidos( ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	//CRUD Pastel
	/**
	 * Esse método está sendo responsável por cadastrar um Pastel.
	 * @param p é um objeto Pastel.
	 */
	public void addPastel(Pastel p) {
		this.pasteis.add(p);
	}
	/**
	 * Esse método está sendo responsável por editar os dados de algum pastel.
	 * @param p é um obejto Pastel a ser editado.
	 * @param pos é a posição do determinado pastel que será alterado.
	 */
	public void editPastel(Pastel p, int pos) {
		this.pasteis.set(pos, p);
	}
	/**
	 * Esse método será responsável por deletar o Pastel selecionado.
	 * @param pos se refere a posição do pastel que será deletado.
	 */
	public void deletePastel(int pos) {
		this.pasteis.remove(pos);
	}
	
	//CRUD Bebida
	/**
	 * Esse método está sendo responsável por cadastrar uma Bebida.
	 * @param b é um objeto Bebida.
	 */
	public void addBebida(Bebida b) {
		this.bebidas.add(b);
	}
	/**
	 * Esse método está sendo responsável por editar os dados de alguma Bebida.
	 * @param b é um obejto Bebida a ser editado.
	 * @param pos é a posição da determinada Bebida que será alterada.
	 */
	public void editBebida(Bebida b, int pos) {
		this.bebidas.set(pos, b);
	}
	/**
	 * Esse método será responsável por deletar a Bebida selecionadaa
	 * @param pos se refere a posição da Bebida que será deletada.
	 */
	public void deleteBebida(int pos) {
		this.bebidas.remove(pos);
	}
	
	//CRUD Cliente
	/**
	 * Esse método está sendo responsável por cadastrar um Cliente.
	 * @param c é um objeto Cliente.
	 */
	public void AddCliente(Cliente c) {
		this.clientes.add(c);
	}
	/**
	 * Esse método está sendo responsável por editar os dados do Cliente selecionado.
	 * @param c é um obejto Cliente a ser editado.
	 * @param pos é a posição do determinado Cliente que será alterado.
	 */
	public void editCliente(Cliente c, int pos) {
		this.clientes.set(pos, c);
	}
	/**
	 * Esse método será responsável por deletar o Cliente selecionado.
	 * @param pos se refere a posição do Cliente que será deletado.
	 */
	public void deleteCliente(int pos) {
		this.clientes.remove(pos);
	}
	
	//CRUD Pedidos
	/**
	 * Esse método está sendo responsável por cadastrar um Pedido.
	 * @param p é um objeto Pedido.
	 */
	public void AddPedido(Pedido p) {
		this.pedidos.add(p);
	}
	/**
	 * Esse método está sendo responsável por editar os dados de algum pedido.
	 * @param p é um obejto Pedido a ser editado.
	 * @param pos é a posição do determinado pedido que será alterado.
	 */
	public void editPedido(Pedido p, int pos) {
		this.pedidos.set(pos, p);
	}
	/**
	 * Esse método será responsável por deletar o Pedido selecionado.
	 * @param pos se refere a posição do pedido que será deletado.
	 */
	public void deletePedido(int pos) {
		this.pedidos.remove(pos);
	}
	
}
