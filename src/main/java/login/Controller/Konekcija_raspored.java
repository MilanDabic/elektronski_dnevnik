//@Author Milan Dabic


package login.Controller;

import login.model.Raspored;
import login.repository.Raspored_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/admin")
public class Konekcija_raspored {
    @Autowired
    private Raspored_Repository raspored_repository;
    @GetMapping(path = "/unesi_u_raspored")
    public @ResponseBody String unesi_u_raspored(@RequestParam String dan_u_nedelji, @RequestParam String vreme, @RequestParam Integer id_predmeta,
                                                 @RequestParam Integer id_odeljenja){
        Raspored r=new Raspored();

        r.setDan_u_nedelji(dan_u_nedelji);
        r.setVreme(vreme.replace(" ",":").replace(",",":")
        .replace(", ",":"));
        r.setId_predmeta(id_predmeta);
        r.setId_odeljenja(id_odeljenja);
        raspored_repository.save(r);
        return "Raspored je sacuvan!";
    }

    @GetMapping(path = "/promeni_raspored")
    public @ResponseBody String promeni_raspored(@RequestParam Integer id, @RequestParam String dan_u_nedelji, @RequestParam String vreme,
                                                 @RequestParam Integer id_predmeta, @RequestParam Integer id_odeljenja){

        Raspored r=raspored_repository.findById(id).get();

        r.setDan_u_nedelji(dan_u_nedelji);
        r.setVreme(vreme.replace(" ",":").replace(",",":")
                .replace(", ",":"));
        r.setId_predmeta(id_predmeta);
        r.setId_odeljenja(id_odeljenja);
        raspored_repository.save(r);
        return "Raspored je izmenjen!";
    }

    @GetMapping(path = "/promeni_predmet_u_rasporedu")
    public @ResponseBody String promeni_predmet(@RequestParam Integer id_predmeta, @RequestParam String dan_u_nedelji,@RequestParam String vreme,@RequestParam Integer id_odeljenja){
        raspored_repository.promeniRaspored(id_predmeta, dan_u_nedelji, vreme, id_odeljenja);
        return "Predmet je promenjen";
    }

    @GetMapping(path ="/raspored_po_danu")
    public @ResponseBody Iterable<Raspored>rasporedPoDanu(@RequestParam String dan_u_nedelji){
        List<Raspored>dan=raspored_repository.prikazPoDanu(dan_u_nedelji);
        return dan;
    }

    @GetMapping(path = "/raspored_po_danu_i_vremenu")
    public @ResponseBody Iterable<Raspored>rasporedPoVremenu(@RequestParam String dan_u_nedelji, @RequestParam String vreme){
        List<Raspored>danVreme=raspored_repository.prikazPoDanuIVremenu(dan_u_nedelji, vreme);
        return danVreme;
    }

    @GetMapping(path = "/raspored_po_danu_vremenu_i_odeljenju")
    public @ResponseBody Iterable<Raspored>rasporedPoVremenu(@RequestParam String dan_u_nedelji, @RequestParam String vreme, @RequestParam Integer id_odeljenja){
        List<Raspored>danVremeOdeljenje=raspored_repository.prikazPoDanuVremenuIOdeljenju(dan_u_nedelji, vreme, id_odeljenja);
        return danVremeOdeljenje;
    }

}
