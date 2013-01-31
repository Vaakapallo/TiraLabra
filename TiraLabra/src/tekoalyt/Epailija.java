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
     * @param siirto 
     */
    @Override
    public void vastaanotaSiirto(Siirto siirto) {
        if (siirto == Siirto.YHTEISTYO) {
            seuraavaSiirto = Siirto.YHTEISTYO;
        }
    }

    @Override
    public void palautaAlkuperainenTila() {
        seuraavaSiirto = Siirto.PETOS;
    }
}
