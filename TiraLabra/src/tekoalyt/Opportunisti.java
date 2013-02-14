/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tekoalyt;

import tiralabra.Siirto;

/**
 * Tekoäly, joka laskee kierroksia ja tekee päätöksiä sen ja kunkin kierroksen
 * pistemäärän perusteella.
 *
 * @author lvapaaka
 */
public class Opportunisti extends AI {

    private int pisteetKierroksenAlussa;
    private int siirtojaNyt = 1;
    /**
     * Muuttuja, johon lasketaan siirtojen määrä per kierros.
     *
     * Alussa 100000, koska siirtojen määrää ei voi tietää ennalta.
     */
    private int siirtojaKierroksessa = 100000;

    public Opportunisti() {
        super("Opportunisti", Siirto.YHTEISTYO);
        pisteetKierroksenAlussa = super.getPisteet();
    }

    @Override
    public void vastaanotaSiirto(Siirto siirto) {
        seuraavaSiirto = paataSiirto(siirto);
        siirtojaNyt++;
    }

    @Override
    public void palautaAlkuperainenTila() {
        siirtojaKierroksessa = siirtojaNyt;
        siirtojaNyt = 0;
        pisteetKierroksenAlussa = super.getPisteet();
        seuraavaSiirto = Siirto.YHTEISTYO;
    }

    /**
     * Opportunistin siirron päättävä metodi.
     * 
     * Yhteistyön tapauksessa tehdään yhteistyötä, paitsi viimeisellä kierroksella,
     * jolloin petetään aina.
     * 
     * Jos ei vielä ole saatu paljon miinuspisteitä, tehdään yhteistyötä. Jos pistemäärä
     * ylittää odotusarvon (molemmat tekevät yhteistyötä joka siirrolla), petetään.
     * 
     * @param siirto Vastustajan siirto
     * @return Opportunistin oma siirto
     */
    private Siirto paataSiirto(Siirto siirto) {
        if (siirto == Siirto.YHTEISTYO) {
            if (siirtojaNyt == siirtojaKierroksessa - 1) {
                return Siirto.PETOS;
            }
            return Siirto.YHTEISTYO;
        } else if (super.getPisteet() - pisteetKierroksenAlussa < siirtojaKierroksessa) {
            return Siirto.YHTEISTYO;
        } else {
            return Siirto.PETOS;
        }
    }
}
