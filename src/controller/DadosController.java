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
	
}
