/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tekoalyt;

import java.util.Scanner;
import tiralabra.Siirto;

/**
 *
 * @author lvapaaka
 */
public class Ihminen extends AI {

    private Scanner lukija = new Scanner(System.in);

    public Ihminen() {
        super("Ihminen", null);
        pelaa();
    }

    public void pelaa() {
        System.out.println("Pelataan Vangin Dilemmaa");
        System.out.println("Y:t ovat yhteistyötä");
        System.out.println("P:t ovat petoksia");
        vastaanotaSiirto(null);
    }

    @Override
    public void vastaanotaSiirto(Siirto siirto) {
        if (siirto != null) {
            System.out.println("Vastustajan siirto oli: " + siirto);
            System.out.println("Sinulla on " + super.getPisteet() + " pistettä");
        } else {
            System.out.println("Ensimmäinen kierros!");
        }
        System.out.println("Tee siirto:");
        seuraavaSiirto = lueSiirtoKayttajalta();
        System.out.println("Siirtosi oli " + seuraavaSiirto);
    }

    @Override
    public void palautaAlkuperainenTila() {
        System.out.println("Kierros päättyi!");
    }

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
}
