//@Author Milan Dabic

package login.Controller;


import login.model.Ucenik;
import login.repository.Ucenik_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(path = "/roditelj")
public class Konekcija_roditelj {
    @Autowired
    private Ucenik_Repository ucenik_repository;

 //    @RequestMapping(value = "/username", method = RequestMethod.GET)
//    @ResponseBody
//    public String currentUserNameSimple(HttpServletRequest request) {
//        Principal principal = request.getUserPrincipal();
//        return principal.getName();
//    }

    //Prikaz ucenika prema ulogovanom username-u
    @RequestMapping(value = "/pronadji_ucenika", method = RequestMethod.GET)
    @ResponseBody
    Iterable<Ucenik> ucenikUsername(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
//         principal.getName();
        List<Ucenik> ucenici = ucenik_repository.ucenikPoRoditelju(principal.getName());
        return ucenici;
    }
}
