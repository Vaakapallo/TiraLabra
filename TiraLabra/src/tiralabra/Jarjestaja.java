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

    public int[] kekoJarjestaminen() {
        kasaaKeko();
        for (int i = jarjestettava.length; i > 1; i--) {
            keko.vaihda(1, i);
            keko.pienennaKekoa();
            keko.keoista(1);
        }
        return keko.palautaKeko();
    }

    private void kasaaKeko() {
        for (int i = 0; i < jarjestettava.length; i++) {
            keko.lisaaKekoon(jarjestettava[i]);
        }
    }
}
