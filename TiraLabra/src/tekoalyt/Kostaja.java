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
public class Kostaja extends AI {

    public Kostaja() {
        super("Kostaja", Siirto.YHTEISTYO);
    }

    @Override
    public void vastaanotaSiirto(Siirto siirto) {
        if (siirto == Siirto.PETOS) {
            seuraavaSiirto = Siirto.PETOS;
        }
    }
}
