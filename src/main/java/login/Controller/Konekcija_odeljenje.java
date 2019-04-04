//@Author Milan Dabic


package login.Controller;


import login.model.Odeljenje;
import login.repository.Odeljenje_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/admin")
public class Konekcija_odeljenje {
    @Autowired
    private Odeljenje_Repository odeljenje_repository;
    @GetMapping(path = "/unesi_u_odeljenje")
    public @ResponseBody String unesi_ucenika(@RequestParam Integer broj_odeljenja, @RequestParam Integer id_ucitelja,
                                              @RequestParam Integer id_ucenika){
        Odeljenje o=new Odeljenje();
        o.setBroj_odeljenja(broj_odeljenja);
        o.setId_ucitelja(id_ucitelja);
        o.setId_ucenika(id_ucenika);
        odeljenje_repository.save(o);
        return "Ucenik je unet";
    }

    @GetMapping(path = "/izmeni_odeljenje")
    public @ResponseBody String izmeni_odeljenje(@RequestParam Integer id, @RequestParam Integer broj_odeljenja, @RequestParam Integer id_ucitelja,
                                                 @RequestParam Integer id_ucenika){
        Odeljenje o=odeljenje_repository.findById(id).get();
        o.setBroj_odeljenja(broj_odeljenja);
        o.setId_ucitelja(id_ucitelja);
        o.setId_ucenika(id_ucenika);
        odeljenje_repository.save(o);
        return "Odeljenje je izmenjeno";
    }

    @GetMapping(path = "/prikaz_odeljenja")
    public @ResponseBody Iterable<Odeljenje>prikaz_odeljenja(@RequestParam Integer broj_odeljenja){
        List<Odeljenje>odeljenje=odeljenje_repository.uceniciPoOdeljenju(broj_odeljenja);
        return odeljenje;
    }

    @GetMapping(path = "/ucitelj_odeljenje")
    public @ResponseBody Iterable<Odeljenje>ucitelj_odeljenje(@RequestParam Integer id_ucitelja){
        List<Odeljenje>uciteljOdeljenje=odeljenje_repository.odeljenjePoUcitelju(id_ucitelja);
        return uciteljOdeljenje;
    }

    @GetMapping(path = "/ucenik_odeljenje")
    public @ResponseBody Iterable<Odeljenje>ucenik_odeljenje(@RequestParam Integer id_ucenika){
        List<Odeljenje>ucenikOdeljenje=odeljenje_repository.odeljenjePoUceniku(id_ucenika);
        return ucenikOdeljenje;
    }

    @GetMapping(path = "/obrisi_odeljenje")
    public @ResponseBody String obrisi_odeljenje(@RequestParam Integer broj_odeljenja){
        odeljenje_repository.obrisiOdeljenje(broj_odeljenja);
        return "odeljenje je obrisano!";
    }

}
