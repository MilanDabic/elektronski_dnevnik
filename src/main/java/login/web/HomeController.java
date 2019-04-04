//@Author Milan Dabic


package login.web;

import login.model.Korisnik;
import login.model.Poruka;
import login.repository.Poruka_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HomeController {
    @Autowired
    private Poruka_repository poruka_repository;


    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("msgs", poruka_repository.findAll());
        return "userhome";
    }

    @PostMapping("/messages")
    public String saveMessage(Poruka message) {
        poruka_repository.save(message);
        return "redirect:/home";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new Korisnik());

        return "registracija";
    }
}

