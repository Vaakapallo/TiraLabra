/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

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
        Peluuttaja peluuttaja = new Peluuttaja();
        peluuttaja.lisaaTekoaly(new Laskija(-5));
        peluuttaja.lisaaTekoaly(new Laskija(1));
        peluuttaja.lisaaTekoaly(new Laskija(-10));
        peluuttaja.lisaaTekoaly(new Laskija(5));
        peluuttaja.lisaaTekoaly(new Kostaja());
        peluuttaja.lisaaTekoaly(new Hyvis());
        peluuttaja.lisaaTekoaly(new Matkija());
        peluuttaja.lisaaTekoaly(new Kokeilija());
        peluuttaja.lisaaTekoaly(new Pahis());
        peluuttaja.lisaaTekoaly(new Satunnainen());
        peluuttaja.lisaaTekoaly(new Opportunisti());
        peluuttaja.lisaaTekoaly(new Laskija(10));
        peluuttaja.lisaaTekoaly(new Laskija(15));
        peluuttaja.lisaaTekoaly(new Laskija(0));
        peluuttaja.lisaaTekoaly(new Laskija(8));
        peluuttaja.lisaaTekoaly(new Epailija());
        peluuttaja.lisaaTekoaly(new SikSak());
//        log.lisaaTekoaly(new Ihminen());
        peluuttaja.peluutaKaikkia(100);

//        Ihminen ihminen = new Ihminen();
//        AI op = new Opportunisti();
//        log.pelaaKierroksia(5, ihminen, op);
//        log.pelaaKierroksia(5, ihminen, op);
        Valikko valikko = new Valikko();
        
    }
}
