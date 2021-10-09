package model;

/**
 * Essa classe captura os dados referentes ao cliente e tem relação de associação com Telefone e Endereço.
 * @author Daniel Rocha Oliveira e André Macedo Rodrigues Alves
 * @version 1.0 (Out 2021)
 */


public class Cliente {
    private String nome;
    private String CPF;
    private Telefone numTel;
    private Endereco end;
    
    /**
     * Recebe e armazena dados do Cliente, através de gets e sets .
     * @param nome String responsável por receber o nome do Cliente.
     * @param CPF String reposnsável por receber o CPF do cliente
     * @param t número de telefone associado a Classe Telefone.
     * @param e endereço associado a Classe Endereço.
     */

    public Cliente(String nome, String CPF, Telefone t, Endereco e){
        this.CPF = CPF;
        this.nome = nome;
        this.numTel = t;
        this.end = e;
    }

    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCPF(){
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
        return "Nome: " +nome+ ", CPF: " +CPF+ ", Telefone: " +numTel+ ", Endereco: " +end;
    }
}
