/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import java.util.Scanner;
import tekoalyt.*;

/**
 * (Ylimääräinen) Turnauksen valintoja säätävä luokka.
 *
 * @author lvapaaka
 */
public class Valikko {

    private Scanner lukija;
    /**
     * Peluuttaja tekoälyjen lisäämistä varten.
     */
    private Peluuttaja peluuttaja;

    public Valikko() {
        peluuttaja = new Peluuttaja();
        lukija = new Scanner(System.in);
        turnauksenSaadot();
    }

    /**
     * Turnauksen valinnat kyselevä metodi.
     */
    private void turnauksenSaadot() {
        System.out.println("Määritetään turnauksen säännöt ja osallistujat");
        System.out.println("Kuinka monta siirtoa per kierros? (jos haluat itse osallistua, suositellaan alle 20)");
        int kierroksia = Integer.parseInt(lukija.nextLine());

        tekoalyValinta();

        if (kierroksia < 50) {
            System.out.println("Haluatko itse ottaa osaa turnaukseen? (k tai y jos haluat)");
            if (kysyKayttajanMyontymysta()) {
                System.out.println("Haluatko huijata turnauksessa? Eli nähdä vastustajan nimen aina kierroksen alussa (k tai y jos haluat)");
                if (kysyKayttajanMyontymysta()) {
                    peluuttaja.laitaHuijausPaalle();
                }
                System.out.println("Onnea turnaukseen!");
                peluuttaja.lisaaTekoaly(new Ihminen());
            }
        }
        peluuttaja.peluutaKaikkia(kierroksia);
    }

    /**
     * Joko pelaajan toimesta tai vakioasetuksilla turnauksen tekoalyt määrittävä metodi.
     */
    private void tekoalyValinta() {
        System.out.println("Haluatko valita turnauksen tekoälyt? (k tai y jos haluat)");
        if (kysyKayttajanMyontymysta()) {
            printtaaTekoälytTunnuksineen();
            System.out.println("Valitse tekoälyt: (Tekoälyjä lisätään turnaukseen sen kirjainta vastaava määrä)");
            System.out.println("Anna tekoälysyöte");
            String tekoalyt = lukija.nextLine().toLowerCase();
            parsiTekoalySyote(tekoalyt);
        } else {
            lisaaPerusTekoalyt();
        }
    }

    /**
     * Kyllä/ei kysymyksiä teettävä metodi.
     * 
     * Jos käyttäjän syötteessä on k tai y, niin vastaus tulkitaan myönteiseksi.
     * 
     * @return Myöntyikö käyttäjä.
     */
    private boolean kysyKayttajanMyontymysta() {
        String syote = lukija.nextLine();
        return syote.matches("(?i).*K.*") || syote.matches("(?i).*Y.*");
    }

    /**
     * Jokaista tekoälyä vastaavan merkin käyttäjälle ilmoittava metodi.
     */
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

    /**
     * Muuttaa merkkijonon lisäyskäskyiksi lisaaTekoalyja-metodille.
     * 
     * Jokainen tekoälyä vastaava merkki tarkoittaa yhden senkaltaisen tekoälyn
     * lisäämistä turnaukseen.
     * 
     * Esim:
     * Jos syöte on "kkkool", niin lisätään turnaukseen:
     * 3 Kostajaa
     * 2 Opportunistia
     * 1 Laskija
     * 
     * Tietyn merkin määrä merkkijonossa lasketaan laskeMerkinMaaraMerkkijonossa-metodin avulla.
     * 
     * @param tekoalyt syöte, jonka perusteella tekoälyt määritetään. 
     */
    private void parsiTekoalySyote(String tekoalyt) {
        String vaihtoehdot = "ehjkumlopsi";
        for (int i = 0; i < vaihtoehdot.length(); i++) {
            lisaaTekoalyja(vaihtoehdot.charAt(i), ApuMetodeita.laskeMerkinMaaraMerkkijonossa(vaihtoehdot.charAt(i), tekoalyt));
        }
    }

    /**
     * Tekoälyt lisäävä metodi.
     * 
     * @param tunnus Lisättävän tekoälyn tunnus
     * @param lisattavienTekoalyjenMaara kuinka monta kertaa merkki esiintyi syötteessä 
     */
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

    /**
     * Tekoälyturnauksen vakiotekoälyt lisäävä metodi.
     */
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
