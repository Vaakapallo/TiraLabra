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
public class Kuvio extends AI {

    private int laskuri;

    public Kuvio() {
        super("Kuvio", Siirto.YHTEISTYO);
        laskuri = 0;
    }

    @Override
    public void vastaanotaSiirto(Siirto siirto) {
        if (laskuri % 3 == 0) {
            seuraavaSiirto = Siirto.PETOS;
        } else {
            seuraavaSiirto = Siirto.YHTEISTYO;
        }
    }

}
