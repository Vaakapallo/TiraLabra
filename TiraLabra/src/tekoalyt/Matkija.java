/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tekoalyt;

import tiralabra.Siirto;

/**
 * Tekoäly, joka ensimmäisenä siirtona yhteistyötä, sitten vain kopioi toisen pelaajan siirron.
 * 
 * @author lvapaaka
 */
public class Matkija extends AI {

    public Matkija() {
        super("Matkija", Siirto.YHTEISTYO);
    }

    /**
     * Vastaanottaa siirron ja säätää sen tekoälyn seuraavaksi siirroksi.
     * @param vastustajanSiirto Toisen pelaajan viime kierroksen siirto
     */
    @Override
    public void vastaanotaSiirto(Siirto vastustajanSiirto) {
        seuraavaSiirto = vastustajanSiirto;
    }

    @Override
    public void palautaAlkuperainenTila() {
        seuraavaSiirto = Siirto.YHTEISTYO;
    }
}
