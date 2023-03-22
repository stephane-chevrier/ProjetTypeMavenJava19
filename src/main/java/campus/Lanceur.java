package campus;

/**
 * Controleur-Lanceur du Design Pattern MVC
 * @author Stephane CHEVRIER
 * @version 0.0
 * @Date 2023-03-22
 *
 **/
public class Lanceur {

    /**
     * Creation objets
     */
    Afficheur afficheur = new AfficheurConsole();

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
    public Lanceur() {
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
            for (choixMenu c : choixMenu.values()) {
                afficheur.afficherMessageAvecSaut(c.toString());
            }

            // Saisie du choix
            saisie = afficheur.faitesVotreChoix();

            // Traitement exception si saisie n'est pas dans gameChoice
            try {

                switch (choixMenu.valueOf(saisie.toUpperCase())) {

                    case JOUER -> {
                    }

                    case PARAMETRES -> {
                    }

                    case QUITTER -> {
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
}
