/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tekoalyt;

import tiralabra.Siirto;

/**
 * Teko"äly", joka tekee aina yhteistyötä.
 * @author lvapaaka
 */
public class Hyvis extends AI {

    public Hyvis() {
        super("Hyvis", Siirto.YHTEISTYO);
    }

    @Override
    public void maaritaSeuraavaSiirto(Siirto siirto) {
    }

    @Override
    public void palautaEnsimmainenSiirto() {
    }
}
