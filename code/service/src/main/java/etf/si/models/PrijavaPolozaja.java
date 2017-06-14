package etf.si.models;
import java.io.Serializable;
import java.sql.Time;

import javax.persistence.*;

@Entity
@Table(name="prijavapolozaja")
public class PrijavaPolozaja implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id_korisnika")
    private Korisnik korisnik;

    @ManyToOne
    @JoinColumn(name="id_lokacije")
    private Lokacija lokacija;

    private String vrsta_kontrole;
    private Time vrijeme_prijave;
    private Integer ispravnost_prijave;

    public PrijavaPolozaja () {}

    public PrijavaPolozaja(Integer id, Korisnik k, Lokacija l, String vrsta_kontrole, Time vrijeme_prijave, Integer ispravnost_prijave) {
        this.id = id;
        this.korisnik = k;
        this.lokacija = l;
        this.vrsta_kontrole = vrsta_kontrole;
        this.vrijeme_prijave = vrijeme_prijave;
        this.ispravnost_prijave = ispravnost_prijave;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik k) {
        this.korisnik = k;
    }

    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija l) {
        this.lokacija = l;
    }

    public String getVrsta_kontrole() {
        return vrsta_kontrole;
    }

    public void setVrsta_kontrole(String vrsta_kontrole) {
        this.vrsta_kontrole = vrsta_kontrole;
    }

    public Time getVrijeme_prijave() {
        return vrijeme_prijave;
    }

    public void setVrijeme_prijave(Time vrijeme_prijave) {
        this.vrijeme_prijave = vrijeme_prijave;
    }

    public Integer getIspravnost_prijave() {
        return ispravnost_prijave;
    }

    public void setIspravnost_prijave(Integer ispravnost_prijave) {
        this.ispravnost_prijave = ispravnost_prijave;
    }
}