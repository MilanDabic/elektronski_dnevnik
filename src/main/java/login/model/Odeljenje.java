//@Author Milan Dabic


package login.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Odeljenje {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer broj_odeljenja;
    private Integer id_ucitelja;
    private Integer id_ucenika;

    public Integer getBroj_odeljenja() {
        return broj_odeljenja;
    }

    public void setBroj_odeljenja(Integer broj_odeljenja) {
        this.broj_odeljenja = broj_odeljenja;
    }

    public Integer getId_ucitelja() {
        return id_ucitelja;
    }

    public void setId_ucitelja(Integer id_ucitelja) {
        this.id_ucitelja = id_ucitelja;
    }

    public Integer getId_ucenika() {
        return id_ucenika;
    }

    public void setId_ucenika(Integer id_ucenika) {
        this.id_ucenika = id_ucenika;
    }
}
