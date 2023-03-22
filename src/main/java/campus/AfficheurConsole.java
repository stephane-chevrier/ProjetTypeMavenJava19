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
            MESSAGE_MENU = "Menu :",
            MESSAGE_FAITES_VOTRE_CHOIX = "Entrez votre choix : ",
            MESSAGE_FIN = "Merci d'être venu, à bientôt !!!",
            MESSAGE_SAISIE_INVALIDE = "Votre saisie n'est pas correcte, recommencez.",
            MESSAGE_PARAMETRES_TEXTE1 = "Les paramètres actuels sont : ",
            MESSAGE_PARAMETRES_TEXTE2 = "Saisissez la nouvelle ",
            MESSAGE_PARAMETRES_MINI = "Valeur minium : ",
            MESSAGE_PARAMETRES_MAXI = "Valeur maximum : ",
            MESSAGE_NOMBRE_CHOISI = "J'ai choisi le nombre à devinez, essayer de le trouver !",
            MESSAGE_ENTRER_VALEUR = "Entrez une valeur (-9999 pour quitter le jeu) : ",
            MESSAGE_PLUS_PETIT = "Le nombre à trouver est plus petit que ",
            MESSAGE_PLUS_GRAND = "Le nombre à trouver est plus grand que ",
            MESSAGE_GAGNE = "Bravo, vous avez gagné en ",
            MESSAGE_COUP = " coups.",
            MESSAGE_PERDU = "Vouz avez abandonné sans trouver le nombre à deviner, après avoir joué ";


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

    public void afficherTropPetit(int valeur) {
        afficherMessageAvecSaut(MESSAGE_PLUS_PETIT + valeur);
    }

    public void afficherTropGrand(int valeur) {
        afficherMessageAvecSaut(MESSAGE_PLUS_GRAND + valeur);
    }

    public void afficherNombreChoisi() {
        afficherMessageAvecSaut("");
        afficherMessageAvecSaut(MESSAGE_NOMBRE_CHOISI);
    }

    public void afficherGagne(int nombreCoups) {
        afficherMessageAvecSaut(MESSAGE_GAGNE + nombreCoups + MESSAGE_COUP);
    }

    public void afficherPerdu(int nombreCoups) {
        afficherMessageAvecSaut(MESSAGE_PERDU + nombreCoups + MESSAGE_COUP);
    }
    /**
     * methodes de daisie au clavier
     */
    public String saisieTexte(String message) {
        afficherMessageSansSaut(message);
        return clavier.nextLine();
    }

    public int saisieEntier(String message) {
        afficherMessageSansSaut(message);
        try {
            int saisie = clavier.nextInt();
            clavier.nextLine();
            return saisie;
        } catch (Exception e) {
            afficherSaisieInvalide();
            clavier.nextLine();
            return saisieEntier(message);
        }
    }

    public int saisieMini() {
        return saisieEntier( MESSAGE_PARAMETRES_TEXTE2+MESSAGE_PARAMETRES_MINI);
    }

    public int saisieMaxi() {
        return saisieEntier( MESSAGE_PARAMETRES_TEXTE2+MESSAGE_PARAMETRES_MAXI);
    }

    public String faitesVotreChoix() {
        return saisieTexte(MESSAGE_FAITES_VOTRE_CHOIX);
    }

    public int entrezValeur() {
        return saisieEntier(MESSAGE_ENTRER_VALEUR);
    }
}
