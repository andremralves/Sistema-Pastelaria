package model;

import java.util.ArrayList;

/**
 * Essa classe captura os dados referentes ao Pedido.
 * @author Daniel Rocha Oliveira e André Macedo Rodrigues Alves
 * @version 1.0 (Out 2021)
 */

public class Pedido {
    private int numeroPedido;
    private Cliente clienteSelecionado;
    private ArrayList<Pastel> pasteisSelecionados = new ArrayList<Pastel>();
    private ArrayList<Bebida> bebidasSelecionadas = new ArrayList<Bebida>();
    private double valorTotal;
    static private int count = 1;

	/**
     * Método Pedido, realiza a captura.
     * @param c Objeto Clientes, relação de agregção.
     * @param p uma ArrayList Pastel que armazena o pastel selecionado.
     * @param b uma ArrayList Bebida que armazena a bebida selecionada.
     */
	
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

    public void setNumeroPedido(int p) {
        this.numeroPedido = p;
    }

    public Cliente getClienteSelecionado() {
        return this.clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente p) {
        this.clienteSelecionado = p;
    }

    public ArrayList<Pastel> getPasteisSelecionados() {
        return this.pasteisSelecionados;
    }

    public void setArrayPasteisSelecionados(ArrayList<Pastel> p) {
        this.pasteisSelecionados = p;
    }
    
    public ArrayList<Bebida> getBebidasSelecionadas() {
        return this.bebidasSelecionadas;
    }

    public void setArrayBebidasSelecionadas(ArrayList<Bebida> b) {
        this.bebidasSelecionadas = b;
    }

    public double getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(double vt) {
        this.valorTotal = vt;
    }
	/**
     * Método que realiza o cálculo de valor total do pedido.
     * @param p ArrayList dos pasteis selecionados.
     * @param b ArrayList das bebidas selecionadas.
     * @return valor total esperado do pedido.
     */
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