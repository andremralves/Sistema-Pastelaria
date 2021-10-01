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
		String[] Clientes = new String[size];
		for(int i = 0; i < size; i++) {
			Clientes[i] = this.clientes.get(i).toString();
		}
		return Clientes;
	}
	
	public Cliente getCliente(int i) {
		return clientes.get(i);
	}
	
	public void setCliente(Cliente pastel, int i) {
		this.clientes.set(i, pastel);
	}
}
