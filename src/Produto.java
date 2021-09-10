public class Produto {

    protected int numeroCardapio;
    protected String nome;
    protected String tipo;
    protected double preco;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public double getPreco(){
        return preco;
    }

    public void setPreco (double preco) {
        this.preco = preco;
    }

    public String toString() {
        return "Produto: " +nome+ ",Preço: " +preco+ ", número no cardapio: " +numeroCardapio;
    }

}


