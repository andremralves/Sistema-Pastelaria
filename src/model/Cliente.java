package model;
public class Cliente {
    private String nome;
    private int CPF;
    private Telefone numTel;
    private Endereco end;

    public Cliente(String nome, int CPF, Telefone t, Endereco e){
        this.CPF = CPF;
        this.nome = nome;
        this.numTel = t;
        this.end = e;
    }

    public String getnome(){
        return nome;
    }

    public int getCPF(){
        return CPF;
    }

    public Telefone getNumTel (){
        return numTel;
    }

    public void setNumTel (Telefone numTel){
        this.numTel = numTel;
    }

    public Endereco getEnd (){
        return end;
    }

    public void setEnd (Endereco end){
        this.end = end;
    }

    public void deletaCliente (int CPF){
        //deleta cliente pelo seu indentificador (CPF)
    }

    public String toString() {
        return "Nome: " +nome+ ", CPF: " +CPF+ ", Telefone: " +numTel+ ", Endereço: " +end;
    }
}
