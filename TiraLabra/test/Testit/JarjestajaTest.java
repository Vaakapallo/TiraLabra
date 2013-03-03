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
import tietorakenteet.Jarjestaja;

/**
 * Järjestysalgoritmin toimintaa testaava luokka.
 *
 * @author lvapaaka
 */
public class JarjestajaTest {

    @Test
    public void jarjestajanLuontiToimii() {
        Jarjestaja jarjestaja = new Jarjestaja(new AI[5]);
        assertNotNull(jarjestaja);
    }

    @Test
    public void jarjestajaToimiiyhdellaTekoalylla() {
        AI[] tekoalyt = new AI[1];
        AI pahis = new Pahis();
        tekoalyt[0] = pahis;
        Jarjestaja jarjestaja = new Jarjestaja(tekoalyt);
        assertEquals(pahis, jarjestaja.kekoJarjestaminen()[0]);
    }

    @Test
    public void jarjestajaJarjestaaKaksiTekoalyaOikein() {
        AI[] tekoalyt = new AI[2];
        AI pahis = new Pahis();
        AI hyvis = new Hyvis();
        pahis.lisaaPisteita(10);
        tekoalyt[0] = pahis;
        tekoalyt[1] = hyvis;
        Jarjestaja jarjestaja = new Jarjestaja(tekoalyt);
        assertEquals(hyvis, jarjestaja.kekoJarjestaminen()[0]);
    }

    @Test
    public void JarjestajajarjestaaViisiTekoalyaOikein() {
        AI[] tekoalyt = new AI[5];
        AI pahis = new Pahis();
        AI hyvis = new Hyvis();
        AI kuvio = new Kuvio();
        AI kostaja = new Kostaja();
        AI opportunisti = new Opportunisti();
        kostaja.lisaaPisteita(-10);
        hyvis.lisaaPisteita(10);
        kuvio.lisaaPisteita(20);
        opportunisti.lisaaPisteita(5);

        tekoalyt[0] = pahis;
        tekoalyt[1] = hyvis;
        tekoalyt[2] = kuvio;
        tekoalyt[3] = kostaja;
        tekoalyt[4] = opportunisti;
        Jarjestaja jarjestaja = new Jarjestaja(tekoalyt);

        AI[] jarjestettyna = jarjestaja.kekoJarjestaminen();
        assertTrue(jarjestettyna[0] == kostaja);
        assertTrue(jarjestettyna[1] == pahis);
        assertTrue(jarjestettyna[2] == opportunisti);
        assertTrue(jarjestettyna[3] == hyvis);
        assertTrue(jarjestettyna[4] == kuvio);
    }
}
