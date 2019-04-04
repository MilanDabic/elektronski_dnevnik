//@Author Milan Dabic


package login.repository;

import login.model.Ucenik;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Ucenik_Repository extends CrudRepository<Ucenik, Integer> {

    @Query("select u from Ucenik u where u.jmbg= :jmbg")
    List<Ucenik>pronadjiJMBG(String jmbg);

    @Query("select u from Ucenik u where u.prezime= :prezime")
    List<Ucenik>pronadjiPrezime(String prezime);

//    @Query("select u from Ucenik u join u.korisnik kor on u.korisnik_id= kor.id")
//    List<Ucenik>ucenikPoRoditelju(Integer id);

    @Query("select u from Ucenik u where u.username= :username")
    List<Ucenik>ucenikPoRoditelju(String username);

//    @Query("select * from Ucenik u left join Korisnik k on u.id=k.id")
//    List<Ucenik>ucenikPoRoditelju(Integer id);

//    @Query("SELECT * FROM Ucenik u LEFT JOIN u.korisnik k")
//    List<Ucenik>ucenikPoRoditelju(Integer id);
}
