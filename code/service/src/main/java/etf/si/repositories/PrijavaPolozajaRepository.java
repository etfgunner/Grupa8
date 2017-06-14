package etf.si.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import etf.si.models.PrijavaPolozaja;

import java.util.List;

@Repository
public interface PrijavaPolozajaRepository extends CrudRepository<PrijavaPolozaja, Integer> {

    List<PrijavaPolozaja> findAll();


    //public List<PrijavaPolozaja> findAllWithLocation();

}
