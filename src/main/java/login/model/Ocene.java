//@Author Milan Dabic


package login.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ocene {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        private Integer id_ucenika;
        private Integer id_predmeta;
        private Integer ocena;
        private Integer id_odeljenja;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getId_ucenika() {
            return id_ucenika;
        }

        public void setId_ucenika(Integer id_ucenika) {
            this.id_ucenika = id_ucenika;
        }

        public Integer getId_predmeta() {
            return id_predmeta;
        }

        public void setId_predmeta(Integer id_predmeta) {
            this.id_predmeta = id_predmeta;
        }

        public Integer getOcena() {
            return ocena;
        }

        public void setOcena(Integer ocena) {
            this.ocena = ocena;
        }

    public Integer getId_odeljenja() {
        return id_odeljenja;
    }

    public void setId_odeljenja(Integer id_odeljenja) {
        this.id_odeljenja = id_odeljenja;
    }
}

