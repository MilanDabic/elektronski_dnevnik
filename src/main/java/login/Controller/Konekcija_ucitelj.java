//@Author Milan Dabic

package login.Controller;


import login.model.Ocene;
import login.model.Raspored;
import login.model.Ucenik;
import login.repository.Ocene_Repository;
import login.repository.Raspored_Repository;
import login.repository.Ucenik_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/ucitelj")
public class Konekcija_ucitelj {
    @Autowired
    private Ucenik_Repository ucenik_repository;
    @Autowired
    private Ocene_Repository ocene_repository;
    @Autowired
    private Raspored_Repository raspored_repository;

    @GetMapping(path = "/unesi_ocenu")
    public @ResponseBody
    String unesi_Ocenu(@RequestParam Integer id_ucenika,
                       @RequestParam Integer id_predmeta, @RequestParam Integer ocena) {
        Ocene o = new Ocene();
        o.setId_ucenika(id_ucenika);
        o.setId_predmeta(id_predmeta);
        o.setOcena(ocena);
        ocene_repository.save(o);
        return "Ocena je uneta!";
    }

    @GetMapping(path = "/ocene_po_uceniku")
    public @ResponseBody
    Iterable<Ocene> oceneUcenik(@RequestParam Integer id_ucenika) {
        List<Ocene> ocene = ocene_repository.ocenePoUceniku(id_ucenika);
        return ocene;
    }

    @GetMapping(path = "/ocene_po_predmetu")
    public @ResponseBody
    Iterable<Ocene> ocenePredmet(@RequestParam Integer id_predmeta) {
        List<Ocene> ocene = ocene_repository.ocenePoPredmetu(id_predmeta);
        return ocene;
    }

    @GetMapping(path = "/pronadji_ucenika_po_jmbg-u")
    public @ResponseBody
    Iterable<Ucenik> nadjiJMBG(@RequestParam String jmbg) {
        List<Ucenik> ucenici = ucenik_repository.pronadjiJMBG(jmbg);
        return ucenici;
    }

    @GetMapping(path = "/pronadji_ucenika_po_prezimenu")
    public @ResponseBody
    Iterable<Ucenik> nadjiPrezime(@RequestParam String prezime) {
        List<Ucenik> ucenici = ucenik_repository.pronadjiPrezime(prezime);
        return ucenici;
    }

    @GetMapping(path = "/raspored_po_danu_vremenu_i_odeljenju")
    public @ResponseBody Iterable<Raspored>rasporedPoVremenu(@RequestParam String dan_u_nedelji, @RequestParam String vreme, @RequestParam Integer id_odeljenja){
        List<Raspored>danVremeOdeljenje=raspored_repository.prikazPoDanuVremenuIOdeljenju(dan_u_nedelji, vreme, id_odeljenja);
        return danVremeOdeljenje;
    }
}