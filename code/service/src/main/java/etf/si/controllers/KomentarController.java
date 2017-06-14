package etf.si.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import etf.si.models.Komentar;
import etf.si.models.Korisnik;
import etf.si.services.KomentarService;
import etf.si.services.KorisnikService;

@RestController
@CrossOrigin
@RequestMapping(path= "/komentari")
public class KomentarController {

    @Autowired
    private KomentarService userService;

    public void setUserService(KomentarService userService){
        this.userService = userService;
    }

    @RequestMapping(path="/get/all", method = RequestMethod.GET)
    public List<Komentar> findAll() {
        List<Komentar> komentari;
        komentari = (List<Komentar>) userService.findAll();
        return komentari;
    }

    @RequestMapping(path="/get/{id}", method = RequestMethod.GET)
    public Komentar getKomentar(@PathVariable("id") Integer id){
        return userService.findKomentar(id);
    }

    @RequestMapping(path="/getbylocation/{id}", method = RequestMethod.GET)
    public List<Komentar> getKomentarByLocation(@PathVariable("id") Integer id){
        return userService.findKomentarByLocation(id);
    }

    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deleteKomentar(@RequestParam(name = "id") Integer id) {
        userService.deleteKomentar(id);
        return "Done";
    }
}