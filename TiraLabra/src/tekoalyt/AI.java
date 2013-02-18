/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tekoalyt;

import logiikka.Siirto;

/**
 * Kaikkien tekoälyjen pohjana toimiva abstrakti luokka.
 *
 * @author lvapaaka
 */
public abstract class AI implements Comparable<AI> {

    /**
     * Tekoälyn seuraavaksi säädetty siirto.
     */
    protected Siirto seuraavaSiirto;
    /**
     * Tekoälyn omaamat pisteet.
     */
    private int pisteet;
    /**
     * Tekoälyn nimi, jota käytetään printtauksessa.
     */
    private String nimi;

    /**
     * Tekoälyn konstruktori.
     *
     * Asettaa nimen ja ensimmäisen siirron.
     *
     * @param nimi Tekoälyn nimi
     * @param siirto Tekoälyn ensimmäinen siirto
     */
    public AI(String nimi, Siirto siirto) {
        this.nimi = nimi;
        this.seuraavaSiirto = siirto;
        pisteet = 0;
    }

    /**
     * Tekoälyn seuraavan siirron palauttava metodi.
     *
     * @return Seuraava siirto
     */
    public Siirto teeSiirto() {
        return seuraavaSiirto;
    }

    /**
     * Pisteitä lisäävä metodi.
     *
     * @param pisteet Lisättävä pistemäärä
     */
    public void lisaaPisteita(int pisteet) {
        this.pisteet += pisteet;
    }

    public int getPisteet() {
        return pisteet;
    }

    public String getNimi() {
        return nimi;
    }

    /**
     * Vertailumetodi, joka järjestää pienimmästä isoimpaan.
     *
     * @param o toinen AI
     * @return
     */
    @Override
    public int compareTo(AI o) {
        return this.pisteet - o.getPisteet();
    }

    @Override
    public String toString() {
        return nimi + "n pisteet: " + pisteet;
    }

    /**
     * Tekoälyjen perustoiminto, seuraavan siirron määritys vastapuolen
     * edellisen siirron perusteella.
     *
     * @param vastustajanSiirto Toisen pelaajan viime kierroksen siirto
     */
    public abstract void vastaanotaSiirto(Siirto vastustajanSiirto);

    /**
     * Palauttaa tekoälyn alkuperäiseen tilanteeseen.
     */
    public abstract void palautaAlkuperainenTila();
}
