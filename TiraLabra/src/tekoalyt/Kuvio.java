/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tekoalyt;

import logiikka.Siirto;

/**
 * Tekoäly joka pelaa tasaista kuviota.
 *
 * @author lvapaaka
 */
public class Kuvio extends AI {

    /**
     * Kuvion suorittamista avittava laskuri.
     */
    private int laskuri;

    public Kuvio() {
        super("Kuvio", Siirto.YHTEISTYO);
        laskuri = 1;
    }

    /**
     * Maarittaa siirtokuvion tämänhetkisen kohdan.
     * @param vastustajanSiirto 
     */
    @Override
    public void vastaanotaSiirto(Siirto vastustajanSiirto) {
        laskuri++;
        if (laskuri % 3 == 0) {
            seuraavaSiirto = Siirto.PETOS;
        } else {
            seuraavaSiirto = Siirto.YHTEISTYO;
        }
    }

    @Override
    public void palautaAlkuperainenTila() {
        seuraavaSiirto = Siirto.YHTEISTYO;
        laskuri = 1;
    }
}
