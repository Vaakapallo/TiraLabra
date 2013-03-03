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
     * Koska tekoäly ei käytä toisen siirtoa mihinkään, ohjataan vain
     * apumetodiin.
     *
     * @param vastustajanSiirto
     */
    @Override
    public void vastaanotaSiirto(Siirto vastustajanSiirto) {
        teeKuvionMukainenSiirto();
    }

    @Override
    public void palautaAlkuperainenTila() {
        seuraavaSiirto = Siirto.YHTEISTYO;
        laskuri = 1;
    }

    /**
     * Kuviota noudattaen seuraavan siirron määrittävä metodi.
     */
    private void teeKuvionMukainenSiirto() {
        laskuri++;
        if (laskuri % 3 == 0) {
            seuraavaSiirto = Siirto.PETOS;
        } else {
            seuraavaSiirto = Siirto.YHTEISTYO;
        }
    }
}
