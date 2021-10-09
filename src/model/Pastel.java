package model;
/**
 * Essa classe captura os dados referentes ao Pastel e herda parâmetro da classe Pai, Produto.
 * @author Daniel Rocha Oliveira e André Macedo Rodrigues Alves
 * @version 1.0 (Out 2021)
 */
public class Pastel extends Produto {

    private String ingredientes;
    private boolean borda;
	
	/**
     * Método que faz a captura de dados.
     * @param num inteiro que representa o número no cardápio.
     * @param n String que representa o nome do Pastel.
     * @param p doube que representa o preço associado ao Pastel.
     * @param i String que representa os ingredientes do determinado pastel
     * @param b boolean que representa a escolha da borda, sendo sim ou não.
     */
	
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
    
    @Override
    public String toString() {
        return "Num. Cardapio: " + numeroCardapio +
        		", Nome: " + nome +
        		", Valor: R$" + preco +
        		", Ingredientes: " + ingredientes +
        		", Borda: " + ((borda == true) ? "sim" : "nao");
    }

}
