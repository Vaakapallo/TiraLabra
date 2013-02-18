/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tekoalyt;

import logiikka.Siirto;

/**
 * Tekoäly, joka tekee siirron sen laskurin arvon perusteella.
 *
 * Jos laskuri on positiivinen se tekee yhteistyötä, muulloin se pettää.
 * Laskurin arvoon vaikuttaa toisen tekoälyn siirrot.
 *
 * @author lvapaaka
 */
public class Laskija extends AI {

    /**
     * Tekoälyn muuttuva, päätöksenteon perustana oleva luku. 
     */
    private int hyvyysPisteet;
    /**
     * Tallennettu alkuperäinen kiltteysarvo, tekoälyn nollaamiseen kierrosten välillä.
     */
    private int alkuperainenKiltteys;

    public Laskija(int kiltteysAste) {
        super("Laskija (Kiltteys " + kiltteysAste + ")", Siirto.YHTEISTYO);
        hyvyysPisteet = kiltteysAste;
        alkuperainenKiltteys = kiltteysAste;
    }

    /**
     * Tekoälyn "hyvyyspisteitä" säätävä metodi.
     * @param vastustajanSiirto Vastustajan viime kierroksen siirto
     */
    @Override
    public void vastaanotaSiirto(Siirto vastustajanSiirto) {
        if (vastustajanSiirto == Siirto.PETOS) {
            hyvyysPisteet--;
        } else {
            hyvyysPisteet++;
        }
        seuraavaSiirto = maaritaSiirtoPisteista();
    }

    @Override
    public void palautaAlkuperainenTila() {
        seuraavaSiirto = Siirto.YHTEISTYO;
        hyvyysPisteet = alkuperainenKiltteys;
    }

    /**
     * Hyvin yksinkertaisesti "hyvyyspisteet" siirroksi tulkitseva metodi.
     * @return tehtävä Siirto
     */
    private Siirto maaritaSiirtoPisteista() {
        if (hyvyysPisteet >= 0) {
            return Siirto.YHTEISTYO;
        } else {
            return Siirto.PETOS;
        }
    }
    
    @Override
    public String toString() {
        return "Laskija (Kiltteys " + alkuperainenKiltteys + "):n pisteet: " + super.getPisteet();
    }
}
