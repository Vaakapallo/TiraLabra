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
public class Matkija extends AI {

    public Matkija() {
        super("Matkija (Tit for Tat)", Siirto.YHTEISTYO);
    }

    @Override
    public void vastaanotaSiirto(Siirto siirto) {
        seuraavaSiirto = siirto;
    }
}
