/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tietorakenteet;

import tekoalyt.AI;

/**
 * Heap-sort järjestysalgoritmi.
 *
 * @author lvapaaka
 */
public class Jarjestaja {

    /**
     * Tietorakenne, jonka avulla järjestäminen toimii.
     */
    private TekoalyKeko keko;
    /**
     * Järjestettävät tekoäly taulukkona.
     */
    private AI[] jarjestettava;

    public Jarjestaja(AI[] jarjestettava) {
        keko = new TekoalyKeko(jarjestettava.length);
        this.jarjestettava = jarjestettava;
    }

    /**
     * Keon minimikeon avulla järjestävä metodi.
     *
     * Ei ihan Tiran mukainen, saattaa olla tehoton. Pitää miettiä lisää. Toimii
     * kuitenkin.
     *
     * @return
     */
    public AI[] kekoJarjestaminen() {
        kasaaKeko();
        AI[] jarjestyksessa = new AI[jarjestettava.length];
        for (int i = 0; i < jarjestettava.length; i++) {
            jarjestyksessa[i] = keko.poistaPieninKeosta();
        }
        return jarjestyksessa;
    }

    /**
     * Metodi, joka lisää kekoon kaikki järjestettävän taulukon luvut.
     */
    private void kasaaKeko() {
        for (int i = 0; i < jarjestettava.length; i++) {
            keko.lisaaKekoon(jarjestettava[i]);
        }
    }
}
