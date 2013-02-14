package tekoalyt;

import tiralabra.Siirto;

/**
 * Tekoäly, joka pettää kunnes toinen pelaaja tekee yhteistyötä.
 * 
 * Tämän jälkeen se tekee aina yhteistyötä
 * @author lvapaaka
 */
public class Epailija extends AI {

    public Epailija() {
        super("Epailija", Siirto.PETOS);
    }

    /**
     * Jos tekoälylle ollaan ystävällinen, se tekee yhteistyötä loppukierroksen.
     * 
     * @param vastustajanSiirto 
     */
    @Override
    public void vastaanotaSiirto(Siirto vastustajanSiirto) {
        if (vastustajanSiirto == Siirto.YHTEISTYO) {
            seuraavaSiirto = Siirto.YHTEISTYO;
        }
    }

    @Override
    public void palautaAlkuperainenTila() {
        seuraavaSiirto = Siirto.PETOS;
    }
}
