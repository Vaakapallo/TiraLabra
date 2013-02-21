/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import java.util.Scanner;
import tekoalyt.*;

/**
 * Keskeneräinen (ja ylimääräinen) Valikko-Luokka
 *
 * @author lvapaaka
 */
public class Valikko {

    private Scanner lukija;
    private Peluuttaja peluuttaja;

    public Valikko() {
        peluuttaja = new Peluuttaja();
        lukija = new Scanner(System.in);
        kysyKayttajalta();
    }

    private void kysyKayttajalta() {
        System.out.println("Määritetään turnauksen säännöt ja osallistujat");
        System.out.println("Kuinka monta siirtoa per kierros? (jos pelaat itse, suositellaan alle 20)");
        int kierroksia = Integer.parseInt(lukija.nextLine());

        System.out.println("Haluatko valita turnauksen tekoälyt?");
        if (vastasikoKayttajaKylla(lukija.nextLine())) {
            printtaaTekoälytTunnuksineen();
            System.out.println("Valitse tekoälyt: (Tekoälyjä on turnauksessa sen kirjainta vastaava määrä)");
            System.out.println("Anna tekoälysyöte");
            String tekoalyt = lukija.nextLine().toLowerCase();
            parsiTekoalySyote(tekoalyt);
        } else {
            lisaaPerusTekoalyt();
        }
        System.out.println("Haluatko ottaa osaa turnaukseen vai peluuttaa tekoälyjä keskenään? (k jos haluat)");
        if (vastasikoKayttajaKylla(lukija.nextLine())) {
            System.out.println("Olet mukana turnauksessa!");
            peluuttaja.lisaaTekoaly(new Ihminen());
        }

        peluuttaja.peluutaKaikkia(kierroksia);
    }

    private void parsiTekoalySyote(String tekoalyt) {
        String vaihtoehdot = "ehjkumlopsi";
        for (int i = 0; i < vaihtoehdot.length(); i++) {
            lisaaTekoalyja(vaihtoehdot.charAt(i), ApuMetodeita.laskeMerkkienMaara(vaihtoehdot.charAt(i), tekoalyt));
        }
    }

    private boolean vastasikoKayttajaKylla(String syote) {
        return syote.matches("(?i).*K.*") || syote.matches("(?i).*Y.*");
    }

    private Siirto lueSiirtoKayttajalta() {
        while (true) {
            String valinta = lukija.nextLine();
            if (valinta.matches("(?i).*K.*")) {
                return Siirto.YHTEISTYO;
            } else if (valinta.matches("(?i).*P.*")) {
                return Siirto.PETOS;
            } else {
                System.out.println("Epäkelpo siirto, yritä uudelleen:");
            }
        }
    }

    private void lisaaTekoalyja(char tunnus, int lisattavienTekoalyjenMaara) {
        if (lisattavienTekoalyjenMaara == 0) {
            return;
        }
        for (int i = 0; i < lisattavienTekoalyjenMaara; i++) {
            switch (tunnus) {
                case 'e':
                    peluuttaja.lisaaTekoaly(new Epailija());
                    break;
                case 'h':
                    peluuttaja.lisaaTekoaly(new Hyvis());
                    break;
                case 'j':
                    peluuttaja.lisaaTekoaly(new Kokeilija());
                    break;
                case 'k':
                    peluuttaja.lisaaTekoaly(new Kostaja());
                    break;
                case 'u':
                    peluuttaja.lisaaTekoaly(new Kuvio());
                    break;
                case 'm':
                    peluuttaja.lisaaTekoaly(new Matkija());
                    break;
                case 'l':
                    System.out.println("Anna laskijalle kiltteysaste");
                    int kiltteysAste = Integer.parseInt(lukija.nextLine());
                    peluuttaja.lisaaTekoaly(new Laskija(kiltteysAste));
                    break;
                case 'o':
                    peluuttaja.lisaaTekoaly(new Opportunisti());
                    break;
                case 'p':
                    peluuttaja.lisaaTekoaly(new Pahis());
                    break;
                case 's':
                    peluuttaja.lisaaTekoaly(new Satunnainen());
                    break;
                case 'i':
                    peluuttaja.lisaaTekoaly(new SikSak());
                    break;
            }
        }
    }

    private void printtaaTekoälytTunnuksineen() {
        System.out.println("Tekoälyt:");
        System.out.println("(E)pailija");
        System.out.println("(H)yvis");
        System.out.println("Kokeili(j)a");
        System.out.println("(K)ostaja");
        System.out.println("K(u)vio");
        System.out.println("(L)askija");
        System.out.println("(M)atkija");
        System.out.println("(O)pportunisti");
        System.out.println("(P)ahis");
        System.out.println("(S)atunnainen");
        System.out.println("S(i)kSak");
    }

    private void lisaaPerusTekoalyt() {
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
    }
}
