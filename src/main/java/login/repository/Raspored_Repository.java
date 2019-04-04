//@Author Milan Dabic


package login.repository;

import login.model.Raspored;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Raspored_Repository extends CrudRepository<Raspored, Integer> {

    @Query("select r from Raspored r where r.dan_u_nedelji= :dan_u_nedelji")
    List<Raspored> prikazPoDanu(String dan_u_nedelji);

    @Query("select r from Raspored r where r.dan_u_nedelji= :dan_u_nedelji and r.vreme= :vreme")
    List<Raspored> prikazPoDanuIVremenu(String dan_u_nedelji, String vreme);

    @Query("select r from Raspored r where r.dan_u_nedelji= :dan_u_nedelji and r.vreme= :vreme and r.id_odeljenja= :id_odeljenja")
    List<Raspored> prikazPoDanuVremenuIOdeljenju(String dan_u_nedelji, String vreme, Integer id_odeljenja);

    @Transactional
    @Modifying
    @Query("update Raspored r set id_predmeta= :id_predmeta where r.dan_u_nedelji= :dan_u_nedelji and r.vreme= :vreme and id_odeljenja= :id_odeljenja ")
    void promeniRaspored(Integer id_predmeta, String dan_u_nedelji, String vreme, Integer id_odeljenja);
}
