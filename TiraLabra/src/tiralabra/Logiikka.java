/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tekoalyt.AI;

/**
 *
 * @author lvapaaka
 */
public class Logiikka {

    private List<AI> tekoalyt;
    private final int yhteistyoPalkinto = 1;
    private final int tyhmyrinRangaistus = 10;
    private final int pettureidenKompromissi = 5;

    public Logiikka() {
        tekoalyt = new ArrayList();
    }

    public void lisaaTekoaly(AI ai) {
        tekoalyt.add(ai);
    }

    public void pelaaKierroksia(int maara, AI eka, AI toka) {
        for (int i = 0; i < maara; i++) {
            pelaaKierros(eka, toka);
        }
    }

    public void pelaaKierros(AI eka, AI toka) {
        Siirto ensimmaisen = eka.teeSiirto();
        Siirto toisen = toka.teeSiirto();
        if (ensimmaisen == Siirto.YHTEISTYO && toisen == Siirto.YHTEISTYO) {
            eka.muokkaaPisteita(yhteistyoPalkinto);
            toka.muokkaaPisteita(yhteistyoPalkinto);
        } else if (ensimmaisen == Siirto.YHTEISTYO && toisen == Siirto.PETOS) {
            eka.muokkaaPisteita(tyhmyrinRangaistus);
        } else if (ensimmaisen == Siirto.PETOS && toisen == Siirto.YHTEISTYO) {
            toka.muokkaaPisteita(tyhmyrinRangaistus);
        } else {
            eka.muokkaaPisteita(pettureidenKompromissi);
            toka.muokkaaPisteita(pettureidenKompromissi);
        }
        eka.vastaanotaSiirto(toisen);
        toka.vastaanotaSiirto(ensimmaisen);
    }

    public void peluutaKaikkia() {
        for (AI ai1 : tekoalyt) {
            for (AI ai2 : tekoalyt) {
                pelaaKierroksia(100, ai1, ai2);
            }
        }
        printtaaTulokset();
    }

    private void printtaaTulokset() {
        Collections.sort(tekoalyt);
        for (AI ai : tekoalyt) {
            System.out.println(ai.getNimi() + ":n pisteet = " + ai.getPisteet());
        }
    }
}
