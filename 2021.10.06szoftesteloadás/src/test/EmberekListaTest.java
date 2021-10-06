package test;

import emberek.EmberekLista;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.annotation.Target;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class EmberekListaTest {
    EmberekLista adatok;

    @Before
    public void feltolt(){
        this.adatok=new EmberekLista();
        adatok.add("Erika");
        adatok.add("Szilveszter");
        adatok.add("Judit");
        adatok.add("Miki");
        adatok.add("Miki");
    }
    @Test
    public void checkListSize(){
        int tenylegesmeret = this.adatok.size();
        int elvartmeret=4;

        assertEquals(elvartmeret,tenylegesmeret);
    }

    @Test
    public void emptyCheck(){
        boolean uresE=this.adatok.isEmpty();
        assertFalse(uresE);
    }

    @Test
    public void ujElemHozzaAd(){
        String ujEmber="valaki";
        int jelenlegiMeret=this.adatok.size();
        this.adatok.add(ujEmber);
        int ujMeret=this.adatok.size();

        assertEquals(jelenlegiMeret + 1,ujMeret);
        assertTrue(this.adatok.getEmberek().contains(ujEmber));
    }

    @Test
    public void teljesTartalomTorles(){
        this.adatok.removeAll();
        boolean uresE = adatok.isEmpty();

        assertTrue(uresE);
    }

    @Test
    public void LetezoEmberTorlese(){
        String LetezoEmber="Erika";
        this.adatok.remove(LetezoEmber);
    }

    @Test(expected = NoSuchElementException.class)
    public void nemLetezoEmberTorlese(){
        String nemLetezoEmber="Laci";
        this.adatok.remove(nemLetezoEmber);
    }

    @After
    public void listaKiUrit(){
        this.adatok.removeAll();
    }
}