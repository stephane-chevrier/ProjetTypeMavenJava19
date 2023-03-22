package campus;

import java.util.Scanner;

/**
 * Viewer Console du Design Pattern MVC
 * @author Stephane CHEVRIER
 * @version 0.0
 * @Date 2023-03-22
 *
 **/
public class AfficheurConsole implements Afficheur {

    /**
     * Creation objets
     */
    private final Scanner clavier = new Scanner(System.in);

    /**
     * Initialisation des constantes des messages
     */
    private static final String
            MESSAGE_BIENVENUE = "Bienvenue sur le jeu 'Devinez mon numéro'",
            MESSAGE_FAITES_VOTRE_CHOIX = "Entrez votre choix : ",
            MESSAGE_FIN = "Merci d'être venu, à bientôt !!!",
            MESSAGE_SAISIE_INVALIDE = "Votre saisie n'est pas correcte, recommencez.";

    /**
     * initialisation des constantes generales
     */
    public final boolean
            AVEC_SAUT = true,
            SANS_SAUT = false;

    /**
     * methodes d'affichage sur la console
     */
    public void afficherMessage(String texte, boolean saut) {
        if (saut) {
            afficherMessageAvecSaut(texte);
        } else {
            System.out.print(texte);
        }
    }

    public void afficherMessageAvecSaut(String texte) {
        System.out.println(texte);
    }

    public void afficherBienvenue() {
        afficherMessage(MESSAGE_BIENVENUE, AVEC_SAUT);
    }

    public void afficherFinDuJeu() {
        afficherMessage(MESSAGE_FIN, AVEC_SAUT);
    }

    public void afficherSaisieInvalide() {
        afficherMessage(MESSAGE_SAISIE_INVALIDE, AVEC_SAUT);
    }

    /**
     * methodes de daisie au clavier
     */
    public String saisieTexte(String message) {
        afficherMessage(message, SANS_SAUT);
        return clavier.nextLine();
    }

    public String faitesVotreChoix() {
        return saisieTexte(MESSAGE_FAITES_VOTRE_CHOIX);
    }

}
