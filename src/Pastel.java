public class Pastel extends Produto {

    private String ingredientes;
    private boolean borda;

    public Pastel(int num, String n, String t, double p, String i, boolean b) {
        this.numeroCardapio = num;
        this.nome = n;
        this.tipo = t;
        this.preco = p;
        this.ingredientes = i;
        this.borda = b;
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
        return "Nome do pastel: " + nome + ", valor: R$" + preco;
    }

}
