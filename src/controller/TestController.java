package controller;

import java.util.Scanner;


public class TestController {
    
    static PastelController pas1;
    static BebidaController beb1;
    static DadosController d = new DadosController();
    
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[]args){
    	
    	
    	
    	for(int i = 0; i < d.getPasteis().size(); i++) {
    		System.out.println(d.getPasteis().get(i));
    	}
    	for(int i = 0; i < d.getBebidas().size(); i++) {
    		System.out.println(d.getBebidas().get(i));
    	}
        
    }
}
