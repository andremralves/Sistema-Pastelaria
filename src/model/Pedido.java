package model;

import java.util.ArrayList;

public class Pedido {
    static private int numeroPedido = 0;
    private Cliente clienteSelecionado;
    private ArrayList<Pastel> pasteisSelecionados = new ArrayList<Pastel>();
    private ArrayList<Bebida> bebidasSelecionadas = new ArrayList<Bebida>();
    private double valorTotal;
    private int numPasteis = 0;

    public Pedido(Cliente c, ArrayList<Pastel> p, ArrayList<Bebida> b) {
        this.numeroPedido++;
        this.clienteSelecionado = c;
        this.valorTotal = calculaValorTotal(p, b);
    }

    public int getNumeroPedido() {
        return this.numeroPedido;
    }

    public void setgetNumeroPedido(int p) {
        this.numeroPedido = p;
    }

    public Cliente getClienteSelecionado() {
        return this.clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente p) {
        this.clienteSelecionado = p;
    }

    public ArrayList<Pastel> getPasteissSelecionados() {
        return this.pasteisSelecionados;
    }

    public void setArrayPasteissSelecionados(ArrayList<Pastel> p) {
        this.pasteisSelecionados = p;
    }
    
    public ArrayList<Bebida> getBebidassSelecionadss() {
        return this.bebidasSelecionadas;
    }

    public void setArrayBebidasSelecionadss(ArrayList<Bebida> b) {
        this.bebidasSelecionadas = b;
    }

    public double getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(double vt) {
        this.valorTotal = vt;
    }

    public double calculaValorTotal(ArrayList<Pastel> p, ArrayList<Bebida> b) {
        double total = 0;
        for(int i = 0; i < p.size(); i++) {
        	total = total + p.get(i).preco;
        }
        for(int i = 0; i < b.size(); i++) {
        	total = total + b.get(i).preco;
        }
        return total;
    }
    
    public String toString() {
    	return "Num. Pedido: " + numeroPedido +
        		", Cliente: " + clienteSelecionado.getnome() +
        		", Prod. Selecionados: " + pasteisSelecionados +
        		", Valor Total: R$" + valorTotal;
    }

}