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
        log.lisaaTekoaly(new Hyvis());
        log.lisaaTekoaly(new Pahis());
        log.lisaaTekoaly(new Satunnainen());
        log.lisaaTekoaly(new Matkija());
        log.lisaaTekoaly(new Kostaja());
        log.lisaaTekoaly(new Kuvio());
        log.lisaaTekoaly(new Epailija());
        log.peluutaKaikkia();
    }
}