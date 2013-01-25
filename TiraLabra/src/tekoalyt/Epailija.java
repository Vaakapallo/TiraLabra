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

    @Override
    public void maaritaSeuraavaSiirto(Siirto siirto) {
        if (siirto == Siirto.YHTEISTYO) {
            seuraavaSiirto = Siirto.YHTEISTYO;
        }
    }

    @Override
    public void palautaEnsimmainenSiirto() {
        seuraavaSiirto = Siirto.PETOS;
    }
}
