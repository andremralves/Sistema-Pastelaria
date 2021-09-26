package main;
public class Pedido {
    private int numeroPedido;
    private Cliente clienteSelecionado;
    private Produto[] produtosSelecionados = new Produto[15];
    private double valorTotal;
    private int numProdutos = 0;

    public Pedido(int numPed, Cliente c, Produto[] p, double valT) {
        this.numeroPedido = numPed;
        this.clienteSelecionado = c;
        this.valorTotal = valT;
    }

    public int getNumeroPedido() {
        return this.numeroPedido;
    }

    public void setgetNumeroPedido(int p) {
        this.numeroPedido = p;
    }

    public Cliente getClientsSelecionado() {
        return this.clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente p) {
        this.clienteSelecionado = p;
    }

    public Produto[] getProdutosSelecionados() {
        return this.produtosSelecionados;
    }

    public void setArrayProdutosSelecionados(Produto[] p) {
        this.produtosSelecionados = p;
    }

    public double getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(double vt) {
        this.valorTotal = vt;
    }

    public void calculaValorTotal(Produto[] p) {
        //calcular valor total (em andamento)
    }

}