package controller;

import java.util.ArrayList;

import model.Cliente;

/**
 * Essa classe possibilitará o controle de dados do Cliente.
 * @author Daniel Rocha Oliveira e André Macedo Rodrigues Alves
 * @version 1.0 (Out 2021)
 */

public class ClienteController {
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private int size;
	/**
	 * Esse método armazena os dados dos Clientes no DadosController.
	 * @param d Objeto que chama o controlador DadosController.
	 */
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
	
	public String[] getClientesNames() {
		String[] clientes = new String[size];
		for(int i = 0; i < size; i++) {
			clientes[i] = this.clientes.get(i).getNome();
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
