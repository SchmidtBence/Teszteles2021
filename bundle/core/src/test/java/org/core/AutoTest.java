package org.core;

import org.core.exceptions.AjtokSzamaNemMegfelelo;
import org.core.exceptions.GyartasiIdoNemMegfelelo;
import org.core.exceptions.RendszamNemMegfelelo;
import org.junit.Before;
import org.junit.Test;

import java.security.PublicKey;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class AutoTest {
    Auto testauto;

    @Before
    public void initTestauto(){
        testauto=new Auto();
    }

    @Test
    public void testAjtokSzamaMegfelelo() throws AjtokSzamaNemMegfelelo {
        Auto auto=new Auto();
        auto.setAjtokSzama(3);
    }
    @Test(expected = AjtokSzamaNemMegfelelo.class)
    public void testAjtokSzamaTulAlacsony() throws AjtokSzamaNemMegfelelo {
        Auto auto=new Auto();
        auto.setAjtokSzama(-1);
    }
    @Test(expected = AjtokSzamaNemMegfelelo.class)
    public void testAjtokSzamaTulMagas() throws AjtokSzamaNemMegfelelo {
        Auto auto=new Auto();
        auto.setAjtokSzama(6);
    }

    @Test
    public void testJoRendszam() throws RendszamNemMegfelelo
    {
        String rendszam="ABC-123";
        testauto.setRendszam(rendszam);
    }

    @Test(expected = RendszamNemMegfelelo.class)
    public void testKotojelNelkuliRendszam() throws RendszamNemMegfelelo{
        String rendszam="ABC123";
        testauto.setRendszam(rendszam);
    }

    @Test(expected = RendszamNemMegfelelo.class)
    public void testTulhosszuSzamosRendszam() throws RendszamNemMegfelelo{
        String rendszam="ABC-1234";
        testauto.setRendszam(rendszam);
    }

    @Test(expected = RendszamNemMegfelelo.class)
    public void testTulhosszuBetusRendszam() throws RendszamNemMegfelelo{
        String rendszam="ABCA-1234";
        testauto.setRendszam(rendszam);
    }

    @Test(expected = RendszamNemMegfelelo.class)
    public void testCsakszamosRendszam() throws RendszamNemMegfelelo{
        String rendszam="1234";
        testauto.setRendszam(rendszam);
    }

    @Test(expected = RendszamNemMegfelelo.class)
    public void testCsakBetusRendszam() throws RendszamNemMegfelelo{
        String rendszam="ABCE";
        testauto.setRendszam(rendszam);
    }

    @Test(expected = RendszamNemMegfelelo.class)
    public void testKisBetusRendszam() throws RendszamNemMegfelelo{
        String rendszam="aaa-123";
        testauto.setRendszam(rendszam);
    }

    @Test(expected = RendszamNemMegfelelo.class)
    public void testQBetuvelRendszam() throws RendszamNemMegfelelo{
        String rendszam="AAQ-123";
        testauto.setRendszam(rendszam);
    }

    @Test
    public void testJoGyartasIdo() throws GyartasiIdoNemMegfelelo{
        String gyartasido="2021-04-11";
        testauto.setGyartasiIdo(LocalDate.parse(gyartasido));
    }

    @Test(expected = GyartasiIdoNemMegfelelo.class)
    public void testKoraiGyartasIdo() throws GyartasiIdoNemMegfelelo{
        String gyartasido="2022-04-11";
        testauto.setGyartasiIdo(LocalDate.parse(gyartasido));
    }

    @Test(expected = GyartasiIdoNemMegfelelo.class)
    public void testKesoiGyartasIdo() throws GyartasiIdoNemMegfelelo{
        String gyartasido="1400-04-11";
        testauto.setGyartasiIdo(LocalDate.parse(gyartasido));
    }
}