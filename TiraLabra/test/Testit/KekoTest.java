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
import tiralabra.MinimiKeko;

/**
 *
 * @author lvapaaka
 */
public class KekoTest {

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
        assertEquals(3, keko.poistaPieninKeosta());
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
}
