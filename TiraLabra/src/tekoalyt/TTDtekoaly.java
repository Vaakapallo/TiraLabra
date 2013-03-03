/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tekoalyt;

import logiikka.Siirto;

/**
 * Testien avulla kehitetty tekoäly, joka systemaattisesti testataan, niin että
 * se pärjää mahdollisimman hyvin kaikkia toisia tekoälyja vastaan.
 * 
 * HYLLYTETTY! Ei toimi!
 *
 * @author lvapaaka
 */
public class TTDtekoaly extends AI {

    public TTDtekoaly() {
        super("TTDtekoaly", Siirto.YHTEISTYO);
    }

    @Override
    public void vastaanotaSiirto(Siirto vastustajanSiirto) {
        if (vastustajanSiirto == Siirto.PETOS) {
            seuraavaSiirto = Siirto.PETOS;
        }
    }

    @Override
    public void palautaAlkuperainenTila() {
    }
}
