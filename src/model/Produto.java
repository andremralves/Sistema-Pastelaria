package model;
/**
 * Essa classe captura os dados gen�ricos de produto, utilizados em bebidas e past�is.
 * @author Daniel Rocha Oliveira e Andr� Macedo Rodrigues Alves
 * @version 1.0 (Out 2021)
 */

public abstract class Produto {

    protected int numeroCardapio;
    protected String nome;
    protected double preco;
    
    /**
     * M�todo respons�vel pela captura dos dados
     * @param num inteiro respos�vel pelo n�mero no card�pio.
     * @param n String repons�vel pelo nome do produto.
     * @param p double para o valor do produto.
     */
    
    protected Produto(int num, String n, double p) {
        this.numeroCardapio = num;
        this.nome = n;
        this.preco = p;
    }

    public int getNumeroCardapio(){
        return numeroCardapio;
    }

    public void setNumeroCardapio(int numeroCardapio) {
        this.numeroCardapio = numeroCardapio;
    }

    public String getNome(){
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }


    public double getPreco(){
        return preco;
    }

    public void setPreco (double preco) {
        this.preco = preco;
    }
    
    public String toString() {
        return "Num. Cardapio: " + numeroCardapio +
        		", Nome: " + nome +
        		", valor: R$" + preco;
    }

}


