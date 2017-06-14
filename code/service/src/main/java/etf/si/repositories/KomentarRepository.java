package etf.si.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import etf.si.models.Komentar;

@Repository
public interface KomentarRepository extends CrudRepository<Komentar, Integer> {

    public Komentar findById(int id);
    public List<Komentar> findAll();
}