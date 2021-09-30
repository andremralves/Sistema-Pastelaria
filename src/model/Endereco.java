package model;
public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private String CEP;
    private int numeroCasaAp;

    public Endereco(String e, String c, String b, String Cep, int n){
        this.estado = e;
        this.cidade = c;
        this.bairro = b;
        this.CEP = Cep;
        this.numeroCasaAp = n;

    }

    @Override
    public String toString() {
    return "Endereco: "+ estado+ ", " +cidade+ ", " +bairro+ ", CEP ("+CEP+ "), número da residência (" +numeroCasaAp+ ")";
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

}
