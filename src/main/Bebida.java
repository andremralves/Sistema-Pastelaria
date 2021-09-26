package main;
public class Bebida extends Produto{

    public Bebida(int num, String n, String t, double p) {
        this.numeroCardapio = num;
        this.nome = n;
        this.tipo = t;
        this.preco = p;
    }
    public int getNumeroCardapio(){
        return numeroCardapio;
    }

    public void setNumeroCardapio(int num) {
        this.numeroCardapio = num;
    }

    public String getNome(){
        return nome;
    }

    public void setNome (String n) {
        this.nome = n;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String t){
        this.tipo = t;
    }

    public double getPreco(){
        return preco;
    }

    public void setPreco (double p) {
        this.preco = p;
    }

    @Override
    public String toString() {
        return "Nome da bebida: " + nome + ", valor: R$" + preco;
    }
}
