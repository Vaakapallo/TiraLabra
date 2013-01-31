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
        log.lisaaTekoaly(new Kokeilija());
        log.lisaaTekoaly(new Pahis());
//        log.lisaaTekoaly(new Satunnainen());
        log.lisaaTekoaly(new Matkija());
        log.lisaaTekoaly(new Kostaja());
        log.lisaaTekoaly(new Kuvio());
        log.lisaaTekoaly(new Epailija());
        log.lisaaTekoaly(new Laskija(-5));
        log.lisaaTekoaly(new Laskija(0));
        log.lisaaTekoaly(new Laskija(5));
        log.lisaaTekoaly(new Laskija(10));
//        log.peluutaKaikkia();


        MinimiKeko keko = new MinimiKeko();
        keko.lisaaKekoon(3);
        keko.lisaaKekoon(5);
        keko.lisaaKekoon(8);
        keko.lisaaKekoon(10);
        System.out.println(keko.printtaaKeko());
        System.out.println("pienin: " + keko.poistaPieninKeosta());
        System.out.println(keko.printtaaKeko());
        keko.lisaaKekoon(15);
        keko.lisaaKekoon(20);
        System.out.println(keko.printtaaKeko());

    }
}
