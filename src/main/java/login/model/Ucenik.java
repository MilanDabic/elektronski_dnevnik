//@Author Milan Dabic


package login.model;



import javax.persistence.*;


@Entity
public class Ucenik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String ime;
    private String prezime;
    private String jmbg;
    private Integer izostanci;
    private String username;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public Integer getIzostanci() {
        return izostanci;
    }

    public void setIzostanci(Integer izostanci) {
        this.izostanci = izostanci;
    }




    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
