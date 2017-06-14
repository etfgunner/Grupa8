package etf.si.services;

import etf.si.models.Korisnik;
import etf.si.repositories.KorisnikRepository;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Lejla on 20/05/2017.
 */

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository userRepo;

    public Iterable<Korisnik> findAll(){
        List<Korisnik> users = userRepo.findAll();
        
        for (int i = 0; i < users.size(); i ++) {
        	users.get(i).setPassword(null);
        }
        
        return users;
    }

    public Korisnik findKorisnik(Integer id){
        return userRepo.findOne(id);
    }

    public void addKorisnik(Korisnik k){
        userRepo.save(k);
    }

    public void deleteKorisnik(Korisnik k){
        userRepo.delete(k);
    }

    public void deleteKorisnik(Integer id){
        userRepo.delete(userRepo.findOne(id));
    }

    public Boolean updateKorisnik(Korisnik k){
        userRepo.save(k);
        return true;
    }
    public Boolean registerKorisnik(Korisnik korisnik) {

        if(userRepo.findByUsername(korisnik.getUsername()) != null) {
            throw new ServiceException("Korisnik sa datim username-om vec postoji!");
        }

        Korisnik korisnik1 = userRepo.save(korisnik);

        return korisnik1 != null;

    }
    
    public Iterable<Korisnik> getByAdminAndSuperAdmin(Boolean admin, Boolean superAdmin){
    	List<Korisnik> users = userRepo.findByAdminAndSuperAdmin(admin, superAdmin);
        
        for (int i = 0; i < users.size(); i ++) {
        	users.get(i).setPassword(null);
        }
        
        return users;
    }
    
    /* public Boolean isAdmin(Integer id){
        if (userRepo.findOne(id).getAdmin()) return true;
        return false;
    }

    public Boolean isSuperAdmin(Integer id){
        if (userRepo.findOne(id).getSuperAdmin()) return true;
        return false;
    } */

    // TODO: Kod za registraciju korisnika
/*    public Boolean registerKorisnik(Korisnik k) {
    } */

}

