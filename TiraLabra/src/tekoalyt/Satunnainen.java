/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tekoalyt;

import tiralabra.Siirto;

/**
 * Tekoäly, joka valitsee satunnaisen siirron.
 *
 * @author lvapaaka
 */
public class Satunnainen extends AI {

    public Satunnainen() {
        super("Satunnainen", Siirto.YHTEISTYO);
    }

    @Override
    public void maaritaSeuraavaSiirto(Siirto siirto) {
        seuraavaSiirto = satunnainenSiirto();
//        System.out.println("Siirto = " + seuraavaSiirto);
    }

    /**
     * 
     * @return 
     */
    private Siirto satunnainenSiirto() {
        if (Math.random() >= 0.5) {
            return Siirto.YHTEISTYO;
        } else {
            return Siirto.PETOS;
        }
    }

    @Override
    public void palautaEnsimmainenSiirto() {
    }
}
