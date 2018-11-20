public class Mappa {
    private String nome;
    private double latitudine;
    private double longitudine;


    public Mappa(String nome, double latitudine, double longitudine) {
        this.nome = nome;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
    }


    public String getNome() {
        return nome;
    }

    public double getLatitudine() {
        return latitudine;
    }

    public double getLongitudine() {
        return longitudine;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLatitudine(double latitudine) {
        this.latitudine = latitudine;
    }

    public void setLongitudine(double longitudine) {
        this.longitudine = longitudine;
    }

    public String builtJson(String continente) {
        return continente + "[nome=" + this.nome + ", latitudine=" + this.latitudine + ", longitudine=" + this.longitudine + "]";
    }
}
