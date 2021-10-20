package hu.uni.miskolc.teszteles.dao;

import hu.uni.miskolc.teszteles.service.exception.AutoNemTalalhato;
import hu.uni.miskolc.teszteles.service.exception.RendszamMarFoglalt;
import org.core.Auto;

import java.util.Collection;

public interface AutoDao {

    public Collection<Auto> readAllAutos();

    public Auto readAutodById(String rendszam) throws AutoNemTalalhato;

    public void createAuto(Auto auto) throws RendszamMarFoglalt;

    public void updateAuto(Auto auto);

    public void deleteAuto(Auto auto);

    public void deleteAutoById(String rendszam);
}
