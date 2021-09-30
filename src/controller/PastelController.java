package controller;

import model.Pastel;
import java.util.ArrayList;

public class PastelController {
	
	private ArrayList<Pastel> pasteis = new ArrayList<Pastel>();
	
	public PastelController(DadosController d) {
		this.pasteis = d.getPasteis();
	}
	
	public Pastel getPastel() {
		return pastelModel;
	}
	
}