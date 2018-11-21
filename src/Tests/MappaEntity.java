package Tests;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mappa", schema = "public", catalog = "RTV_DB")
public class MappaEntity {
    private int id;
    private String nome;
    private Object cities;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "cities")
    public Object getCities() {
        return cities;
    }

    public void setCities(Object cities) {
        this.cities = cities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MappaEntity that = (MappaEntity) o;
        return id == that.id &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(cities, that.cities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cities);
    }
}
