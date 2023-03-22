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
//    private final Scanner clavier = new Scanner(System.in);

    /**
     * Initialisation des constantes des messages
     */
    private static final String
            MESSAGE_BIENVENUE = "Bienvenue sur le jeu 'Devinez mon numéro'",
            MESSAGE_MENU = "Menu :",
            MESSAGE_FAITES_VOTRE_CHOIX = "Entrez votre choix : ",
            MESSAGE_FIN = "Merci d'être venu, à bientôt !!!",
            MESSAGE_SAISIE_INVALIDE = "Votre saisie n'est pas correcte, recommencez.",
            MESSAGE_PARAMETRES_TEXTE1 = "Les parametres actuels sont : ",
            MESSAGE_PARAMETRES_TEXTE2 = "Saisissez la nouvelle ",
            MESSAGE_PARAMETRES_MINI = "Valeur minium : ",
            MESSAGE_PARAMETRES_MAXI = "Valeur maximum : ";

    public final String
            ESPACE = " ",
            TAB = ESPACE.repeat(2);

    /**
     * methodes d'affichage sur la console
     */
    public void afficherMessageSansSaut(String texte) {
        System.out.print(texte);
    }

    public void afficherMessageAvecSaut(String texte) {
        System.out.println(texte);
    }

    public void afficherBienvenue() {
        afficherMessageAvecSaut("");
        afficherMessageAvecSaut(MESSAGE_BIENVENUE);
    }

    public void afficherMenu() {
        afficherMessageAvecSaut("");
        afficherMessageAvecSaut(MESSAGE_MENU);
    }

    public void afficherFinDuJeu() {
        afficherMessageAvecSaut(MESSAGE_FIN);
    }

    public void afficherSaisieInvalide() {
        afficherMessageAvecSaut(MESSAGE_SAISIE_INVALIDE);
    }

    public void afficherParametres(int mini, int maxi) {
        afficherMessageAvecSaut("");
        afficherMessageAvecSaut(MESSAGE_PARAMETRES_TEXTE1);
        afficherMessageAvecSaut(TAB + MESSAGE_PARAMETRES_MINI + mini);
        afficherMessageAvecSaut(TAB + MESSAGE_PARAMETRES_MAXI + maxi);
    }

    /**
     * methodes de daisie au clavier
     */
    public String saisieTexte(String message) {
        Scanner clavier = new Scanner(System.in);
        afficherMessageSansSaut(message);
        return clavier.nextLine();
    }

    public int saisieEntier(String message) {
        Scanner clavier = new Scanner(System.in);
        afficherMessageSansSaut(message);
        try {
            return clavier.nextInt();
        } catch (Exception e) {
            afficherSaisieInvalide();
            return saisieEntier(message);
        }
    }

    public int SaisieMini() {
        return saisieEntier( MESSAGE_PARAMETRES_TEXTE2+MESSAGE_PARAMETRES_MINI);
    }

    public int SaisieMaxi() {
        return saisieEntier( MESSAGE_PARAMETRES_TEXTE2+MESSAGE_PARAMETRES_MAXI);
    }
    public String faitesVotreChoix() {
        return saisieTexte(MESSAGE_FAITES_VOTRE_CHOIX);
    }

}
