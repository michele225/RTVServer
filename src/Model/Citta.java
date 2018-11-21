package Model;

import netscape.javascript.JSObject;

import javax.persistence.*;

@Entity
@Table(name = "mappa")
public class Citta {

    @javax.persistence.Id
    @Column(name = "id")
    private int id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "cities", nullable = false)
    private JSObject cities;

    public Citta(int id, String nome, JSObject cities) {
        this.id = id;
        this.nome = nome;
        this.cities = cities;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCities(JSObject cities) {
        this.cities = cities;
    }

    public JSObject getCities() {
        return cities;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }


    public String Unique(String a, String b){
        return a+","+b;
    }

    public String OpenCloseJson(String s){
        return "[" + s + "]";
    }

    @Override
    public String toString() {
        return "Citta{" +
                "id= " + id +
                "nome= " + nome +
                "cities= " + cities +
                '}';
        }
}