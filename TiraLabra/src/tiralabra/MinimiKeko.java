/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

/**
 * Minimikeko heap-sorttia varten.
 *
 * @author lvapaaka
 */
public class MinimiKeko {

    private int[] keko;
    private int taulukonPituus;
    private int keonKoko;

    public MinimiKeko(int pituus) {
        taulukonPituus = pituus + 1;
        this.keko = new int[taulukonPituus];
        keonKoko = 0;
    }

    public MinimiKeko() {
        taulukonPituus = 10 + 1;
        this.keko = new int[taulukonPituus];
        keonKoko = 0;
    }

    /**
     * Keon jäsenen vanhemman palauttava metodi
     *
     * @param i keon jäsenen indeksi
     * @return
     */
    public int vanhempi(int i) {
        return i / 2;
    }

    /**
     * Keon jäsenen vasemman lapsen palauttava metodi
     *
     * @param i keon jäsenen indeksi
     * @return
     */
    public int vasen(int i) {
        return 2 * i;
    }

    /**
     * Keon jäsenen oikean lapsen palauttava metodi.
     *
     * @param i
     * @return
     */
    public int oikea(int i) {
        return 2 * i + 1;
    }

    /**
     * Toiselta nimeltään heapify, kekoa ylläpitävä metodi.
     * @param i 
     */
    public void keoista(int i) {
        int vasen = vasen(i);
        int oikea = oikea(i);
        int pienin;
        if (oikea <= keonKoko) {
            if (keko[vasen] < keko[oikea]) {
                pienin = vasen;
            } else {
                pienin = oikea;
            }
            if (keko[i] > keko[pienin]) {
                vaihda(i, pienin);
                keoista(pienin);
            }
        } else if (vasen == keonKoko && keko[i] > keko[vasen]) {
            vaihda(i, vasen);
        }
    }

    /**
     * Keon pienimmän arvon palauttava metodi.
     * @return 
     */
    public int minimi() {
        return keko[1];
    }

    /**
     * Kekoon oikealle paikalleen arvon lisäävä metodi.
     * @param k 
     */
    public void lisaaKekoon(int k) {
        keonKoko++;
        int i = keonKoko;
        while (i > 1 && keko[vanhempi(i)] > k) {
            keko[i] = keko[vanhempi(i)];
            i = vanhempi(i);
        }
        keko[i] = k;
    }

    /**
     * Keon pienimmän arvon poistava ja palauttava metodi,
     * @return 
     */
    public int poistaPieninKeosta() {
        int min = keko[1];
        keko[1] = keko[keonKoko];
        keonKoko--;
        keoista(1);
        return min;
    }

    /**
     * Kahden keon jäsenen paikkaa vaihtava metodi.
     * 
     * @param indeksi1
     * @param indeksi2 
     */
    public void vaihda(int indeksi1, int indeksi2) {
        int apu = keko[indeksi1];
        keko[indeksi1] = keko[indeksi2];
        keko[indeksi2] = apu;
    }

    /**
     * Keon karkeasti tulostava metodi.
     * @return 
     */
    public String printtaaKeko() {
        String palautettava = "";
        for (int i = 1; i < keko.length; i++) {
            palautettava += keko[i] + "\n";
        }
        return palautettava;
    }

    public int palautaArvoIndeksista(int i) {
        return keko[i];
    }

    public int getKeonKoko() {
        return keonKoko;
    }

    public void pienennaKekoa() {
        keonKoko--;
    }

    public int[] getKeko() {
        return keko;
    }
}
