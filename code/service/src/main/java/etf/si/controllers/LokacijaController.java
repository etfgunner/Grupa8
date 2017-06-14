package etf.si.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import etf.si.models.Korisnik;
import etf.si.models.Lokacija;
import etf.si.services.KorisnikService;
import etf.si.services.LokacijaService;

@RestController
@CrossOrigin
@RequestMapping(path= "/lokacije")
public class LokacijaController {

    @Autowired
    private LokacijaService userService;

    public void setUserService(LokacijaService userService){
        this.userService = userService;
    }

    @RequestMapping(path="/get/all", method = RequestMethod.GET)
    public List<Lokacija> findAll() {
        List<Lokacija> lokacije;
        lokacije = (List<Lokacija>) userService.findAll();
        return lokacije;
    }

    @RequestMapping(path="/get/{id}", method = RequestMethod.GET)
    public Lokacija getLokacija(@PathVariable("id") String id){
        return userService.findLokacija(id);
    }

    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deleteLokacija(@RequestParam(name = "id") String id) {
        userService.deleteLokacija(id);
        return "Done";
    }
}