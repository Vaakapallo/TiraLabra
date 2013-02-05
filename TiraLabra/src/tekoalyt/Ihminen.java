/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tekoalyt;

import java.util.Scanner;
import tekoalyt.AI;
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
        System.out.println("Y on yhteistyö");
        System.out.println("P on petos");
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
        String valinta = lukija.nextLine();
        if (valinta.equals("Y")) {
            seuraavaSiirto = Siirto.YHTEISTYO;
        } else {
            seuraavaSiirto = Siirto.PETOS;
        }
    }

    @Override
    public void palautaAlkuperainenTila() {
    }
}
