/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

import tekoalyt.*;

/**
 *
 * @author lvapaaka
 */
public class TiraLabra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Logiikka log = new Logiikka();
        log.lisaaTekoaly(new Laskija(-5));
        log.lisaaTekoaly(new Laskija(1));
        log.lisaaTekoaly(new Laskija(-10));
        log.lisaaTekoaly(new Laskija(5));
        log.lisaaTekoaly(new Kostaja());
        log.lisaaTekoaly(new Hyvis());
        log.lisaaTekoaly(new Matkija());
        log.lisaaTekoaly(new Kokeilija());
        log.lisaaTekoaly(new Pahis());
        log.lisaaTekoaly(new Satunnainen());
        log.lisaaTekoaly(new Opportunisti());
        log.lisaaTekoaly(new Laskija(10));
        log.lisaaTekoaly(new Laskija(15));
        log.lisaaTekoaly(new Laskija(0));
        log.lisaaTekoaly(new Laskija(8));
        log.lisaaTekoaly(new Epailija());
        log.lisaaTekoaly(new SikSak());
//        log.lisaaTekoaly(new Ihminen());
        log.peluutaKaikkia(100);

//        Ihminen ihminen = new Ihminen();
//        log.pelaaKierroksia(5, ihminen, new Matkija());
//        log.pelaaKierroksia(5, ihminen, new Hyvis());
    }
}
