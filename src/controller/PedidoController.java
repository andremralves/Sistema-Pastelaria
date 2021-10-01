package controller;

import java.util.ArrayList;

import model.Pedido;

public class PedidoController {
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	private int size;
	
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
