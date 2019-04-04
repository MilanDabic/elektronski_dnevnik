//@Author Milan Dabic


package login.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Raspored {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String vreme;
    private String dan_u_nedelji;
    private Integer id_predmeta;
    private Integer id_odeljenja;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    public Integer getId_predmeta() {
        return id_predmeta;
    }

    public void setId_predmeta(Integer id_predmeta) {
        this.id_predmeta = id_predmeta;
    }

    public Integer getId_odeljenja() {
        return id_odeljenja;
    }

    public void setId_odeljenja(Integer id_odeljenja) {
        this.id_odeljenja = id_odeljenja;
    }

    public String getDan_u_nedelji() {
        return dan_u_nedelji;
    }

    public void setDan_u_nedelji(String dan_u_nedelji) {
        this.dan_u_nedelji = dan_u_nedelji;
    }
}
