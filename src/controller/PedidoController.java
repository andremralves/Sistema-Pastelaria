package controller;

import java.util.ArrayList;

import model.Pedido;

/**
 * Essa classe possibilitar� o controle de dados do Pedido.
 * @author Daniel Rocha Oliveira e Andr� Macedo Rodrigues Alves
 * @version 1.0 (Out 2021)
 */

public class PedidoController {
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	private int size;
	/**
	 * Esse m�todo armazena os dados dos Pedidos no DadosController.
	 * @param d Objeto que chama o controlador DadosController.
	 */
	public PedidoController(DadosController d) {
		this.pedidos = d.getPedidos();
		this.size = pedidos.size();
	}
	
	//Arrays
	public String[] getAllPedidos() {
		String[] Pedidos = new String[size];
		for(int i = 0; i < size; i++) {
			Pedidos[i] = this.pedidos.get(i).toString();
		}
		return Pedidos;
	}
	
	public Pedido getPedido(int i) {
		return pedidos.get(i);
	}
	
	public void setPedido(Pedido pedido, int i) {
		this.pedidos.set(i, pedido);
	}
}
