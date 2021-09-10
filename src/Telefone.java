public class Telefone {
    private String DDD;
    private String numeroTelefone;

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
