/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tekoalyt;

import tiralabra.Siirto;

/**
 * Teko"äly", joka pettää aina.
 * 
 * @author lvapaaka
 */
public class Pahis extends AI {

    public Pahis() {
        super("Pahis", Siirto.PETOS);
    }

    @Override
    public void vastaanotaSiirto(Siirto siirto) {
    }

    @Override
    public void palautaAlkuperainenTila() {
    }
    
    @Override
    public String toString() {
        return "Pahiksen pisteet: " + super.getPisteet();
    }
}
