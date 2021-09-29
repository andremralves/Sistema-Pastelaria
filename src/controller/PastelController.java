package controller;

import model.Pastel;

public class PastelController {
	
	private Pastel pastelModel;
	
	public PastelController(Pastel pastelModel) {
		this.pastelModel = pastelModel;
	}
	
	public Pastel getPastel() {
		return pastelModel;
	}
	
}