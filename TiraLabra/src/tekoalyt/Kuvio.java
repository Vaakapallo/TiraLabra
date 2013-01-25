/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tekoalyt;

import tiralabra.Siirto;

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
        laskuri = 0;
    }

    /**
     * Maarittaa kuvion kohdan
     * @param siirto 
     */
    @Override
    public void maaritaSeuraavaSiirto(Siirto siirto) {
        laskuri++;
        if (laskuri % 3 == 0) {
            seuraavaSiirto = Siirto.PETOS;
        } else {
            seuraavaSiirto = Siirto.YHTEISTYO;
        }
    }

    @Override
    public void palautaEnsimmainenSiirto() {
        seuraavaSiirto = Siirto.YHTEISTYO;
        laskuri = 0;
    }
}
