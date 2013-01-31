/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tekoalyt;

import tiralabra.Siirto;

/**
 * Testien avulla kehitetty tekoäly, joka systemaattisesti testataan, niin että
 * se pärjää mahdollisimman hyvin kaikkia toisia tekoälyja vastaan.
 *
 * @author lvapaaka
 */
public class TTDtekoaly extends AI {

    public TTDtekoaly() {
        super("TTDtekoaly", Siirto.YHTEISTYO);
    }

    @Override
    public void vastaanotaSiirto(Siirto siirto) {
        if (siirto == Siirto.PETOS) {
            seuraavaSiirto = Siirto.PETOS;
        }
    }

    @Override
    public void palautaAlkuperainenTila() {
    }
}
