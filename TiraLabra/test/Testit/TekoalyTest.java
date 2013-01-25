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
import tiralabra.Siirto;

/**
 *
 * @author lvapaaka
 */
public class TekoalyTest {

    private Hyvis hyvis;
    private Pahis pahis;
    private Matkija matkija;

    public TekoalyTest() {
    }

    @Before
    public void setUp() {
        hyvis = new Hyvis();
        pahis = new Pahis();
        matkija = new Matkija();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hyvisTekeeAinaYhteistyota() {
        assertTrue(hyvis.teeSiirto() == Siirto.YHTEISTYO);
        hyvis.maaritaSeuraavaSiirto(Siirto.PETOS);
        assertTrue(hyvis.teeSiirto() == Siirto.YHTEISTYO);
        hyvis.maaritaSeuraavaSiirto(Siirto.YHTEISTYO);
        assertTrue(hyvis.teeSiirto() == Siirto.YHTEISTYO);
    }

    @Test
    public void pahisPettaaAina() {
        assertTrue(pahis.teeSiirto() == Siirto.PETOS);
        pahis.maaritaSeuraavaSiirto(Siirto.PETOS);
        assertTrue(pahis.teeSiirto() == Siirto.PETOS);
        pahis.maaritaSeuraavaSiirto(Siirto.YHTEISTYO);
        assertTrue(pahis.teeSiirto() == Siirto.PETOS);
    }

    @Test
    public void matkijaMatkiiOikein() {
        matkija.maaritaSeuraavaSiirto(Siirto.YHTEISTYO);
        assertTrue(matkija.teeSiirto() == Siirto.YHTEISTYO);
        matkija.maaritaSeuraavaSiirto(Siirto.PETOS);
        assertTrue(matkija.teeSiirto() == Siirto.PETOS);
        matkija.maaritaSeuraavaSiirto(Siirto.YHTEISTYO);
        assertTrue(matkija.teeSiirto() == Siirto.YHTEISTYO);
    }
}