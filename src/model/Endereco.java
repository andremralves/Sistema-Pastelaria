package model;
/**
 * Essa classe captura os dados referentes ao Endereço a ser inserido e tem um relação de associação com Cliente.
 * @author Daniel Rocha Oliveira e André Macedo Rodrigues Alves
 * @version 1.0 (Out 2021)
 */
public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private String CEP;
    private int numeroCasaAp;
	/**
     * Esse método captura os dados inseridos.
     * @param e String que representa o estado.
     * @param c String que representa a cidade.
     * @param b String que representa o bairro.
     * @param Cep String que representa o CEP.
     * @param n inteiro que representa o número da residência.
     */
    public Endereco(String e, String c, String b, String Cep, int n){
        this.estado = e;
        this.cidade = c;
        this.bairro = b;
        this.CEP = Cep;
        this.numeroCasaAp = n;

    }

    @Override
    public String toString() {
    return "Endereco: "+ estado+ ", " +cidade+ ", " +bairro+ ", CEP ("+CEP+ "), nÃºmero da residÃªncia (" +numeroCasaAp+ ")";
    }

    public String getEstado (){
        return estado;
    }

    public void setEstado (String est){
        this.estado = est;
    }

    public String getCidade (){
        return cidade;
    }

    public void setCidade (String cid){
        this.cidade = cid;
    }

    public String getBairro(){
        return bairro;
    }

    public void setBairro (String bai){
        this.bairro = bai;
    }

    public String getCEP (){
        return CEP;
    }

    public void setCEP (String cep){
        this.CEP = cep;
    }
    
    public int getNumCasaAp (){
        return numeroCasaAp;
    }

    public void setCEP (int numeroCasaAp){
        this.numeroCasaAp = numeroCasaAp;
    }

}
