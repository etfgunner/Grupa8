package etf.si.repositories;

import etf.si.models.Korisnik;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Lejla on 20/05/2017.
 */

@Repository
public interface KorisnikRepository extends CrudRepository<Korisnik, Integer> {

    public Korisnik findByIme (String ime);
    // public Korisnik findByEmail(String email);
    public Korisnik findByUsername(String username);
    public List<Korisnik> findAll();
    public Korisnik findByUsernameAndPassword(String username, String password);
    public List<Korisnik> findByAdminAndSuperAdmin(Boolean Admin, Boolean superAdmin);
}
