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
import tiralabra.Logiikka;

/**
 *
 * @author lvapaaka
 */
public class LogiikkaTest {

    Logiikka log;

    @Before
    public void setUp() {
        log = new Logiikka();
    }

    @Test
    public void pelaaminenVaikuttaaTekoalyjenPisteisiinKunMolemmatTekevatYhteistyota() {
        Hyvis eka = new Hyvis();
        Hyvis toka = new Hyvis();
        assertEquals(0, eka.getPisteet());
        assertEquals(0, toka.getPisteet());
        log.pelaaKierros(eka, toka);
        assertEquals(1, eka.getPisteet());
        assertEquals(1, toka.getPisteet());
    }

    @Test
    public void viisiKierrostaVaikuttaaViisinkertaisesti() {
        Hyvis eka = new Hyvis();
        Hyvis toka = new Hyvis();
        assertEquals(0, eka.getPisteet());
        assertEquals(0, toka.getPisteet());
        log.pelaaKierroksia(5, eka, toka);
        assertEquals(5, eka.getPisteet());
        assertEquals(5, toka.getPisteet());
    }

    @Test
    public void pelaaminenVaikuttaaTekoalyjenPisteisiinKunMolemmatPettavat() {
        Pahis eka = new Pahis();
        Pahis toka = new Pahis();
        assertEquals(0, eka.getPisteet());
        assertEquals(0, toka.getPisteet());
        log.pelaaKierros(eka, toka);
        assertEquals(5, eka.getPisteet());
        assertEquals(5, toka.getPisteet());
    }

    @Test
    public void pelaaminenVaikuttaaTekoalyjenPisteisiinKunEnsimmainenPettaa() {
        Pahis eka = new Pahis();
        Hyvis toka = new Hyvis();
        assertEquals(0, eka.getPisteet());
        assertEquals(0, toka.getPisteet());
        log.pelaaKierros(eka, toka);
        assertEquals(0, eka.getPisteet());
        assertEquals(10, toka.getPisteet());
    }

    @Test
    public void negatiivinenKierrosMaaraEiTeeMitaan() {
        Hyvis h = new Hyvis();
        assertEquals(0, h.getPisteet());
        log.pelaaKierroksia(-50, h, h);
        assertEquals(0, h.getPisteet());
    }

    @Test
    public void lisatytTekoalytPelaavat() {
        Logiikka log2 = new Logiikka();
        Hyvis hyvis = new Hyvis();
        Matkija matkija = new Matkija();
        log2.lisaaTekoaly(hyvis);
        log2.lisaaTekoaly(matkija);
        log2.peluutaKaikkia();
        assertTrue(hyvis.getPisteet() > 0);
        assertTrue(matkija.getPisteet() > 0);
    }
}
