/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tekoalyt;

import java.util.Scanner;
import logiikka.Siirto;

/**
 * "Tekoäly", joka on täysin ihmisen ohjaama.
 *
 * @author lvapaaka
 */
public class Ihminen extends AI {

    private Scanner lukija = new Scanner(System.in);

    public Ihminen() {
        super("Ihminen", null);
        pelaa();
    }

    /**
     * Pelaajan ohjeet.
     */
    public void pelaa() {
        System.out.println("Pelataan Vangin Dilemmaa");
        System.out.println("Y:t ovat yhteistyötä");
        System.out.println("P:t ovat petoksia");
        System.out.println("Tee ensimmäinen siirto");
        seuraavaSiirto = lueSiirtoKayttajalta();
    }

    /**
     * Viime kierroksen tuloksen ilmoittava ja seuraavan siirron kysyvä metodi.
     *
     * @param vastustajanSiirto
     */
    @Override
    public void vastaanotaSiirto(Siirto vastustajanSiirto) {
        System.out.println("Siirtosi oli " + seuraavaSiirto);
        System.out.println("Vastustajan siirto oli: " + vastustajanSiirto);
        System.out.println("Sinulla on " + super.getPisteet() + " pistettä");
        System.out.println("Tee siirto:");
        seuraavaSiirto = lueSiirtoKayttajalta();
    }

    /**
     * Ilmoitetaan pelaajan tämänhetkinen pistetilanne ja kysytään ensimmäinen
     * siirto seuraavalle kierrokselle.
     */
    @Override
    public void palautaAlkuperainenTila() {
        System.out.println("Kierros päättyi!");
        System.out.println("Pisteitä nyt: " + super.getPisteet());
        System.out.println("Päätä ensi kierroksen ensimmäinen siirto:");
        seuraavaSiirto = lueSiirtoKayttajalta();
    }

    /**
     * Käyttäjän syötteestä siirron tulkitseva metodi.
     *
     * Jos syötteessä on edes yksi "Y" tai "y", niin se tulkitaan yhteistyöksi.
     * Yksikin "P" tai "p" tulkitaan petokseksi. Tasatilanteessa yhteistyö
     * voittaa.
     *
     * @return
     */
    private Siirto lueSiirtoKayttajalta() {
        while (true) {
            String valinta = lukija.nextLine();
            if (valinta.matches("(?i).*Y.*")) {
                return Siirto.YHTEISTYO;
            } else if (valinta.matches("(?i).*P.*")) {
                return Siirto.PETOS;
            } else {
                System.out.println("Epäkelpo siirto, yritä uudelleen:");
            }
        }
    }

    @Override
    public String toString() {
        return "Ihmisen pisteet: " + super.getPisteet();
    }
}
