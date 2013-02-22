/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Testit;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import tekoalyt.*;
import logiikka.Siirto;

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
    public void hyvisOnHyva() {
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
        AI kostaja = new Kostaja();
        assertTrue(kostaja.teeSiirto() == Siirto.YHTEISTYO);
        kostaja.vastaanotaSiirto(Siirto.YHTEISTYO);
        assertTrue(kostaja.teeSiirto() == Siirto.YHTEISTYO);
        kostaja.vastaanotaSiirto(Siirto.PETOS);
        assertTrue(kostaja.teeSiirto() == Siirto.PETOS);
    }

    @Test
    public void epailijaToimii() {
        AI epailija = new Epailija();
        assertTrue(epailija.teeSiirto() == Siirto.PETOS);
        epailija.vastaanotaSiirto(Siirto.PETOS);
        assertTrue(epailija.teeSiirto() == Siirto.PETOS);
        epailija.vastaanotaSiirto(Siirto.YHTEISTYO);
        assertTrue(epailija.teeSiirto() == Siirto.YHTEISTYO);
    }

    @Test
    public void kuvioNoudattaaKuviota() {
        AI kuvio = new Kuvio();
        for (int i = 0; i < 5; i++) {
            assertTrue(kuvio.teeSiirto() == Siirto.YHTEISTYO);
            kuvio.vastaanotaSiirto(Siirto.PETOS);
            assertTrue(kuvio.teeSiirto() == Siirto.YHTEISTYO);
            kuvio.vastaanotaSiirto(Siirto.PETOS);
            assertTrue(kuvio.teeSiirto() == Siirto.PETOS);
            kuvio.vastaanotaSiirto(Siirto.PETOS);
        }
    }

    @Test
    public void laskijaLaskeeOikein() {
        AI laskija = new Laskija(0);
        assertTrue(laskija.teeSiirto() == Siirto.YHTEISTYO);
        laskija.vastaanotaSiirto(Siirto.PETOS);
        assertTrue(laskija.teeSiirto() == Siirto.PETOS);
        laskija.vastaanotaSiirto(Siirto.YHTEISTYO);
        assertTrue(laskija.teeSiirto() == Siirto.YHTEISTYO);
    }

    @Test
    public void isompiLaskijaLaskeeOikein() {
        AI laskija = new Laskija(10);
        assertTrue(laskija.teeSiirto() == Siirto.YHTEISTYO);
        for (int i = 0; i < 10; i++) {
            laskija.vastaanotaSiirto(Siirto.PETOS);
        }
        assertTrue(laskija.teeSiirto() == Siirto.YHTEISTYO);
        laskija.vastaanotaSiirto(Siirto.PETOS);
        assertTrue(laskija.teeSiirto() == Siirto.PETOS);
    }

    @Test
    public void kokeilijaPettaaHyvaaVastaan() {
        AI kokeilija = new Kokeilija();
        assertTrue(kokeilija.teeSiirto() == Siirto.YHTEISTYO);
        kokeilija.vastaanotaSiirto(Siirto.YHTEISTYO);
        assertTrue(kokeilija.teeSiirto() == Siirto.YHTEISTYO);
        kokeilija.vastaanotaSiirto(Siirto.YHTEISTYO);
        assertTrue(kokeilija.teeSiirto() == Siirto.PETOS);
    }

    @Test
    public void montaKertaaPetettyKokeilijaPettaa() {
        AI kokeilija = new Kokeilija();
        for (int i = 0; i < 5; i++) {
            kokeilija.vastaanotaSiirto(Siirto.PETOS);
        }
        assertTrue(kokeilija.teeSiirto() == Siirto.PETOS);
    }

    @Test
    public void opportunistiPysyyKivana() {
        AI opportunisti = new Opportunisti();
        for (int i = 0; i < 100; i++) {
            assertTrue(opportunisti.teeSiirto() == Siirto.YHTEISTYO);
            opportunisti.vastaanotaSiirto(Siirto.YHTEISTYO);
        }
    }

    @Test
    public void opportunistiOppiiSiirtojenMaaranJaPettaaViimeisella() {
        AI opportunisti = new Opportunisti();
        for (int i = 0; i < 10; i++) {
            opportunisti.vastaanotaSiirto(Siirto.YHTEISTYO);
        }
        assertTrue(opportunisti.teeSiirto() == Siirto.YHTEISTYO);

        opportunisti.palautaAlkuperainenTila();

        for (int i = 0; i < 10; i++) {
            opportunisti.vastaanotaSiirto(Siirto.YHTEISTYO);
        }
        assertTrue(opportunisti.teeSiirto() == Siirto.PETOS);
    }

    @Test
    public void pahaLaskuriPettaaHeti() {
        AI pahaLaskija = new Laskija(-5);
        assertTrue(pahaLaskija.teeSiirto() == Siirto.PETOS);
    }
}
