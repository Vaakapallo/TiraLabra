/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tekoalyt;

import java.util.Random;
import tiralabra.Siirto;

/**
 *
 * @author lvapaaka
 */
public class Satunnainen extends AI {

    public Satunnainen() {
        super("Satunnainen", Siirto.YHTEISTYO);
    }

    @Override
    public void vastaanotaSiirto(Siirto siirto) {
        seuraavaSiirto = satunnainenSiirto();
//        System.out.println("Siirto = " + seuraavaSiirto);
    }

    private Siirto satunnainenSiirto() {
        if (Math.random() >= 0.5) {
            return Siirto.YHTEISTYO;
        } else {
            return Siirto.PETOS;
        }
    }
}
