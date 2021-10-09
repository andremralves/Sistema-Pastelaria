package model;

/**
 * Essa classe captura os dados referentes ao Telefone, em associa��o com o Cliente.
 * @author Daniel Rocha Oliveira e Andr� Macedo Rodrigues Alves
 * @version 1.0 (Out 2021)
 */

public class Telefone {
    private String DDD;
    private String numeroTelefone;
	 
    /**
     * M�todo que faz a captura.
     * @param d String relacionada ao DDD.
     * @param num String relacionada ao n�mero do telefone.
     */
    public Telefone(String d, String num) {
        this.DDD = d;
        this.numeroTelefone = num;
    }

    @Override
    public String toString() {
        return "Telefone: (" + DDD + ") " + numeroTelefone;
    }

    public String getDDD() {
        return DDD;
    }

    public void setDDD(String dDD) {
        this.DDD = dDD;
    }

    public String getNumero() {
        return numeroTelefone;
    }

    public void setNumero(String numero) {
        this.numeroTelefone = numero;
    }
}
