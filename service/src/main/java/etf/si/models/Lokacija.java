package etf.si.models;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="lokacija")
public class Lokacija implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

	private String naziv;

	public Lokacija(){
	}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }

	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return "Lokacija [id=" + id + ", naziv=" + naziv + "]";
	}
	public Lokacija(String naziv) {
		super();
		this.naziv = naziv;
	}
	
}
