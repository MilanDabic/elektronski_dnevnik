//@Author Milan Dabic

package login.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Entity
@Table(name = "korisnik")
public class Korisnik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable=false, unique=true)
    @NotEmpty()
    private String username;
    private String password;
    private String ime;
    private String prezime;
    @Transient
    private String passwordConfirm;
    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(
            name = "korisnik_uloga",
            joinColumns = {@JoinColumn(name = "KORISNIK_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ULOGA_ID", referencedColumnName = "ID")}
    )
    @JsonIgnoreProperties("uloge")
    private List<Uloga> uloge;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public List<Uloga> getUloge() {
        return uloge;
    }

    public void setUloge(List<Uloga> uloge) {
        this.uloge = uloge;
    }

//    public List<Ucenik> getUcenik() {
//        return ucenik;
//    }
//
//    public void setUcenik(List<Ucenik> ucenik) {
//        this.ucenik = ucenik;
//    }
}
