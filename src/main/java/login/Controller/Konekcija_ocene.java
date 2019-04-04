//@Author Milan Dabic


package login.Controller;

import login.model.Ocene;
import login.repository.Ocene_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/admin")
public class Konekcija_ocene {
    @Autowired
    private Ocene_Repository ocene_repository;
    @GetMapping(path = "/unesi_ocenu")
    public @ResponseBody String unesi_Ocenu(@RequestParam Integer id_ucenika,
                       @RequestParam Integer id_predmeta, @RequestParam Integer ocena) {
        Ocene o = new Ocene();
        o.setId_ucenika(id_ucenika);
        o.setId_predmeta(id_predmeta);
        o.setOcena(ocena);
        ocene_repository.save(o);
        return "Ocena je uneta!";
    }

    @GetMapping(path = "/ocene_po_uceniku")
    public @ResponseBody Iterable<Ocene>oceneUcenik(@RequestParam Integer id_ucenika){
        List<Ocene>ocene=ocene_repository.ocenePoUceniku(id_ucenika);
        return ocene;
    }

    @GetMapping(path = "/ocene_po_predmetu")
    public @ResponseBody Iterable<Ocene>ocenePredmet(@RequestParam Integer id_predmeta){
        List<Ocene>ocene=ocene_repository.ocenePoPredmetu(id_predmeta);
        return ocene;
    }
}
