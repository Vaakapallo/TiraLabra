/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tekoalyt;

import logiikka.Siirto;

/**
 * Tekoäly, joka valitsee satunnaisen siirron.
 *
 * @author lvapaaka
 */
public class Satunnainen extends AI {

    public Satunnainen() {
        super("Satunnainen", Siirto.YHTEISTYO);
        seuraavaSiirto = satunnainenSiirto();
    }

    @Override
    public void vastaanotaSiirto(Siirto vastustajanSiirto) {
        seuraavaSiirto = satunnainenSiirto();
//        System.out.println("Siirto = " + seuraavaSiirto);
    }

    /**
     * Satunnaisen siirron arpova metodi.
     *
     * @return seuraava siirto.
     */
    private Siirto satunnainenSiirto() {
        if (Math.random() >= 0.5) {
            return Siirto.YHTEISTYO;
        } else {
            return Siirto.PETOS;
        }
    }

    @Override
    public void palautaAlkuperainenTila() {
    }
    
    @Override
    public String toString() {
        return "Satunnaisen pisteet: " + super.getPisteet();
    }
}
