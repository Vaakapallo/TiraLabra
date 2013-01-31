/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tekoalyt;

import tiralabra.Siirto;

/**
 * Tekoäly, joka tekee yhteistyötä kunnes toinen pettää.
 * 
 * Tämän jälkeen se pettää ikuisesti.
 * 
 * @author lvapaaka
 */
public class Kostaja extends AI {

    public Kostaja() {
        super("Kostaja", Siirto.YHTEISTYO);
    }

    /**
     * Jos tekoäly petetään, se pettää loppukierroksen.
     * @param siirto 
     */
    @Override
    public void vastaanotaSiirto(Siirto siirto) {
        if (siirto == Siirto.PETOS) {
            seuraavaSiirto = Siirto.PETOS;
        }
    }

    @Override
    public void palautaAlkuperainenTila() {
        seuraavaSiirto = Siirto.YHTEISTYO;
    }
}
