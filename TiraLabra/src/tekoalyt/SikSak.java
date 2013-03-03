/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tekoalyt;

import logiikka.Siirto;

/**
 * Vuorotellen pettävä ja yhteistyötä tekevä teko"äly".
 *
 * @author lvapaaka
 */
public class SikSak extends AI {

    public SikSak() {
        super("Sik sak", Siirto.YHTEISTYO);
    }

    /**
     * Koska tekoäly ei tee mitään vastaanotetulla siirrolla, kutsutaan vain apumetodia.
     * 
     * @param vastustajanSiirto 
     */
    @Override
    public void vastaanotaSiirto(Siirto vastustajanSiirto) {
        sikVaiSak();
    }

    /**
     * Jos viime siirto oli yhteistyö, seuraava on petos.
     * 
     * Ja toisinpäin.
     */
    private void sikVaiSak() {
        if (seuraavaSiirto == Siirto.YHTEISTYO) {
            seuraavaSiirto = Siirto.PETOS;
        } else {
            seuraavaSiirto = Siirto.YHTEISTYO;
        }
    }

    @Override
    public void palautaAlkuperainenTila() {
        seuraavaSiirto = Siirto.YHTEISTYO;
    }

    @Override
    public String toString() {
        return "Siksakin pisteet: " + super.getPisteet();
    }
}
