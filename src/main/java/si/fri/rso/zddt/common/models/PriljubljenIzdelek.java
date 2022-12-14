package si.fri.rso.zddt.common.models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "priljubljenizdelek")
@NamedQueries(value =
        {
                //vrni vse izdelke
                @NamedQuery(name = "PriljubljenIzdelek.getAll",
                        query = "SELECT i FROM PriljubljenIzdelek i"),
                //vrni najbolj priljubljene izdelke
                @NamedQuery(name = "PriljubljenIzdelek.getNajboljPriljubljene",
                        query = "SELECT i.izdelek.id, i.izdelek.naziv, i.izdelek.kategorija, count(i.id) FROM PriljubljenIzdelek i group by i.izdelek.id"),
                //vrni izdelek - id
                @NamedQuery(name = "PriljubljenIzdelek.getById",
                        query = "SELECT i FROM PriljubljenIzdelek i WHERE i.id = :idPriljubljenIzdelek"),
                //vrni izdelek - kategorija
                @NamedQuery(name = "PriljubljenIzdelek.getIzdelekId",
                        query = "SELECT i FROM PriljubljenIzdelek i WHERE i.izdelek = :izdelekId"),
                //vrni izdelek - naziv
                @NamedQuery(name = "PriljubljenIzdelek.getByUser",
                        query = "SELECT i FROM PriljubljenIzdelek i WHERE i.uporabnik.id = :uporabnikId")
        })
public class PriljubljenIzdelek implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "priljubljen_izdelek_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "izdelek_id")
    private Izdelek izdelek;

    @ManyToOne
    @JoinColumn(name = "uporabnik_id")
    private Uporabnik uporabnik;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Izdelek getIzdelek() {
        return izdelek;
    }

    public void setIzdelek(Izdelek izdelek) {
        this.izdelek = izdelek;
    }

    public Uporabnik getUporabnik() {
        return uporabnik;
    }

    public void setUporabnik(Uporabnik uporabnik) {
        this.uporabnik = uporabnik;
    }
}
