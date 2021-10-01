package controller;

import java.util.ArrayList;

import model.Bebida;

public class BebidaController {
	
	private ArrayList<Bebida> bebidas = new ArrayList<Bebida>();
	private int size;
	
	public BebidaController(DadosController d) {
		this.bebidas = d.getBebidas();
		this.size = bebidas.size();
	}
	
	//Arrays
	public String[] getAllBebidas() {
		String[] bebidas = new String[size];
		for(int i = 0; i < size; i++) {
			bebidas[i] = this.bebidas.get(i).toString();
		}
		return bebidas;
	}
	
	public String[] getAllNames() {
		String[] names = new String[size];
		for(int i = 0; i < size; i++) {
			names[i] = bebidas.get(i).getNome();
		}
		return names;
	}
	
	public Bebida getBebida(int i) {
		return bebidas.get(i);
	}
	
	public void setBebida(Bebida pastel, int i) {
		this.bebidas.set(i, pastel);
	}
	
	public int getNumeroCardapio(int i) {
		return bebidas.get(i).getNumeroCardapio();
	}
	
	public void setNumeroCardapio(int numeroCardapio, int i) {
		this.bebidas.get(i).setNumeroCardapio(numeroCardapio);;
	}
	
	public String getNomeBebida(int i) {
		return bebidas.get(i).getNome();
	}
	
	public void setNomeBebida(String nomeBebida, int i) {
		this.bebidas.get(i).setNome(nomeBebida);
	}
	
	public double getPreco(int i) {
		return bebidas.get(i).getPreco();
	}
	
	public void setPreco(double preco, int i) {
		this.bebidas.get(i).setPreco(preco);
	}
}
