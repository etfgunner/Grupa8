package etf.si.services;

import org.springframework.beans.factory.annotation.Autowired;

import etf.si.models.Komentar;
import etf.si.models.Korisnik;
import etf.si.models.Lokacija;
import etf.si.repositories.KorisnikRepository;
import etf.si.repositories.LokacijaRepository;
import org.springframework.stereotype.Service;

@Service
public class LokacijaService {

	@Autowired
    private LokacijaRepository userRepo;

    public Iterable<Lokacija> findAll(){
        return userRepo.findAll();
    }

    public Lokacija findLokacija(String naziv){
        return userRepo.findByNaziv(naziv);
    }
    public Lokacija findLokacija(Integer id){
        return userRepo.findOne(id);
    }

    public void addLokacija(Lokacija k){
        userRepo.save(k);
    }

    public void deleteLokacija(Lokacija k){
        userRepo.delete(k);
    }

    public void deleteLokacija(String naziv){
        userRepo.delete(userRepo.findByNaziv(naziv));
    }

    public Boolean updateLokacija(Lokacija k){
        userRepo.save(k);
        return true;
    }

	
}
