package controller;

import model.Pastel;
import java.util.ArrayList;
/**
 * Essa classe possibilitará o controle de dados do Pastel.
 * @author Daniel Rocha Oliveira e André Macedo Rodrigues Alves
 * @version 1.0 (Out 2021)
 */
public class PastelController {
	
	private ArrayList<Pastel> pasteis = new ArrayList<Pastel>();
	private int size;
	/**
	 * Esse método armazena os dados dos Pastéis no DadosController.
	 * @param d Objeto que chama o controlador DadosController.
	 */
	public PastelController(DadosController d) {
		this.pasteis = d.getPasteis();
		this.size = pasteis.size();
	}
	
	//Arrays
	public String[] getAllPasteis() {
		String[] pasteis = new String[size];
		for(int i = 0; i < size; i++) {
			pasteis[i] = this.pasteis.get(i).toString();
		}
		return pasteis;
	}
	
	public String[] getAllNames() {
		String[] names = new String[size];
		for(int i = 0; i < size; i++) {
			names[i] = pasteis.get(i).getNome();
		}
		return names;
	}
	
	public ArrayList<Pastel> getSelectedPasteis(int[] sel) {
		ArrayList<Pastel> pSelecionados = new ArrayList<Pastel>();
		int size = sel.length;
		for(int i = 0; i < size; i++) {
			if(sel[i] != -1)
				pSelecionados.add(pasteis.get(sel[i]));
		}
		return pSelecionados;
	}
	
	public ArrayList<Pastel> getPasteis() {
		return pasteis;
	}
	
	public void setPasteis(ArrayList<Pastel> pasteis) {
		this.pasteis = pasteis;
	}
	
	//Informações Individuais
	public Pastel getPastel(int i) {
		return pasteis.get(i);
	}
	
	public void setPastel(Pastel pastel, int i) {
		this.pasteis.set(i, pastel);
	}
	
	public int getNumeroCardapio(int i) {
		return pasteis.get(i).getNumeroCardapio();
	}
	
	public void setNumeroCardapio(int numeroCardapio, int i) {
		this.pasteis.get(i).setNumeroCardapio(numeroCardapio);;
	}
	
	public String getNomePastel(int i) {
		return pasteis.get(i).getNome();
	}
	
	public void setNomePastel(String nomePastel, int i) {
		this.pasteis.get(i).setNome(nomePastel);
	}
	
	public double getPreco(int i) {
		return pasteis.get(i).getPreco();
	}
	
	public void setPreco(double preco, int i) {
		this.pasteis.get(i).setPreco(preco);
	}
	
	public String getIngredientes(int i) {
		return pasteis.get(i).getIngredientes();
	}
	
	public void setIngredientes(String ingredientes, int i) {
		this.pasteis.get(i).setIngredientes(ingredientes);
	}
	
	public boolean getBorda(int i) {
		return pasteis.get(i).getBorda();
	}
	
	public void setBorda(boolean borda, int i) {
		this.pasteis.get(i).setBorda(borda);;
	}
	
}