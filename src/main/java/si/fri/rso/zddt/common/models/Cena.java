package si.fri.rso.zddt.common.models;

import javax.persistence.*;

@Entity
@Table(name = "cena")
@NamedQueries(value =
        {
                //vrni vse cene
                @NamedQuery(name = "Cena.getAll",
                        query = "SELECT c FROM Cena c"),
                //vrni cene izdelka
                @NamedQuery(name = "Cena.getByizdelekId",
                        query = "SELECT c FROM Cena c WHERE c.izdelek.id = :izdelekId"),
                //vrni ceno - id
                @NamedQuery(name = "Cena.getByid",
                        query = "SELECT c FROM Cena c WHERE c.id = :id"),
                //vrni cene neke trgovine
                @NamedQuery(name = "Cena.getByTrgovinaId",
                        query = "SELECT c FROM Cena c WHERE c.trgovina.id = :trgovinaId"),
                //popust
                @NamedQuery(name = "Cena.popust",
                query="UPDATE Cena c SET c.discount = c.cena * :discount")
        })
public class Cena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cena_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "izdelek_id")
    private Izdelek izdelek;

    @ManyToOne
    @JoinColumn(name = "trgovina_id")
    private Trgovina trgovina;

    private double cena;
    private double discount;

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

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

    public Trgovina getTrgovina() {
        return trgovina;
    }

    public void setTrgovina(Trgovina trgovina) {
        this.trgovina = trgovina;
    }
}
