package model;
public class Bebida extends Produto{
	
	private boolean alcoolics;

    public Bebida(int num, String n, double p, boolean a) {
        super(num, n, p);
        this.alcoolics = a;
    }

    public boolean getAlcoolics(){
        return alcoolics;
    }

    public void setAlcoolics(boolean alcoolics) {
        this.alcoolics = alcoolics;
    }
    
    public String toString() {
        return "Num. Cardápio: " + numeroCardapio + 
        		", Nome: " + nome + 
        		", valor: R$ " + preco;
    }
}
