package etf.si.services;

import etf.si.models.Korisnik;
import etf.si.repositories.KorisnikRepository;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private KorisnikRepository _userRepository;

    public Korisnik checkLoginData(String username, String password){
        return _userRepository.findByUsernameAndPassword(username, password);
    }
}