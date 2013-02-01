/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

/**
 * Heap-sort järjestysalgoritmi.
 *
 * @author lvapaaka
 */
public class Jarjestaja {

    private MinimiKeko keko;
    private int[] jarjestettava;

    public Jarjestaja(int[] jarjestettava) {
        keko = new MinimiKeko(jarjestettava.length);
        this.jarjestettava = jarjestettava;
    }

    /**
     * Keon minimikeon avulla järjestävä metodi.
     * 
     * Ei ihan Tiran mukainen, saattaa olla tehoton. Toimii kuitenkin.
     * @return 
     */
    public int[] kekoJarjestaminen() {
        kasaaKeko();
        int[] jarjestyksessa = new int[jarjestettava.length];
        for (int i = 0; i < jarjestettava.length; i++) {
            jarjestyksessa[i] = keko.poistaPieninKeosta();
        }
        return jarjestyksessa;
    }

    /**
     * Metodi, joka lisää kekoon kaikki järjestettävän taulukon luvut.
     */
    private void kasaaKeko() {
        for (int i = 0; i < jarjestettava.length; i++) {
            keko.lisaaKekoon(jarjestettava[i]);
        }
    }
}
