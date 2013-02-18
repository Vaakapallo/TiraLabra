/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Testit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tekoalyt.*;
import tekoalyt.TTDtekoaly;
import logiikka.Peluuttaja;
import logiikka.Siirto;

/**
 * Parasta (toivottavasti) tekoälyä testaavat testiluokka.
 *
 * @author lvapaaka
 */
public class TTDTekoalyTest {

    private Peluuttaja log;

    @Before
    public void setUp() {
        log = new Peluuttaja();
    }

    @Test
    public void tekoalySaaNimenLuodessa() {
        TTDtekoaly tekoaly = new TTDtekoaly();
        assertTrue("TTDtekoaly".equals(tekoaly.getNimi()));
    }

    @Test
    public void tekoalySaaSiirronLuodessa() {
        TTDtekoaly tekoaly = new TTDtekoaly();
        assertTrue(tekoaly.teeSiirto() == Siirto.YHTEISTYO);
    }

    @Test
    public void tekoalyTekeeMontaSiirtoaPerakkain() {
        TTDtekoaly tekoaly = new TTDtekoaly();
        assertTrue(tekoaly.teeSiirto() == Siirto.YHTEISTYO);
        tekoaly.vastaanotaSiirto(Siirto.PETOS);
        assertNotNull(tekoaly.teeSiirto());
    }

    private boolean pelaaJaVertaa(AI toinen) {
        TTDtekoaly tekoaly = new TTDtekoaly();
        log.pelaaKierroksia(100, tekoaly, toinen);
        return (tekoaly.getPisteet() <= toinen.getPisteet() + 10);
    }

    @Test
    public void tekoalyParjaaHyvikselle() {
        assertTrue(pelaaJaVertaa(new Hyvis()));
    }

    @Test
    public void tekoalyParjaaPahikselle() {
        assertTrue(pelaaJaVertaa(new Pahis()));
    }

    @Test
    public void tekoalyParjaaKiltilleLaskijalle() {
        assertTrue(pelaaJaVertaa(new Laskija(10)));
    }

    @Test
    public void tekoalyParjaaPahalleLaskijalle() {
        assertTrue(pelaaJaVertaa(new Laskija(-10)));
    }

    @Test
    public void tekoalyParjaaLaskijalle() {
        assertTrue(pelaaJaVertaa(new Laskija(10)));
    }
}
