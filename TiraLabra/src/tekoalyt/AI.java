/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tekoalyt;

import tiralabra.Siirto;

/**
 *
 * @author lvapaaka
 */
public abstract class AI implements Comparable<AI> {

    protected Siirto seuraavaSiirto;
    private int pisteet;
    private String nimi;

    public AI(String nimi, Siirto siirto) {
        this.nimi = nimi;
        this.seuraavaSiirto = siirto;
        pisteet = 0;
    }

    public Siirto teeSiirto() {
        return seuraavaSiirto;
    }

    public void muokkaaPisteita(int pisteet) {
        this.pisteet += pisteet;
    }

    public int getPisteet() {
        return pisteet;
    }

    public String getNimi() {
        return nimi;
    }

    @Override
    public int compareTo(AI o) {
        return this.pisteet - o.getPisteet();
    }

    public abstract void vastaanotaSiirto(Siirto siirto);
}
