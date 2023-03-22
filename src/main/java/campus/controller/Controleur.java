package campus.controller;

import campus.model.NombreAleatoire;
import campus.model.Parametres;
import campus.viewer.Afficheur;
import campus.viewer.AfficheurConsole;

/**
 * Controleur-Lanceur du Design Pattern MVC
 * @author Stephane CHEVRIER
 * @version 0.0
 * @Date 2023-03-22
 *
 **/
public class Controleur {

    /**
     * Creation objets
     */
    Afficheur afficheur = new AfficheurConsole();
    Parametres parametres = new Parametres(0,100);

    /**
     * définition des options possibles
     */
    private enum choixMenu {
        JOUER,
        PARAMETRES,
        QUITTER
    }

    /**
     * Constructeurs
     */
    public Controleur() {
    }

    /**
     * Méthode de lancement du jeu avec le menu principal
     */
    public void lancementJeu() {

        // variables locales et message de bienvenue
        String saisie;
        afficheur.afficherBienvenue();

        // Boucle tant que Quit n'est pas saisi
        do {

            // Affichage des jeux possible
            afficheur.afficherMenu();
            for (choixMenu c : choixMenu.values()) {
                afficheur.afficherMessageAvecSaut("  " + c.toString());
            }

            // Saisie du choix
            saisie = afficheur.faitesVotreChoix();

            // Traitement exception si saisie n'est pas dans gameChoice
            try {

                switch (choixMenu.valueOf(saisie.toUpperCase())) {

                    case JOUER -> {
                        jouer();
                    }

                    case PARAMETRES -> {
                        definirParametres();
                    }

                }

                // Traitement exception saisie non valide
            } catch (Exception e) {
                afficheur.afficherSaisieInvalide();
            }
        }

        // Fin boucle de sélection du jeu ou QUIT
        while (!(choixMenu.QUITTER.toString().equalsIgnoreCase(saisie))) ;

        // Message de fin du jeu
        afficheur.afficherFinDuJeu();

    }

    /**
     * Methode pour definir le mini et le maxi des valeurs cibles
     */
    private void definirParametres() {
        afficheur.afficherParametres(parametres.getEntierMini(), parametres.getEntierMaxi());
        parametres.setEntierMini(afficheur.saisieMini());
        do {
            parametres.setEntierMaxi(afficheur.saisieMaxi());
            if (parametres.getEntierMaxi() < parametres.getEntierMini()) {
                afficheur.afficherSaisieInvalide();
            }
        }
        while (parametres.getEntierMaxi() < parametres.getEntierMini());

    }

    private void jouer() {
        // initialisation des variables locales
        int valeur;
        int compteur = 0;
        boolean gagne = false;
        NombreAleatoire aDeviner = new NombreAleatoire(parametres.getEntierMini(), parametres.getEntierMaxi());
        afficheur.afficherNombreChoisi();
        // boucle de saisie
        do {
            valeur = afficheur.entrezValeur();

            if (valeur == -9999) {
                gagne = true;
            }
            compteur++;
            if (valeur > aDeviner.getNombre()) {
                afficheur.afficherTropPetit(valeur);
            } else if (valeur < aDeviner.getNombre()) {
                afficheur.afficherTropGrand(valeur);
            } else {
                afficheur.afficherGagne(compteur);
                gagne = true;
            }
        }
        while (!gagne);
        if (valeur != aDeviner.getNombre()) {
            afficheur.afficherPerdu(compteur-1);
        }
    }
}
