/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tekoalyt;

import tiralabra.Siirto;

/**
 * Tekoäly, joka on pääosin hyvä, mutta kokeilee toista tekoälyä pettämällä sen
 * aina välillä ja tutkimalla tuloksia.
 *
 * Jos toinen tekoäly pettää tarpeeksi monta kertaa, Kokeilija ei enää tee
 * yhteistyötä.
 *
 * @author lvapaaka
 */
public class Kokeilija extends AI {

    private Siirto edellinenSiirto;
    private int uhrausSiirtoja;

    public Kokeilija() {
        super("Kokeilija", Siirto.YHTEISTYO);
        edellinenSiirto = null;
        uhrausSiirtoja = 0;
    }

    /**
     * Tekoälyn muistia päivittävä metodi.
     *
     * @param vastustajanSiirto vastapuolen siirto
     */
    @Override
    public void vastaanotaSiirto(Siirto vastustajanSiirto) {
        Siirto kaksiSiirtoaSitten = edellinenSiirto;
        edellinenSiirto = seuraavaSiirto;
        if (vastustajanSiirto == Siirto.YHTEISTYO) {
            seuraavaSiirto = reagoiYhteistyohon(kaksiSiirtoaSitten);
        } else {
            seuraavaSiirto = reagoiPetokseen(kaksiSiirtoaSitten);
        }
    }

    /**
     * Yhteistyötilanteessa siirron päättävä metodi.
     *
     * Jos on tehty yhteistyötä tarpeeksi pitkään, petetään.
     *
     * Jos toinen tekoäly ei kostanut petokseen, petetään lisää.
     *
     * Muutoin tehdään yhteistyötä.
     *
     * @param kaksiSiirtoaSitten Tekoälyn oma siirto kaksi siirtoa sitten
     * @return Seuraava Siirto
     */
    private Siirto reagoiYhteistyohon(Siirto kaksiSiirtoaSitten) {
        if (kaksiSiirtoaSitten == Siirto.YHTEISTYO && edellinenSiirto == Siirto.YHTEISTYO) {
            return Siirto.PETOS;
        } else if (kaksiSiirtoaSitten == Siirto.PETOS) {
            return Siirto.PETOS;
        } else {
            return Siirto.YHTEISTYO;
        }
    }

    /**
     * Toisen tekoälyn pettäessä siirron päättävä metodi.
     *
     * Jos toinen vain kosti oman petoksen, tehdään yhteistyötä. Ellei olla oltu
     * jo mukavia liian monta kertaa.
     *
     * @param kaksiSiirtoaSitten Tekoälyn oma siirto kaksi vuoroa sitten
     * @return
     */
    private Siirto reagoiPetokseen(Siirto kaksiSiirtoaSitten) {
        if (kaksiSiirtoaSitten == Siirto.PETOS && uhrausSiirtoja < 5) {
            uhrausSiirtoja++;
            return Siirto.YHTEISTYO;
        } else {
            return Siirto.PETOS;
        }
    }

    @Override
    public void palautaAlkuperainenTila() {
        seuraavaSiirto = Siirto.YHTEISTYO;
        uhrausSiirtoja = 0;
    }
}
