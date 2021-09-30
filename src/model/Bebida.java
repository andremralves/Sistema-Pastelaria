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
    
    @Override
    public String toString() {
        return "Nome da bebida: " + nome + ", valor: R$ " + preco + "Alcoolica: " + alcoolics;
    }
}
