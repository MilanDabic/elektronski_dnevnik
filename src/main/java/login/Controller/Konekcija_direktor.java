package login.Controller;

import login.model.Ocene;
import login.model.Predmeti;
import login.repository.Ocene_Repository;
import login.repository.Predmeti_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/direktor/")
public class Konekcija_direktor {
    @Autowired
    private Ocene_Repository ocene_repository;
    @Autowired
    Predmeti_repository predmeti_repository;

    @GetMapping(path = "/statistika_uspesnosti_odeljenja")
    public @ResponseBody List<Double> prosecnaOcenaOdeljenjaPoPredmetu(@RequestParam Integer id_odeljenja) {


        Iterable<Predmeti> predmeti = predmeti_repository.findAll();
         List<Double>prosecneOcene= new ArrayList<>();

        for (Predmeti p : predmeti) {

            List<Ocene> ocene = ocene_repository.ocenePoOdeljenjuIPredmetu(id_odeljenja, p.getId());
            Double sumaOcena = 0.0;
            for (Ocene o : ocene) {

                sumaOcena = sumaOcena + new Double(o.getOcena());
            }
            Double prosecnaOcena = sumaOcena / (double) ocene.size();
            prosecneOcene.add(prosecnaOcena);

        }
        return prosecneOcene;


    }

    @GetMapping(path = "/statistika_uspesnosti_po_predmetu")
    public @ResponseBody List<Double> prosecnaOcenaPoPredmetu(@RequestParam Integer id_predmeta){
        Iterable<Predmeti> predmeti = predmeti_repository.findAll();
        List<Double>prosecneOcene= new ArrayList<>();
        for (Predmeti p : predmeti) {
        List<Ocene> ocene=ocene_repository.ocenePoPredmetu(id_predmeta);
        Double sumaOcena=0.0;
        for(Ocene o: ocene){

            sumaOcena=sumaOcena+new Double(o.getOcena());
        }
        Double prosecnaOcena=sumaOcena/(double)ocene.size();
        prosecneOcene.add(prosecnaOcena);

        }

        return prosecneOcene;

    }

}
