package etf.si.services;

import org.springframework.stereotype.Service;

import etf.si.models.PrijavaPolozaja;

import etf.si.repositories.PrijavaPolozajaRepository;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class PrijavaPolozajaService {

    @Autowired
    private PrijavaPolozajaRepository prijavaPolozajaRepository;

    public Iterable<PrijavaPolozaja> findAll(){
        return prijavaPolozajaRepository.findAll();
    }

    public PrijavaPolozaja findPrijavaPolozaja(Integer id){
        return prijavaPolozajaRepository.findOne(id);
    }

    public void addPrijavaPolozaja(PrijavaPolozaja p){
        prijavaPolozajaRepository.save(p);
    }

    public void deletePrijavaPolozaja(PrijavaPolozaja p){
        prijavaPolozajaRepository.delete(p.getId());
    }

    public void deletePrijavaPolozaja(Integer id){
        prijavaPolozajaRepository.delete(prijavaPolozajaRepository.findOne(id));
    }

    public Boolean updatePrijavaPolozaja(PrijavaPolozaja p){
        prijavaPolozajaRepository.save(p);
        return true;
    }
}