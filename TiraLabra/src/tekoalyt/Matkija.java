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
        super("Matkija (Tit for Tat)", Siirto.YHTEISTYO);
    }

    @Override
    public void maaritaSeuraavaSiirto(Siirto siirto) {
        seuraavaSiirto = siirto;
    }

    @Override
    public void palautaEnsimmainenSiirto() {
        seuraavaSiirto = Siirto.YHTEISTYO;
    }
}
