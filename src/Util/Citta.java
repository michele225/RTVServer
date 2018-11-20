package Util;

import netscape.javascript.JSObject;

public class Citta {
    private String nome;
    private double latitudine;
    private double longitudine;
    private String jsobject;


    public Citta(String nome, double latitudine, double longitudine, String jsobject) {
        this.nome = nome;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        this.jsobject=jsobject;
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
    public String Unique(String a, String b){
        return a+","+b;
    }

    public String OpenCloseJson(String s){
        return "[" + s + "]";
    }
}
