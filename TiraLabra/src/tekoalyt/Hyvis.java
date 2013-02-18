/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tekoalyt;

import logiikka.Siirto;

/**
 * Teko"äly", joka tekee aina yhteistyötä.
 *
 * @author lvapaaka
 */
public class Hyvis extends AI {

    public Hyvis() {
        super("Hyvis", Siirto.YHTEISTYO);
    }

    @Override
    public void vastaanotaSiirto(Siirto vastustajanSiirto) {
    }

    @Override
    public void palautaAlkuperainenTila() {
    }

    @Override
    public String toString() {
        return "Hyviksen pisteet: " + super.getPisteet();
    }
}
