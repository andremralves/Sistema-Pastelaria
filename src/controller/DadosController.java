package controller;

import model.*;
import java.util.ArrayList;

public class DadosController {
	private Dados d = new Dados();
	
	public DadosController() {
		d.fillAllData();
	}
	
	public Dados getDados() {
		return d;
	}
	
	public void setDados(Dados d) {
		this.d = d;
	}
	
	public ArrayList<Pastel> getPasteis() {
		return d.getPasteis();
	}
	
	public ArrayList<Bebida> getBebidas() {
		return d.getBebidas();
	}
	
	public ArrayList<Cliente> getClientes() {
		return d.getClientes();
	}
	
	public ArrayList<Pedido> getPedidos() {
		return d.getPedidos();
	}
	
	//Metodos CRUD
	public boolean editAddPastel(String[] pastelInfo) {
		if(pastelInfo == null)
			return false;
		else {
			Pastel p = new Pastel(Integer.parseInt(pastelInfo[1]), pastelInfo[2], Double.parseDouble(pastelInfo[3]),
					pastelInfo[4], Boolean.parseBoolean(pastelInfo[5]));
			if(Integer.parseInt(pastelInfo[0]) != getPasteis().size())
				d.editPastel(p, Integer.parseInt(pastelInfo[0]));
			else
				d.addPastel(p);
			return true;
		}
	}
	
	public boolean editAddBebida(String[] bebidaInfo) {
		if(bebidaInfo == null)
			return false;
		else {
			Bebida b = new Bebida(Integer.parseInt(bebidaInfo[1]), bebidaInfo[2], Double.parseDouble(bebidaInfo[3]),
					Boolean.parseBoolean(bebidaInfo[4]));
			if(Integer.parseInt(bebidaInfo[0]) != getBebidas().size())
				d.editBebida(b, Integer.parseInt(bebidaInfo[0]));
			else
				d.addBebida(b);
			return true;
		}
	}
	
	public boolean editAddCliente(String[] clienteInfo) {
		if(clienteInfo == null)
			return false;
		else {
			Cliente c = new Cliente(clienteInfo[1], clienteInfo[2],
					new Telefone(clienteInfo[3], clienteInfo[4]),
					new Endereco(clienteInfo[5], clienteInfo[6], clienteInfo[7],
							clienteInfo[8], Integer.parseInt(clienteInfo[9])));
			if(Integer.parseInt(clienteInfo[0]) != getClientes().size())
				d.editCliente(c, Integer.parseInt(clienteInfo[0]));
			else
				d.AddCliente(c);
			return true;
		}
	}
	
	public boolean deletePastel(int pos) {
		d.deletePastel(pos);
		return true;
	}
	
	public boolean deleteBebida(int pos) {
		d.deleteBebida(pos);
		return true;
	}
	
	public boolean deleteCliente(int pos) {
		d.deleteCliente(pos);
		return true;
	}
	
}
