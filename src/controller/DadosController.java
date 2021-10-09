package controller;

import java.util.ArrayList;
import model.*;

/**
 * Essa classe possibilitar� o controle de dados Gerais do programa.
 * @author Daniel Rocha Oliveira e Andr� Macedo Rodrigues Alves
 * @version 1.0 (Out 2021)
 *//**
 * Essa classe possibilitar� o controle de dados Gerais do programa.
 * @author Daniel Rocha Oliveira e Andr� Macedo Rodrigues Alves
 * @version 1.0 (Out 2021)
 */

public class DadosController {
	private Dados d = new Dados();
	/**
	 * Esse m�todo ir� chamar o m�todo fillAllData que ir� cadastrar automaticamente os dados aleat�rios.
	 */
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
	/**
	 * M�todo que controla os dados da CRUD dos past�is.
	 * @param pastelInfo String com as informa��es do pastel, vindas da View.
	 * @return retornar� verdadeiro ou falso.
	 */
	public boolean editAddPastel(String[] pastelInfo) {
		if(pastelInfo.length < 6)
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
	/**
	 * M�todo que controla os dados da CRUD dos past�is.
	 * @param bebidaInfo String com as informa��es da bebida, vindas da View.
	 * @return retornar� verdadeiro ou falso.
	 */
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
	/**
	 * M�todo que controla os dados da CRUD dos clientes.
	 * @param clienteInfo String com as informa��es do cliente, vindas da View.
	 * @return retornar� verdadeiro ou falso.
	 */
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
	/**
	 * M�todo que controla os dados dos pedidos.
	 * @param pedidoInfo String com as informa��es do pastel, vindas da View.
	 * @param pedidoCliente String com as informa��es do pastel, vindas da View.
	 * @param pedidoPastel String com as informa��es do pastel, vindas da View.
	 * @param pedidoBebida String com as informa��es da bebida, vindas da View.
	 * @return retornar� verdadeiro ou falso
	 */
	public boolean editAddPedido(int pedidoInfo, Cliente pedidoCliente, ArrayList<Pastel> pedidoPastel, ArrayList<Bebida> pedidoBebida) {
		if(pedidoInfo == -1)
			return false;
		else {
			Pedido p = new Pedido(pedidoCliente, pedidoPastel, pedidoBebida);
			if(pedidoInfo != getPedidos().size())
				d.editPedido(p, pedidoInfo);
			else
				d.AddPedido(p);
			return true;
		}
	}
	/**
	 * M�todo que deleta Pastel.
	 * @param pos inteiro relacionado a posi��o, na ArrayList.
	 * @return retornar� somente verdadeiro.
	 */
	public boolean deletePastel(int pos) {
		if(pos < 0)
			return false;
		else
			d.deletePastel(pos);
		return true;
	}
	/**
	 * M�todo que deleta Bebida.
	 * @param pos inteiro relacionado a posi��o, na ArrayList.
	 * @return retornar� somente verdadeiro.
	 */
	public boolean deleteBebida(int pos) {
		d.deleteBebida(pos);
		return true;
	}
	/**
	 * M�todo que deleta Cliente.
	 * @param pos inteiro relacionado a posi��o, na ArrayList.
	 * @return retornar� somente verdadeiro.
	 */
	public boolean deleteCliente(int pos) {
		d.deleteCliente(pos);
		return true;
	}
	/**
	 * M�todo que deleta Pedido.
	 * @param pos inteiro relacionado a posi��o, na ArrayList.
	 * @return retornar� somente verdadeiro ou falso.
	 */
	public boolean deletePedido(int pos) {
		if(pos < 0 || pos > d.getPedidos().size()) {
			return false;
		} else {
			d.deletePedido(pos);
			return true;
		}
	}
	
}
