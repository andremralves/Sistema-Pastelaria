package model;
/**
 * Essa classe captura os dados das bebidas fornecidas
 * @author Daniel Rocha Oliveira e Andr� Macedo Rodrigues Alves
 * @version 1.0 (Out 2021)
 */
public class Bebida extends Produto{
	
	private boolean alcoolics;
	
	/**
	 * Esse m�todo  est� capturando os dados herdados da classe pai, Produto, e capturando dados referentes a bebida
	 * ser alco�lica ou n�o. Tudo isso atrav�s de gets e sets. 
	 * @param num um inteiro que representa o n�mero no card�pio.
	 * @param n uma String que representa o nome da bebida.
	 * @param p um double que representa o pre�o em reais da bebida.
	 * @param a o boolean alcoolics da classe Bebida, armazenando se a bebida � alco�lica ou n�o.
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
