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

    @Test
    public void hyvisOnKiva() {
        assertTrue(hyvis.teeSiirto() == Siirto.YHTEISTYO);
        hyvis.vastaanotaSiirto(Siirto.PETOS);
        assertTrue(hyvis.teeSiirto() == Siirto.YHTEISTYO);
        hyvis.vastaanotaSiirto(Siirto.YHTEISTYO);
        assertTrue(hyvis.teeSiirto() == Siirto.YHTEISTYO);
    }

    @Test
    public void pahisOnPaha() {
        assertTrue(pahis.teeSiirto() == Siirto.PETOS);
        pahis.vastaanotaSiirto(Siirto.PETOS);
        assertTrue(pahis.teeSiirto() == Siirto.PETOS);
        pahis.vastaanotaSiirto(Siirto.YHTEISTYO);
        assertTrue(pahis.teeSiirto() == Siirto.PETOS);
    }

    @Test
    public void matkijaMatkii() {
        matkija.vastaanotaSiirto(Siirto.YHTEISTYO);
        assertTrue(matkija.teeSiirto() == Siirto.YHTEISTYO);
        matkija.vastaanotaSiirto(Siirto.PETOS);
        assertTrue(matkija.teeSiirto() == Siirto.PETOS);
        matkija.vastaanotaSiirto(Siirto.YHTEISTYO);
        assertTrue(matkija.teeSiirto() == Siirto.YHTEISTYO);
    }

    @Test
    public void kostajaKostaa() {
        Kostaja kostaja = new Kostaja();
        assertTrue(kostaja.teeSiirto() == Siirto.YHTEISTYO);
        kostaja.vastaanotaSiirto(Siirto.YHTEISTYO);
        assertTrue(kostaja.teeSiirto() == Siirto.YHTEISTYO);
        kostaja.vastaanotaSiirto(Siirto.PETOS);
        assertTrue(kostaja.teeSiirto() == Siirto.PETOS);
    }

    @Test
    public void epailijaToimii() {
        Epailija epailija = new Epailija();
        assertTrue(epailija.teeSiirto() == Siirto.PETOS);
        epailija.vastaanotaSiirto(Siirto.PETOS);
        assertTrue(epailija.teeSiirto() == Siirto.PETOS);
        epailija.vastaanotaSiirto(Siirto.YHTEISTYO);
        assertTrue(epailija.teeSiirto() == Siirto.YHTEISTYO);
    }

    @Test
    public void kuvioNoudattaaKuviota() {
        Kuvio kuvio = new Kuvio();
        assertTrue(kuvio.teeSiirto() == Siirto.YHTEISTYO);
        kuvio.vastaanotaSiirto(Siirto.PETOS);
        assertTrue(kuvio.teeSiirto() == Siirto.YHTEISTYO);
        kuvio.vastaanotaSiirto(Siirto.PETOS);
        assertTrue(kuvio.teeSiirto() == Siirto.PETOS);
        kuvio.vastaanotaSiirto(Siirto.PETOS);
        assertTrue(kuvio.teeSiirto() == Siirto.YHTEISTYO);
        kuvio.vastaanotaSiirto(Siirto.PETOS);
        assertTrue(kuvio.teeSiirto() == Siirto.YHTEISTYO);
        kuvio.vastaanotaSiirto(Siirto.PETOS);
        assertTrue(kuvio.teeSiirto() == Siirto.PETOS);
        kuvio.vastaanotaSiirto(Siirto.PETOS);
    }

    @Test
    public void laskijaLaskeeOikein() {
        Laskija laskija = new Laskija(0);
        assertTrue(laskija.teeSiirto() == Siirto.YHTEISTYO);
        laskija.vastaanotaSiirto(Siirto.PETOS);
        assertTrue(laskija.teeSiirto() == Siirto.PETOS);
        laskija.vastaanotaSiirto(Siirto.YHTEISTYO);
        assertTrue(laskija.teeSiirto() == Siirto.YHTEISTYO);
    }
}
