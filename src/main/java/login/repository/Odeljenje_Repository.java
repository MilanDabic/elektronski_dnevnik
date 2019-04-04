//@Author Milan Dabic


package login.repository;

import login.model.Odeljenje;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Odeljenje_Repository extends CrudRepository<Odeljenje, Integer> {

    @Query("select o from Odeljenje o where o.broj_odeljenja= :broj_odeljenja")
    List<Odeljenje>uceniciPoOdeljenju(Integer broj_odeljenja);

    @Query("select o from Odeljenje o where o.id_ucitelja= :id_ucitelja")
    List<Odeljenje>odeljenjePoUcitelju(Integer id_ucitelja);

    @Query("select o from Odeljenje o where o.id_ucenika= :id_ucenika")
    List<Odeljenje>odeljenjePoUceniku(Integer id_ucenika);

    @Transactional
    @Modifying
    @Query("delete Odeljenje o where o.broj_odeljenja= :broj_odeljenja")
    void obrisiOdeljenje(Integer broj_odeljenja);
}
