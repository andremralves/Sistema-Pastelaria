package model;

import java.util.ArrayList;

public class Pedido {
    private int numeroPedido;
    private Cliente clienteSelecionado;
    private ArrayList<Pastel> pasteisSelecionados = new ArrayList<Pastel>();
    private ArrayList<Bebida> bebidasSelecionadas = new ArrayList<Bebida>();
    private double valorTotal;
    static private int count = 1;

    public Pedido(Cliente c, ArrayList<Pastel> p, ArrayList<Bebida> b) {
        numeroPedido = count++;
        this.clienteSelecionado = c;
        this.pasteisSelecionados = p;
        this.bebidasSelecionadas = b;
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
    
    public ArrayList<String> getPasteisNames() {
    	int size = pasteisSelecionados.size();
    	ArrayList<String> pasteisNames = new ArrayList<String>();
    	for(int i = 0; i < size; i++) {
    		pasteisNames.add(pasteisSelecionados.get(i).getNome());
    	}
    	return pasteisNames;
    }
    
    public ArrayList<String> getBebidasNames() {
    	int size = bebidasSelecionadas.size();
    	ArrayList<String> bebidasNames = new ArrayList<String>();
    	for(int i = 0; i < size; i++) {
    		bebidasNames.add(bebidasSelecionadas.get(i).getNome());
    	}
    	return bebidasNames;
    }
    
    public String toString() {
    	return "Num. Pedido: " + numeroPedido +
        		", Cliente: " + clienteSelecionado.getNome() +
        		", Prod. Selecionados: " + getPasteisNames() + " " + getBebidasNames() +
        		", Valor Total: R$" + valorTotal;
    }

}