package model;
public class Pastel extends Produto {

    private String ingredientes;
    private boolean borda;

    public Pastel(int num, String n, double p, String i, boolean b) {
        super(num, n , p);
        this.ingredientes = i;
        this.borda = b;
    }

    public String getIngredientes(){
        return ingredientes;
    }

    public void setIngredientes (String i) {
        this.ingredientes = i;
    }
    
    public boolean getBorda(){
        return borda;
    }

    public void setBorda (boolean b) {
        this.borda = b;
    }
    
    public String toString() {
        return "Numero no cardapio: " + numeroCardapio +
        		"\nNome do pastel: " + nome +
        		"\nvalor: R$" + preco +
        		"\nIgredientes: " + ingredientes +
        		"\nBorda: " + borda;
    }

}
