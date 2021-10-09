package controller;

import java.util.ArrayList;

import model.Bebida;
import model.Pastel;

/**
 * Essa classe possibilitará o controle de dados da Bebida.
 * @author Daniel Rocha Oliveira e André Macedo Rodrigues Alves
 * @version 1.0 (Out 2021)
 */

public class BebidaController {
	
	private ArrayList<Bebida> bebidas = new ArrayList<Bebida>();
	private int size;
	/**
	 * Esse método armazena os dados das Bebidas no DadosController.
	 * @param d Objeto que chama o controlador DadosController.
	 */
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
	
	public ArrayList<Bebida> getSelectedBebidas(int[] sel) {
		ArrayList<Bebida> pSelecionados = new ArrayList<Bebida>();
		int size = sel.length;
		for(int i = 0; i < size; i++) {
			if(sel[i] != -1)
				pSelecionados.add(bebidas.get(sel[i]));
		}
		return pSelecionados;
	}
	
	public ArrayList<Bebida> getBebidas() {
		return bebidas;
	}
	
	public void setBebidas(ArrayList<Bebida> bebidas) {
		this.bebidas = bebidas;
	}
	
	public int getSize() {
		return 0;
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
