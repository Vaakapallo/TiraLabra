/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

/**
 *
 * @author lvapaaka
 */
public class ApuMetodeita {

    /**
     * Valikon avuksi tehty metodi, joka laskee tietyn merkin määrän merkkijonossa.
     * 
     * @param merkki laskettava merkki
     * @param kohde merkkijono josta lasketaan
     * @return merkkien määrä merkkijonossa
     */
    public static int laskeMerkinMaaraMerkkijonossa(char merkki, String kohde) {
        int montako = 0;
        kohde = kohde.toLowerCase();
        for (int i = 0; i < kohde.length(); i++) {
            if (kohde.charAt(i) == merkki) {
                montako++;
            }
        }
        return montako;
    }
}
