/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tietorakenteet;

import tekoalyt.AI;

/**
 *
 * @author lvapaaka
 */
public class TekoalyKeko{

    private AI[] keko;
    private int taulukonPituus;
    private int keonKoko;

    public TekoalyKeko(int pituus) {
        taulukonPituus = pituus + 1;
        this.keko = new AI[taulukonPituus];
        keonKoko = 0;
    }

    /**
     * Keon jäsenen vanhemman palauttava metodi
     *
     * @param i keon jäsenen indeksi
     * @return
     */
    public int vanhempi(int i) {
        return i / 2;
    }

    /**
     * Keon jäsenen vasemman lapsen palauttava metodi
     *
     * @param i keon jäsenen indeksi
     * @return
     */
    public int vasen(int i) {
        return 2 * i;
    }

    /**
     * Keon jäsenen oikean lapsen palauttava metodi.
     *
     * @param i
     * @return
     */
    public int oikea(int i) {
        return 2 * i + 1;
    }

    /**
     * Toiselta nimeltään heapify, kekoa ylläpitävä metodi.
     *
     * @param i
     */
    public void keoista(int i) {
        int vasen = vasen(i);
        int oikea = oikea(i);
        int pienin;
        if (oikea <= keonKoko) {
            if (keko[vasen].getPisteet() < keko[oikea].getPisteet()) {
                pienin = vasen;
            } else {
                pienin = oikea;
            }
            if (keko[i].getPisteet() > keko[pienin].getPisteet()) {
                vaihda(i, pienin);
                keoista(pienin);
            }
        } else if (vasen == keonKoko && keko[i].getPisteet() > keko[vasen].getPisteet()) {
            vaihda(i, vasen);
        }
    }

    /**
     * Keon pienimmän arvon palauttava metodi.
     *
     * @return
     */
    public int minimi() {
        return keko[1].getPisteet();
    }

    /**
     * Kekoon oikealle paikalleen tekoälyn lisäävä metodi.
     *
     * @param k lisättävä tekoäly
     */
    public void lisaaKekoon(AI k) {
        keonKoko++;
        int i = keonKoko;
        while (i > 1 && keko[vanhempi(i)].getPisteet() > k.getPisteet()) {
            keko[i] = keko[vanhempi(i)];
            i = vanhempi(i);
        }
        keko[i] = k;
    }

    /**
     * Keon pienimmän pistemäärän omaavan tekoälyn poistava ja palauttava metodi,
     *
     * @return
     */
    public AI poistaPieninKeosta() {
        AI min = keko[1];
        keko[1] = keko[keonKoko];
        keonKoko--;
        keoista(1);
        return min;
    }

    /**
     * Kahden keon jäsenen paikkaa vaihtava metodi.
     *
     * @param indeksi1
     * @param indeksi2
     */
    public void vaihda(int indeksi1, int indeksi2) {
        AI apu = keko[indeksi1];
        keko[indeksi1] = keko[indeksi2];
        keko[indeksi2] = apu;
    }

    /**
     * Keon karkeasti tulostava metodi.
     *
     * @return
     */
    public String printtaaKeko() {
        String palautettava = "";
        for (int i = 1; i < keko.length; i++) {
            palautettava += keko[i] + "\n";
        }
        return palautettava;
    }

    public int palautaTekoalynPisteetIndeksista(int i) {
        return keko[i].getPisteet();
    }

    public int getKeonKoko() {
        return keonKoko;
    }

    public void pienennaKekoa() {
        keonKoko--;
    }

    public AI[] getKeko() {
        return keko;
    }
}
