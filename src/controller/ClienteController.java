package controller;

import java.util.ArrayList;

import model.Cliente;

public class ClienteController {
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private int size;
	
	public ClienteController(DadosController d) {
		this.clientes = d.getClientes();
		this.size = clientes.size();
	}
	
	//Arrays
	public String[] getAllClientes() {
		String[] clientes = new String[size];
		for(int i = 0; i < size; i++) {
			clientes[i] = this.clientes.get(i).toString();
		}
		return clientes;
	}
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public Cliente getCliente(int i) {
		return clientes.get(i);
	}
	
	public void setCliente(Cliente Cliente, int i) {
		this.clientes.set(i, Cliente);
	}
	
	public String getNomeCliente(int i) {
		return clientes.get(i).getNome();
	}
	
	public void setNomeCliente(String nomeCliente, int i) {
		this.clientes.get(i).setNome(nomeCliente);
	}
}
