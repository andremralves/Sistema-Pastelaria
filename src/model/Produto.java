package model;
/**
 * Essa classe captura os dados genéricos de produto, utilizados em bebidas e pastéis.
 * @author Daniel Rocha Oliveira e André Macedo Rodrigues Alves
 * @version 1.0 (Out 2021)
 */

public abstract class Produto {

    protected int numeroCardapio;
    protected String nome;
    protected double preco;
    
    /**
     * Método responsável pela captura dos dados
     * @param num inteiro resposável pelo número no cardápio.
     * @param n String reponsável pelo nome do produto.
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


