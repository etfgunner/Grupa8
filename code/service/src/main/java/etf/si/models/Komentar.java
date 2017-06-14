package etf.si.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="komentar")
public class Komentar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

	@ManyToOne
	@JoinColumn(name="id_korisnika")
	private Korisnik korisnik;

	@ManyToOne
	@JoinColumn(name="id_patrole")
	private PrijavaPolozaja patrola;

    String tekst;
    public Komentar()
    {
    	
    }
	public Komentar(Korisnik k, PrijavaPolozaja p, String tekst) {
		super();
		this.korisnik = k;
		this.patrola = p;
		this.tekst = tekst;
	}
	@Override
	public String toString() {
		return "Komentar [id=" + id + ", Korisnik=" + korisnik + ", Patrola=" + patrola + ", tekst=" + tekst
				+ "]";
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik k) {
		this.korisnik = k;
	}

	public void setPatrola(PrijavaPolozaja p) { this.patrola = p; }
	public PrijavaPolozaja getPatrola() { return this.patrola; }

	public String getTekst() {
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
}
