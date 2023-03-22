package campus;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Modele du Design Pattern MVC
 * @author Stephane CHEVRIER
 * @version 0.0
 * @Date 2023-03-22
 *
 **/
public class Modele {

    /**
     * Variables d'instance
     */
    private int NombreATrouver;


    /**
     * Constructeurs
     * @param entierMini Entier mini
     * @param entierMaxi Entier maxi
     */
    public Modele(int entierMini, int entierMaxi) {
        Random entierAleatoire = new SecureRandom();
        this.NombreATrouver = entierAleatoire.nextInt(entierMaxi-entierMini+1)+entierMini;
    }
}
