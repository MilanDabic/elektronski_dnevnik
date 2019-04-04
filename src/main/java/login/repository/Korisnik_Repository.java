//@Author Milan Dabic

package login.repository;

import login.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Korisnik_Repository extends JpaRepository<Korisnik, Integer>, CrudRepository<Korisnik, Integer> {
    @Query("select k from Korisnik k where k.username= :username")
    Korisnik nadjiUsername(String username);

    @Query("select k from Korisnik k where k.username= :username")
    List<Korisnik> pronadjiUsername(String username);
}
