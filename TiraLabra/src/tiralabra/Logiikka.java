/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import tekoalyt.AI;

/**
 * Tekoälyt kasaava ja niitä keskenään peluuttava luokka.
 *
 * @author lvapaaka
 */
public class Logiikka {

    /**
     * Tekoalyt sisältävä lista.
     */
    private AI[] tekoalyt;
    private int tekoalytIndeksi;
    /**
     * Jaettava palkinto molempien pelaajien yhteistyöstä.
     */
    private final int yhteistyonPalkinto = 1;
    /**
     * Rangaistus yhteistyötä tehneelle pelaajalle, kun toinen petti.
     */
    private final int tyhmyrinRangaistus = 10;
    /**
     * Rangaistus pelaajille jos molemmat pettivät.
     */
    private final int pettureidenKompromissi = 5;

    /**
     * Luokan konstruktori, joka alustaa listan.
     */
    public Logiikka() {
        tekoalyt = new AI[13];
        tekoalytIndeksi = 0;
    }

    /**
     * Listaan tekoälyjä lisäävä metodi.
     *
     * @param ai Lisättävä tekoäly
     */
    public void lisaaTekoaly(AI ai) {
        tekoalyt[tekoalytIndeksi] = ai;
        tekoalytIndeksi++;
    }

    /**
     * Metodi, joka peluuttaa annetun määrän kierroksia.
     *
     * @param maara Kierrosten määrä
     * @param eka Ensimmäinen tekoäly
     * @param toka Toinen tekoäly
     */
    public void pelaaKierroksia(int maara, AI eka, AI toka) {
        for (int i = 0; i < maara; i++) {
            pelaaKierros(eka, toka);
        }
        eka.palautaAlkuperainenTila();
        toka.palautaAlkuperainenTila();
    }

    /**
     * Yhden kierroksen toteuttava metodi.
     *
     * @param eka Ensimmäinen tekoäly
     * @param toka Toinen tekoäly
     */
    public void pelaaKierros(AI eka, AI toka) {
        Siirto ensimmaisen = eka.teeSiirto();
        Siirto toisen = toka.teeSiirto();
        jaaPisteet(ensimmaisen, toisen, eka, toka);
        eka.vastaanotaSiirto(toisen);
        toka.vastaanotaSiirto(ensimmaisen);
    }

    /**
     * Kierroksen pisteet jakava metodi.
     *
     * @param ensimmaisen Ensimmäisen tekoälyn siirto
     * @param toisen Toisen tekoälyn siirto
     * @param eka Ensimmäinen tekoäly
     * @param toka Toinen tekoäly
     */
    private void jaaPisteet(Siirto ensimmaisen, Siirto toisen, AI eka, AI toka) {
        if (ensimmaisen == Siirto.YHTEISTYO && toisen == Siirto.YHTEISTYO) {
            eka.lisaaPisteita(yhteistyonPalkinto);
            toka.lisaaPisteita(yhteistyonPalkinto);
        } else if (ensimmaisen == Siirto.YHTEISTYO && toisen == Siirto.PETOS) {
            eka.lisaaPisteita(tyhmyrinRangaistus);
        } else if (ensimmaisen == Siirto.PETOS && toisen == Siirto.YHTEISTYO) {
            toka.lisaaPisteita(tyhmyrinRangaistus);
        } else {
            eka.lisaaPisteita(pettureidenKompromissi);
            toka.lisaaPisteita(pettureidenKompromissi);
        }
    }

    /**
     * Jokaisen listan tekoälyn toisiaan vastaan peluuttava metodi.
     */
    public void peluutaKaikkia() {
        for (int i = 0; i < tekoalytIndeksi; i++) {
            for (int j = i + 1; j < tekoalytIndeksi; j++) {
                pelaaKierroksia(100, tekoalyt[i], tekoalyt[j]);
            }
        }
        Jarjestaja jarjestaja = new Jarjestaja(tekoalyt);
        tekoalyt = jarjestaja.kekoJarjestaminen();
        printtaaTulokset();
    }

    /**
     * Tulokset järjestävä ja printtaava metodi.
     */
    private void printtaaTulokset() {
        for (int i = 0; i < tekoalytIndeksi; i++) {
            System.out.println(tekoalyt[i].getNimi() + ":n pisteet = " + tekoalyt[i].getPisteet());
        }
    }
}
