package model;
import java.util.Scanner;

import controller.BebidaController;
import controller.PastelController;
public class Main {
    static Cliente c1;
    static PastelController pas1;
    static BebidaController beb1;
    static Pedido p1;
    static Pastel p;
    static Dados d = new Dados();
    
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[]args){
    	d.fillAllData();
    	
    	for(int i = 0; i < d.getPasteis().size(); i++) {
    		System.out.println(d.getPasteis().get(i));
    	}
    	System.out.println();
    	p = new Pastel(9, "Pastel-" + 9, 5.50, "ingredientes", false);
    	
    	for(int i = 0; i < d.getPasteis().size(); i++) {
    		System.out.println(d.getPasteis().get(i));
    	}
        
    }
}
