/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tekoalyt;

import tiralabra.Siirto;

/**
 * Tekoäly, joka laskee kierroksia ja tekee päätöksiä sen ja kunkin kierroksen pistemäärän perusteella.
 *
 * @author lvapaaka
 */
public class Opportunisti extends AI {

    private int alkupisteet;
    private int kierroksiaNyt = 1;
    private int kierroksiaYhteensa = 10000;

    public Opportunisti() {
        super("Opportunisti", Siirto.YHTEISTYO);
        alkupisteet = super.getPisteet();
    }

    @Override
    public void vastaanotaSiirto(Siirto siirto) {
        seuraavaSiirto = paataSiirto(siirto);
        kierroksiaNyt++;
    }

    @Override
    public void palautaAlkuperainenTila() {
        kierroksiaYhteensa = kierroksiaNyt;
        kierroksiaNyt = 0;
        alkupisteet = super.getPisteet();
        seuraavaSiirto = Siirto.YHTEISTYO;
    }

    private Siirto paataSiirto(Siirto siirto) {
        if (siirto == Siirto.YHTEISTYO) {
            if (kierroksiaNyt == kierroksiaYhteensa - 1) {
                return Siirto.PETOS;
            }
            return Siirto.YHTEISTYO;
        } else if (super.getPisteet() - alkupisteet < kierroksiaYhteensa) {
            return Siirto.YHTEISTYO;
        } else {
            return Siirto.PETOS;
        }
    }
}
