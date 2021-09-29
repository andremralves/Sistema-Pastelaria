package model;
import java.util.Scanner;
import controller.PastelController;
public class Main {
    static Cliente c1;
    static PastelController pasCon;
    static Bebida beb1;
    static Pedido p1;
    
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[]args){
    	
    	pasCon = new PastelController(new Pastel(1, "Pastel de queijo", 5, "queijo", false));
        
        System.out.println(pasCon.getPastel());
        
    }
}
