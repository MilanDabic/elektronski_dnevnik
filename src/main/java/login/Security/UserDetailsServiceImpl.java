//@Author Milan Dabic

package login.Security;

import login.model.Korisnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import login.repository.Korisnik_Repository;

import java.util.Collection;


@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private Korisnik_Repository korisnikRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Korisnik korisnik=korisnikRepository.nadjiUsername(username);

            return new org.springframework.security.core.userdetails.User(korisnik.getUsername(), korisnik.getPassword(), getAuthorities(korisnik));
        }
        private static Collection<? extends GrantedAuthority> getAuthorities(Korisnik korisnik){
            String[] korisnikUloge = korisnik.getUloge().stream().map((uloga) -> uloga.getIme()).toArray(String[]::new);
            Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(korisnikUloge);
            return authorities;
        }
    }
