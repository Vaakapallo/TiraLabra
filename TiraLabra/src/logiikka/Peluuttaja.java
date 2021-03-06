/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import tietorakenteet.Jarjestaja;
import java.util.Collections;
import tekoalyt.AI;

/**
 * Tekoälyt kasaava ja niitä keskenään peluuttava luokka.
 *
 * @author lvapaaka
 */
public class Peluuttaja {

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
     * Muuttuja, joka määrittää saako pelaaja tietää, kuka hänellä on vastassa.
     */
    private boolean huijaus = false;

    /**
     * Luokan konstruktori, joka alustaa listan.
     */
    public Peluuttaja() {
        tekoalyt = new AI[100];
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
        for (int i = 0; i < maara - 1; i++) {
            pelaaKierros(eka, toka);
        }
        if (maara > 0) {
            pelaaViimeinenKierros(eka, toka);
        }
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
     * Viimeisen kierroksen peluuttaava metodi, joka ei pyydä enää uutta siirtoa
     * tekoälyiltä.
     *
     * Nollaa myös tekoälyt seuraavaa kierrosta varten.
     *
     * @param eka Ensimmäinen tekoäly
     * @param toka Toinen tekoly
     */
    private void pelaaViimeinenKierros(AI eka, AI toka) {
        Siirto ensimmaisen = eka.teeSiirto();
        Siirto toisen = toka.teeSiirto();
        jaaPisteet(ensimmaisen, toisen, eka, toka);
        eka.palautaAlkuperainenTila();
        toka.palautaAlkuperainenTila();
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
     *
     * Käskee myös järjestämään ja printtaamaan tulokset kierrosten jälkeen.
     */
    public void peluutaKaikkia(int kierroksia) {
        pakkaaTekoalyt();
        for (int i = 0; i < tekoalytIndeksi; i++) {
            for (int j = i + 1; j < tekoalytIndeksi; j++) {
                if (huijaus) {
                    if (tekoalyt[j].getNimi().equalsIgnoreCase("Ihminen")) {
                        System.out.println("Vastustajana: " + tekoalyt[i].getNimi());
                    }
                }
                pelaaKierroksia(kierroksia, tekoalyt[i], tekoalyt[j]);
            }
        }
        jarjestaTulokset();
        printtaaTulokset();
    }

    /**
     * Tulokset tekoälyjen toString:n avulla printtaava metodi.
     */
    private void printtaaTulokset() {
        for (int i = 0; i < tekoalytIndeksi; i++) {
            System.out.println(tekoalyt[i]);
        }
    }

    /**
     * Tekoalyt helposti käsiteltäväksi taulukoksi pakkaava metodi.
     */
    private void pakkaaTekoalyt() {
        AI[] uusiTekoalyt = new AI[tekoalytIndeksi];
        for (int i = 0; i < tekoalytIndeksi; i++) {
            uusiTekoalyt[i] = tekoalyt[i];
        }
        tekoalyt = uusiTekoalyt;
    }

    /**
     * Itse toteutetulla kekojärjestämisellä tekoälyt järjestävä metodi.
     */
    private void jarjestaTulokset() {
        Jarjestaja jarjestaja = new Jarjestaja(tekoalyt);
        tekoalyt = jarjestaja.kekoJarjestaminen();
    }

    /**
     * Pistää huijauksen päälle, eli pelaaja näkee ketä vastaan hän pelaa jokaisella kierroksella.
     */
    public void laitaHuijausPaalle() {
        huijaus = true;
    }
}
