package model;
public abstract class Produto {

    protected int numeroCardapio;
    protected String nome;
    protected double preco;
    
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
        return "Num. Cardápio: " + numeroCardapio +
        		", Nome: " + nome +
        		", valor: R$" + preco;
    }

}


