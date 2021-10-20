package hu.uni.miskolc.teszteles.service;

import hu.uni.miskolc.teszteles.dao.AutoDao;
import hu.uni.miskolc.teszteles.service.exception.AutoNemTalalhato;
import hu.uni.miskolc.teszteles.service.exception.RendszamMarFoglalt;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.core.Auto;

import java.time.LocalDate;
import java.util.Collection;

import java.util.stream.Collectors;

public class autoService {

    private AutoDao dao;

    public autoService(AutoDao dao) {
        super();
        this.dao = dao;
    }

    public Collection<Auto> getAllAuto(){
        return dao.readAllAutos();
    }

    public Auto getAutoByRendszam(String rendszam) throws AutoNemTalalhato {
        return dao.readAutodById(rendszam);
    }

    public Collection<Auto> getAllKorozottAuto(){
        Collection<Auto> autos=getAllAuto();
        Collection<Auto> korozott=autos.stream().filter(a -> a.isKorozott() ).collect(Collectors.toList());
        return korozott;
    }

    public Collection<Auto> getAllAutoDatumKozott(LocalDate tol,LocalDate ig){
        Collection<Auto> autos=getAllAuto();
        Predicate<Auto> pred = a -> a.getGyartasiIdo().isAfter(tol) && a.getGyartasiIdo().isBefore(ig);
        CollectionUtils.filter(autos,pred);
        return autos;
    }

    public void addAuto(Auto auto) throws RendszamMarFoglalt {
        dao.createAuto(auto);
    }

    public void deleteAuto(Auto auto){
        dao.deleteAuto(auto);
    }

    public void updateAuto(Auto auto){
        dao.updateAuto(auto);
    }
}
