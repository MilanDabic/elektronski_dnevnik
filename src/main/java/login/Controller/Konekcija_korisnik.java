//@Author Milan Dabic


package login.Controller;

import login.model.Korisnik;
import login.repository.Korisnik_Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping(path = "/admin/")
public class Konekcija_korisnik {
    @Autowired
    private Korisnik_Repository korisnik_repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(path = "/dodaj_korisnika")
    public @ResponseBody String dodaj_Korisnika(@RequestParam String ime, @RequestParam String prezime,
                                                @RequestParam String username, @RequestParam String password){
        Korisnik k=new Korisnik();
        k.setIme(ime);
        k.setPrezime(prezime);
        k.setUsername(username);
        k.setPassword(passwordEncoder.encode(password));
        korisnik_repository.save(k);
        return "Sacuvan!";
    }
    @GetMapping(path ="/svi_korisnici")
    public @ResponseBody Iterable<Korisnik>procitajSveKorisnike(){
        return korisnik_repository.findAll();
    }

    @GetMapping(path = "/obrisi_korisnika")
    public @ResponseBody String obrisi_Korisnika(@RequestParam Integer id){
        korisnik_repository.deleteById(id);
        return "Korisnik je obrisan";
    }

    @GetMapping(path ="/pronadji_korisnika_po_id-u")
    public @ResponseBody Korisnik k(@RequestParam Integer id){
        Korisnik k =korisnik_repository.findById(id).get();
        return k; }

        @GetMapping(path ="/izmeni_korisnika")
        public @ResponseBody String izmeni_Korisnika(@RequestParam Integer id, @RequestParam String ime, @RequestParam String prezime,
                                                     @RequestParam String username, @RequestParam String password){
        Korisnik k =korisnik_repository.findById(id).get();

            k.setIme(ime);
            k.setPrezime(prezime);
            k.setUsername(username);
            k.setPassword(passwordEncoder.encode(password));
            korisnik_repository.save(k);
        return "Podaci su promenjeni";
        }

    @GetMapping(path ="/pronadji_korisnika_po_korisnickom_imenu")
    public @ResponseBody Iterable<Korisnik>nadjiKorisnika(@RequestParam String username){
        List<Korisnik>korisnici=korisnik_repository.pronadjiUsername(username);
        return korisnici;
    }


}

