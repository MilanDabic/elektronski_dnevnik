//@Author Milan Dabic


package login.repository;

import login.model.Ocene;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Ocene_Repository extends CrudRepository<Ocene, Integer> {

    @Query("select o from Ocene o where o.id_ucenika= :id_ucenika")
    List<Ocene> ocenePoUceniku(Integer id_ucenika);


    @Query("select o from Ocene o where o.id_predmeta= :id_predmeta")
    List<Ocene> ocenePoPredmetu(Integer id_predmeta);

    @Query("select o from Ocene o where o.id_odeljenja= :id_odeljenja and o.id_predmeta= :id_predmeta")
    List<Ocene> ocenePoOdeljenjuIPredmetu(Integer id_odeljenja, Integer id_predmeta);


}
