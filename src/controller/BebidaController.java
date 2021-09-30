package controller;

import model.Bebida;

public class BebidaController {
	
	private Bebida bebidaModel;
	
	public BebidaController(Bebida bebidaModel) {
		this.bebidaModel = bebidaModel;
	}
	
	public Bebida getPastel() {
		return bebidaModel;
	}

}
