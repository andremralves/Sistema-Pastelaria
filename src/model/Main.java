package model;
import java.util.Scanner;

import controller.BebidaController;
import controller.PastelController;
public class Main {
    static Cliente c1;
    static PastelController pas1;
    static BebidaController beb1;
    static Pedido p1;
    static Dados d = new Dados();
    
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[]args){
    	d.fillAllData();
    	
    	d.getBebidas().remove(0);  
    	d.getBebidas().remove(0);
    	
    	for(int i = 0; i < d.getPasteis().size(); i++) {
    		System.out.println(d.getPasteis().get(i));
    	}
    	for(int i = 0; i < d.getBebidas().size(); i++) {
    		System.out.println(d.getBebidas().get(i));
    	}
        
    }
}
