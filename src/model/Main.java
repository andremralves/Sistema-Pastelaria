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
        
    	for(int i = 0; i < 8; i++) {
    		System.out.println(d.getPasteis().get(i));
    	}
    	for(int i = 0; i < 8; i++) {
    		System.out.println(d.getBebidas().get(i));
    	}
        
    }
}
