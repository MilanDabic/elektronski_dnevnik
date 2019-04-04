//@Author Milan Dabic


package login.Controller;


import login.model.Ucenik;
import login.repository.Ucenik_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping(path = "/admin")
public class Konekcija_ucenik {
    @Autowired
    private Ucenik_Repository ucenik_repository;


    @GetMapping(path = "/dodaj_ucenika")
    public @ResponseBody
    String dodaj_Ucenika(@RequestParam String ime, @RequestParam String prezime,
                         @RequestParam String jmbg, @RequestParam Integer izostanci) {

        Ucenik u = new Ucenik();
        u.setIme(ime);
        u.setPrezime(prezime);
        u.setJmbg(jmbg);
        u.setIzostanci(izostanci);
        ucenik_repository.save(u);
        return "Sacuvan!";
    }

    @GetMapping(path = "/svi_ucenici")
    public @ResponseBody
    Iterable<Ucenik> procitajSveUcenike() {
        return ucenik_repository.findAll();
    }

    @GetMapping(path = "/obrisi_ucenika")
    public @ResponseBody
    String obrisi_Ucenika(@RequestParam Integer id) {
        ucenik_repository.deleteById(id);
        return "Ucenik je obrisan";
    }

    @GetMapping(path = "/pronadji_ucenika_po_id-u")
    public @ResponseBody
    Ucenik u(@RequestParam Integer id) {
        Ucenik u = ucenik_repository.findById(id).get();
        return u;
    }

    @GetMapping(path = "/izmeni_ucenika")
    public @ResponseBody
    String izmeni_Ucenika(@RequestParam Integer id, @RequestParam String ime, @RequestParam String prezime,
                          @RequestParam String jmbg, @RequestParam Integer izostanci) {
        Ucenik u = ucenik_repository.findById(id).get();
        u.setIme(ime);
        u.setPrezime(prezime);
        u.setJmbg(jmbg);
        u.setIzostanci(izostanci);
        ucenik_repository.save(u);
        return "Podaci su promenjeni";
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

}
