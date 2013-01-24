/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tekoalyt;

import tiralabra.Siirto;

/**
 *
 * @author lvapaaka
 */
public class Epailija extends AI {

    public Epailija() {
        super("Epailija", Siirto.PETOS);
    }

    @Override
    public void vastaanotaSiirto(Siirto siirto) {
        if (siirto == Siirto.YHTEISTYO) {
            seuraavaSiirto = Siirto.YHTEISTYO;
        }
    }
}
