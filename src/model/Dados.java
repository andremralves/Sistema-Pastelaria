package model;
import java.util.ArrayList;

public class Dados {
	private ArrayList<Pastel> pasteis = new ArrayList<Pastel>();
	private ArrayList<Bebida> bebidas = new ArrayList<Bebida>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	private ArrayList<Telefone> telefones = new ArrayList<Telefone>();
	private ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
	
	public void fillAllData() {
		int numeroCardapio = 1;
		for(int i = 0; i < 8; i++) {
			pasteis.add(new Pastel(numeroCardapio++, "Pastel-" + (i+1), 5.50, "ingredientes", (i+1)%2 == 0 ? true : false));
			bebidas.add(new Bebida(numeroCardapio + 8, "Bebida-" + (i+1), 2.50, (i+1)%2 == 0 ? true : false));
			telefones.add(new Telefone("061", "0000000" + (i+1)));
			enderecos.add(new Endereco("DF", "Brasilia", "bairro-" + (i+1), "00000-00" + (i+1), (i+1)));				
			clientes.add(new Cliente("Cliente-" + (i+1), "1231231230" + (i+1), telefones.get((i)), enderecos.get((i))));
		}
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
}