package si.fri.rso.zddt.common.models;

import lombok.ToString;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "uporabnik")
@NamedQueries(value =
        {
                //vrni vse uporabnike
                @NamedQuery(name = "Uporabnik.getAll",
                        query = "SELECT u FROM Uporabnik u"),
                //vrni uporabnika glede na id
                @NamedQuery(name = "Uporabnik.getById",
                        query = "SELECT u FROM Uporabnik u WHERE u.id = :userId")
        })
@ToString
public class Uporabnik implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uporabnik_id")
    private Integer id;

    private String firstname;
    private String lastname;

    @JsonbTransient
    @OneToMany(mappedBy = "uporabnik", cascade = CascadeType.ALL)
    private List<PriljubljenIzdelek> priljubljeniIzdelki;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
