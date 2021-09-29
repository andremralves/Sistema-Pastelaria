package model;
import java.util.Scanner;
public class Main {
    static Cliente c1;
    static Pastel pas1;
    static Bebida beb1;
    static Pedido p1;
    
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[]args){
        int menuNum = 0;
        pas1 = new Pastel(1, "Pastel de queijo", "sem borda", 5, "queijo", false);
    	  
        System.out.println(pas1.nome);
        
        do {
        	menuNum = input.nextInt();
            switch( menuNum ) {
	            case 1:
	            	System.out.println("Finalizando o programa...");
	                break;
	            case 2:
	            	System.out.println("Finalizando o programa...");
	                break;
	            case 3:
	            	System.out.println("Finalizando o programa...");
	                break;
                case 0:
                	System.out.println("Finalizando o programa...");
                    break;
                default:
                    System.out.println("Digite um número válido!");
                    break;
            }
        } while( menuNum != 0 );
    }
}
