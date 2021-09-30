package model;
import java.util.Scanner;

import controller.BebidaController;
import controller.PastelController;
public class Main {
    static Cliente c1;
    static PastelController pas1;
    static BebidaController beb1;
    static Pedido p1;
    
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[]args){
    	
    	pas1 = new PastelController(new Pastel(1, "Pastel de queijo", 5, "queijo", false));
    	beb1 = new BebidaController(new Bebida(2, "Sucao de Laranja", 2.5, false));
        
        System.out.println(pas1.getPastel());
        System.out.println(beb1.getPastel());
        
    }
}
