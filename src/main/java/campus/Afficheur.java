package campus;

/**
 * Interface Viewer Pattern MVC
 * @author Stephane CHEVRIER
 * @version 0.0
 * @Date 2023-03-22
 *
 **/
public interface Afficheur {

    void afficherMessage(String texte, boolean saut);
    void afficherMessageAvecSaut(String texte);
    String saisieTexte(String message);

    void afficherBienvenue();
    void afficherFinDuJeu();
    void afficherSaisieInvalide();

    String faitesVotreChoix();
}
