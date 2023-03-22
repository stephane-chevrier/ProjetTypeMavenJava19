package campus;

/**
 * Interface Viewer Pattern MVC
 * @author Stephane CHEVRIER
 * @version 0.0
 * @Date 2023-03-22
 *
 **/
public interface Afficheur {

    void afficherMessageSansSaut(String texte);
    void afficherMessageAvecSaut(String texte);
    void afficherBienvenue();
    void afficherMenu();
    void afficherFinDuJeu();
    void afficherSaisieInvalide();
    void afficherParametres(int mini, int maxi);
    String saisieTexte(String message);
    int saisieEntier(String message);
    int SaisieMini();
    int SaisieMaxi();
    String faitesVotreChoix();
}
