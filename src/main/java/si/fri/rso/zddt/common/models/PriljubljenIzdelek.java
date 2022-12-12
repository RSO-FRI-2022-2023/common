package si.fri.rso.zddt.common.models;


import javax.persistence.*;

@Entity
@Table(name = "priljubljen_izdelek")
@NamedQueries(value =
        {
                //vrni vse izdelke
                @NamedQuery(name = "PriljubljenIzdelek.getAll",
                        query = "SELECT i FROM PriljubljenIzdelek i"),
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
public class PriljubljenIzdelek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "priljubljen_izdelek_id")
    private Integer id;

    @OneToOne
//    @JoinColumn(name = "izdelek_id")
    private Izdelek izdelek;

    @OneToOne
//    @JoinColumn(name = "user_id")
    private Uporabnik uporabnik;

}
