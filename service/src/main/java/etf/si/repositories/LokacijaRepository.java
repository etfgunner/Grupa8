package etf.si.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import etf.si.models.Lokacija;

public interface LokacijaRepository extends CrudRepository<Lokacija, Integer> {
	public Lokacija findByNaziv(String naziv);
    public List<Lokacija> findAll();
}
