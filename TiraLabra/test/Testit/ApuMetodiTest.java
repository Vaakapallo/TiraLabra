package Testit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import logiikka.ApuMetodeita;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lvapaaka
 */
public class ApuMetodiTest {
    
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void merkkiLaskuriLaskeeYhdenMerkinOikein(){
        String sana = "a";
        assertEquals(1, ApuMetodeita.laskeMerkinMaaraMerkkijonossa('a', sana));
    }
    
    @Test
    public void merkkiLaskuriLaskeeMontaMerkkiaOikein(){
        String sana = "banaani";
        assertEquals(3, ApuMetodeita.laskeMerkinMaaraMerkkijonossa('a', sana));
    }
    
    @Test
    public void merkkiLaskuriEiLoydaVaariaMerkkeja(){
        String sana = "banaani";
        assertEquals(0, ApuMetodeita.laskeMerkinMaaraMerkkijonossa('u', sana));
    }
    
    @Test
    public void merkkiLaskuriOsaaKasitellaTyhjanSyotteen(){
        String sana = "";
        assertEquals(0, ApuMetodeita.laskeMerkinMaaraMerkkijonossa('a', sana));
    }
    
    
}
