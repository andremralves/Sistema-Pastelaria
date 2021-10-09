package model;
/**
 * Essa classe captura os dados das bebidas fornecidas
 * @author Daniel Rocha Oliveira e André Macedo Rodrigues Alves
 * @version 1.0 (Out 2021)
 */
public class Bebida extends Produto{
	
	private boolean alcoolics;
	
	/**
	 * Esse método  está capturando os dados herdados da classe pai, Produto, e capturando dados referentes a bebida
	 * ser alcoólica ou não. Tudo isso através de gets e sets. 
	 * @param num um inteiro que representa o número no cardápio.
	 * @param n uma String que representa o nome da bebida.
	 * @param p um double que representa o preço em reais da bebida.
	 * @param a o boolean alcoolics da classe Bebida, armazenando se a bebida é alcoólica ou não.
	 */
	
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
        return "Num. Cardapio: " + numeroCardapio + 
        		", Nome: " + nome + 
        		", valor: R$ " + preco +
        		", Acoolica: " + ((alcoolics == true) ? "sim" : "nao");
    }
}
