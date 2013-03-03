/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Testit;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tietorakenteet.MinimiKeko;

/**
 *
 * @author lvapaaka
 */
public class MinimiKekoTest {

    @Before
    public void setUp() {
    }

    @Test
    public void kekoonLisaaminenLisaaKohtaan1() {
        MinimiKeko keko = new MinimiKeko();
        keko.lisaaKekoon(5);
        assertEquals(keko.palautaArvoIndeksista(1), 5);
    }

    @Test
    public void kahdenLuvunLisaaminenLaittaaNeOikeaanJarjestykseen() {
        MinimiKeko keko = new MinimiKeko();
        keko.lisaaKekoon(5);
        keko.lisaaKekoon(3);
        assertEquals(keko.palautaArvoIndeksista(1), 3);
        assertEquals(keko.palautaArvoIndeksista(2), 5);
    }

    @Test
    public void keonMinimiPalauttaaOikein() {
        MinimiKeko keko = new MinimiKeko(6);
        keko.lisaaKekoon(5);
        keko.lisaaKekoon(3);
        keko.lisaaKekoon(100);
        keko.lisaaKekoon(35);
        keko.lisaaKekoon(24);
        keko.lisaaKekoon(1);
        assertEquals(keko.minimi(), 1);
    }

    @Test
    public void poistaPieninPalauttaaOikein() {
        MinimiKeko keko = new MinimiKeko();
        keko.lisaaKekoon(5);
        keko.lisaaKekoon(3);
        keko.lisaaKekoon(12);
        keko.lisaaKekoon(14);
        keko.lisaaKekoon(16);
        keko.lisaaKekoon(18);
        keko.lisaaKekoon(19);
        assertEquals(3, keko.poistaPieninKeosta());
    }

    @Test
    public void kekoonLisatytArvotOvatJarjestyksessa() {
        MinimiKeko keko = new MinimiKeko();
        keko.lisaaKekoon(9);
        keko.lisaaKekoon(5);
        keko.lisaaKekoon(8);
        keko.lisaaKekoon(3);
        keko.lisaaKekoon(10);
        keko.lisaaKekoon(1);
        keko.lisaaKekoon(12);
        assertEquals(1, keko.poistaPieninKeosta());
        assertEquals(3, keko.poistaPieninKeosta());
        assertEquals(5, keko.poistaPieninKeosta());
        assertEquals(8, keko.poistaPieninKeosta());
        assertEquals(9, keko.poistaPieninKeosta());
        assertEquals(10, keko.poistaPieninKeosta());
        assertEquals(12, keko.poistaPieninKeosta());
    }

    @Test
    public void poistaPieninPienentaaKekoa() {
        MinimiKeko keko = new MinimiKeko();
        keko.lisaaKekoon(5);
        keko.lisaaKekoon(3);
        assertEquals(keko.getKeonKoko(), 2);
        keko.poistaPieninKeosta();
        assertEquals(keko.getKeonKoko(), 1);
    }

    @Test
    public void keonSuorituskykyLisays() {
        System.out.println("Lisaykset");
        lisaaKekoonJaOtaAika(1);
        lisaaKekoonJaOtaAika(10);
        lisaaKekoonJaOtaAika(100);
        lisaaKekoonJaOtaAika(1000);
        lisaaKekoonJaOtaAika(10000);
        lisaaKekoonJaOtaAika(100000);
        lisaaKekoonJaOtaAika(1000000);
    }

    @Test
    public void keonSuorituskykyPoisto() {
        System.out.println("Poistot");
        poistaKeostaJaOtaAika(1);
        poistaKeostaJaOtaAika(10);
        poistaKeostaJaOtaAika(100);
        poistaKeostaJaOtaAika(1000);
        poistaKeostaJaOtaAika(10000);
        poistaKeostaJaOtaAika(100000);
        poistaKeostaJaOtaAika(1000000);
    }

    private void poistaKeostaJaOtaAika(int montako) {
        MinimiKeko keko = new MinimiKeko(montako + 100);
        Random random = new Random();
        for (int i = 0; i < montako + 100; i++) {
            keko.lisaaKekoon(random.nextInt(1000));
        }
        long alkuaika = System.nanoTime();
        for (int i = 0; i < montako; i++) {
            keko.poistaPieninKeosta();
        }
        System.out.println("Kekopoisto (" + montako + "): " + (System.nanoTime() - alkuaika));
    }

    private void lisaaKekoonJaOtaAika(int montako) {
        MinimiKeko keko = new MinimiKeko(montako);
        Random random = new Random();
        long alkuaika = System.nanoTime();
        for (int i = 0; i < montako; i++) {
            keko.lisaaKekoon(random.nextInt(1000));
        }
        System.out.println("kekolisäys (" + montako + "): " + (System.nanoTime() - alkuaika));
    }
}
